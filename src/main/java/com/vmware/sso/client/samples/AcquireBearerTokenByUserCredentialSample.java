// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.sso.client.samples;

import com.vmware.sso.client.utils.Utils;
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
import com.vmware.sso.client.soaphandlers.SamlTokenExtractionHandler;
import com.vmware.sso.client.soaphandlers.UserCredentialHandler;
import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import org.w3c.dom.Element;

public class AcquireBearerTokenByUserCredentialSample
{
    public static Element getToken(final String[] array) throws DatatypeConfigurationException {
        final STSService stsService = new STSService();
        final HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
        handlerResolver.addHandler(new TimeStampHandler());
        final UserCredentialHandler userCredentialHandler = new UserCredentialHandler(array[1], array[2]);
        final SamlTokenExtractionHandler samlTokenExtractionHandler = new SamlTokenExtractionHandler();
        handlerResolver.addHandler(userCredentialHandler);
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
        xmlGregorianCalendar.add(instance.newDuration(1800000L));
        expires.setValue(xmlGregorianCalendar.toXMLFormat());
        lifetime.setCreated(created);
        lifetime.setExpires(expires);
        requestSecurityTokenType.setTokenType("urn:oasis:names:tc:SAML:2.0:assertion");
        requestSecurityTokenType.setRequestType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue");
        requestSecurityTokenType.setLifetime(lifetime);
        requestSecurityTokenType.setKeyType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Bearer");
        requestSecurityTokenType.setSignatureAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");
        requestSecurityTokenType.setDelegatable(Boolean.valueOf(true));
        final RenewingType renewing = new RenewingType();
        renewing.setAllow(Boolean.FALSE);
        renewing.setOK(Boolean.FALSE);
        requestSecurityTokenType.setRenewing(renewing);
        ((BindingProvider)stsServicePort).getRequestContext().put("javax.xml.ws.service.endpoint.address", array[0]);
        stsServicePort.issue(requestSecurityTokenType);
        return samlTokenExtractionHandler.getToken();
    }
    
    private static void printUsage() {
        System.out.println("run.bat com.vmware.sso.client.samples.AcquireBearerTokenByUserCredentialSample [sso url] [username] [password]");
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
        System.out.println("Aquiring a bearer token by using user credentials");
        Utils.printToken(getToken(array));
    }
}
