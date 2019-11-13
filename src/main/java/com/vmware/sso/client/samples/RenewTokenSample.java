// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.sso.client.samples;

import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.HostnameVerifier;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import com.rsa.names._2009._12.product.riat.wsdl.STSServicePortType;
import javax.xml.ws.BindingProvider;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RenewTargetType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeFactory;
import org.oasis_open.docs.ws_sx.ws_trust._200512.LifetimeType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import javax.xml.ws.handler.HandlerResolver;
import com.vmware.sso.client.soaphandlers.SamlTokenExtractionHandler;
import com.vmware.sso.client.soaphandlers.WsSecurityUserCertificateSignatureHandler;
import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import java.security.cert.X509Certificate;
import java.security.PrivateKey;
import org.w3c.dom.Element;

public class RenewTokenSample
{
    public static Element renewToken(final String s, final Element any, final PrivateKey privateKey, final X509Certificate x509Certificate, final long n) throws DatatypeConfigurationException {
        final STSService stsService = new STSService();
        final HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
        handlerResolver.addHandler(new TimeStampHandler());
        handlerResolver.addHandler(new WsSecurityUserCertificateSignatureHandler(privateKey, x509Certificate));
        final SamlTokenExtractionHandler samlTokenExtractionHandler = new SamlTokenExtractionHandler();
        handlerResolver.addHandler(samlTokenExtractionHandler);
        stsService.setHandlerResolver((HandlerResolver)handlerResolver);
        final STSServicePortType stsServicePort = stsService.getSTSServicePort();
        final RequestSecurityTokenType requestSecurityTokenType = new RequestSecurityTokenType();
        final LifetimeType lifetime = new LifetimeType();
        final DatatypeFactory instance = DatatypeFactory.newInstance();
        final XMLGregorianCalendar xmlGregorianCalendar = instance.newXMLGregorianCalendar(new GregorianCalendar(TimeZone.getTimeZone("GMT")));
        final AttributedDateTime created = new AttributedDateTime();
        created.setValue(xmlGregorianCalendar.toXMLFormat());
        final AttributedDateTime expires = new AttributedDateTime();
        xmlGregorianCalendar.add(instance.newDuration(n * 1000L));
        expires.setValue(xmlGregorianCalendar.toXMLFormat());
        lifetime.setCreated(created);
        lifetime.setExpires(expires);
        requestSecurityTokenType.setLifetime(lifetime);
        requestSecurityTokenType.setTokenType("urn:oasis:names:tc:SAML:2.0:assertion");
        requestSecurityTokenType.setRequestType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Renew");
        final RenewTargetType renewTarget = new RenewTargetType();
        renewTarget.setAny(any);
        requestSecurityTokenType.setRenewTarget(renewTarget);
        ((BindingProvider)stsServicePort).getRequestContext().put("javax.xml.ws.service.endpoint.address", s);
        stsServicePort.renew(requestSecurityTokenType);
        return samlTokenExtractionHandler.getToken();
    }
    
    private static void printUsage() {
        System.out.println("run.bat com.vmware.sso.client.samples.RenewTokenSample [sso url] [username] [password] [durationInSeconds]");
    }
    
    public static void main(final String[] array) throws DatatypeConfigurationException, InterruptedException {
        if (array.length < 4) {
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
        System.out.println("Inital token acquired using AcquireHoKTokenByUserCredentialSample sample");
        final SecurityUtil loadFromDefaultFiles = SecurityUtil.loadFromDefaultFiles();
        final Element token = AcquireHoKTokenByUserCredentialSample.getToken(array, loadFromDefaultFiles.getPrivateKey(), loadFromDefaultFiles.getUserCert());
        System.out.println("*****Original token issued*****");
        Utils.printToken(token);
        Thread.sleep(5000L);
        System.out.println("Renewing the token");
        System.out.println("*****Renewed token*****");
        Utils.printToken(renewToken(array[0], token, loadFromDefaultFiles.getPrivateKey(), loadFromDefaultFiles.getUserCert(), Long.parseLong(array[3])));
    }
}
