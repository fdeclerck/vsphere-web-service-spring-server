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
import com.rsa.names._2009._12.product.riat.wsdl.STSServicePortType;
import javax.xml.ws.BindingProvider;
import org.oasis_open.docs.ws_sx.ws_trust._200512.ValidateTargetType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import javax.xml.ws.handler.HandlerResolver;
import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import org.w3c.dom.Element;

public class ValidateTokenSample
{
    public static boolean isTokenValid(final String s, final Element any) throws DatatypeConfigurationException {
        final STSService stsService = new STSService();
        final HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
        handlerResolver.addHandler(new TimeStampHandler());
        stsService.setHandlerResolver((HandlerResolver)handlerResolver);
        final STSServicePortType stsServicePort = stsService.getSTSServicePort();
        final RequestSecurityTokenType requestSecurityTokenType = new RequestSecurityTokenType();
        requestSecurityTokenType.setTokenType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/RSTR/Status");
        requestSecurityTokenType.setRequestType("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Validate");
        final ValidateTargetType validateTarget = new ValidateTargetType();
        validateTarget.setAny(any);
        requestSecurityTokenType.setValidateTarget(validateTarget);
        ((BindingProvider)stsServicePort).getRequestContext().put("javax.xml.ws.service.endpoint.address", s);
        final String code = stsServicePort.validate(requestSecurityTokenType).getStatus().getCode();
        System.out.println("Token Status is determined to be " + code);
        return code.equalsIgnoreCase("http://docs.oasis-open.org/ws-sx/ws-trust/200512/status/valid");
    }
    
    private static void printUsage() {
        System.out.println("run.bat com.vmware.sso.client.samples.ValidateTokenSample [sso url] [username] [password]");
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
        System.out.println("Acquiring bearer token using AcquireBearerTokenByUserCredentialSample sample");
        final Element token = AcquireBearerTokenByUserCredentialSample.getToken(array);
        Utils.printToken(token);
        System.out.println("Validating the acquired token");
        System.out.println("The bearer token is " + (isTokenValid(array[0], token) ? "valid" : "invalid"));
        System.out.println("\nAcquiring HoK token using AcquireHoKTokenByUserCredentialSample sample");
        final SecurityUtil loadFromDefaultFiles = SecurityUtil.loadFromDefaultFiles();
        final Element token2 = AcquireHoKTokenByUserCredentialSample.getToken(array, loadFromDefaultFiles.getPrivateKey(), loadFromDefaultFiles.getUserCert());
        Utils.printToken(token2);
        System.out.println("Validating the acquired token");
        System.out.println("The HoK token is " + (isTokenValid(array[0], token2) ? "valid" : "invalid"));
    }
}
