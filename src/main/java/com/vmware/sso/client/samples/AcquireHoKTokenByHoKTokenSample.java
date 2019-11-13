// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.sso.client.samples;

import com.vmware.sso.client.utils.SecurityUtil;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.HostnameVerifier;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import com.rsa.names._2009._12.product.riat.wsdl.STSServicePortType;
import javax.xml.ws.BindingProvider;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RenewingType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeFactory;
import org.oasis_open.docs.ws_sx.ws_trust._200512.LifetimeType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import javax.xml.ws.handler.HandlerResolver;
import com.vmware.sso.client.soaphandlers.WsSecuritySignatureAssertionHandler;
import com.vmware.sso.client.utils.Utils;
import com.vmware.sso.client.soaphandlers.SamlTokenExtractionHandler;
import org.w3c.dom.Node;
import com.vmware.sso.client.soaphandlers.SamlTokenHandler;
import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import java.security.cert.X509Certificate;
import java.security.PrivateKey;
import org.w3c.dom.Element;

public class AcquireHoKTokenByHoKTokenSample
{
    public static Element getToken(final String s, final Element element, final PrivateKey privateKey, final X509Certificate x509Certificate) throws DatatypeConfigurationException {
        final STSService stsService = new STSService();
        final HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
        handlerResolver.addHandler(new TimeStampHandler());
        handlerResolver.addHandler(new SamlTokenHandler(element));
        final SamlTokenExtractionHandler samlTokenExtractionHandler = new SamlTokenExtractionHandler();
        handlerResolver.addHandler(samlTokenExtractionHandler);
        handlerResolver.addHandler(new WsSecuritySignatureAssertionHandler(privateKey, x509Certificate, Utils.getNodeProperty(element, "ID")));
        stsService.setHandlerResolver((HandlerResolver)handlerResolver);
        final STSServicePortType stsServicePort = stsService.getSTSServicePort();
        final RequestSecurityTokenType requestSecurityTokenType = new RequestSecurityTokenType();
        final LifetimeType lifetime = new LifetimeType();
        final DatatypeFactory instance = DatatypeFactory.newInstance();
        final XMLGregorianCalendar xmlGregorianCalendar = instance.newXMLGregorianCalendar(new GregorianCalendar(TimeZone.getTimeZone("GMT")));
        final AttributedDateTime created = new AttributedDateTime();
        created.setValue(xmlGregorianCalendar.toXMLFormat());
        final AttributedDateTime expires = new AttributedDateTime();
        xmlGregorianCalendar.add(instance.newDuration(1800000L));
        expires.setValue(xmlGregorianCalendar.toXMLFormat());
        lifetime.setCreated(created);
        lifetime.setExpires(expires);
        requestSecurityTokenType.setLifetime(lifetime);
        requestSecurityTokenType.setTokenType("urn:oasis:names:tc:SAML:2.0:assertion");
        requestSecurityTokenType.setRequestType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue");
        requestSecurityTokenType.setKeyType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/PublicKey");
        requestSecurityTokenType.setSignatureAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");
        final RenewingType renewing = new RenewingType();
        renewing.setAllow(Boolean.FALSE);
        renewing.setOK(Boolean.FALSE);
        requestSecurityTokenType.setRenewing(renewing);
        ((BindingProvider)stsServicePort).getRequestContext().put("javax.xml.ws.service.endpoint.address", s);
        stsServicePort.issue(requestSecurityTokenType);
        return samlTokenExtractionHandler.getToken();
    }
    
    private static void printUsage() {
        System.out.println("run.bat com.vmware.sso.client.samples.AcquireHoKTokenByHoKTokenSample [sso url] [username] [password]");
    }
    
    public static void main(final String[] array) throws DatatypeConfigurationException {
        if (array.length < 3) {
            printUsage();
            return;
        }
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(final String s, final SSLSession sslSession) {
                return true;
            }
        });
        Utils.trustAllHttpsCertificates();
        System.out.println("Aquiring a HoK token by using another HoK token acquired using user credentials");
        final SecurityUtil loadFromDefaultFiles = SecurityUtil.loadFromDefaultFiles();
        final Element token = AcquireHoKTokenByUserCredentialSample.getToken(array, loadFromDefaultFiles.getPrivateKey(), loadFromDefaultFiles.getUserCert());
        System.out.println("*****Original token issued*****");
        Utils.printToken(token);
        System.out.println("*****Additional token issued*****");
        Utils.printToken(getToken(array[0], token, loadFromDefaultFiles.getPrivateKey(), loadFromDefaultFiles.getUserCert()));
    }
}
