// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.vsphere.samples;

import com.vmware.sso.client.soaphandlers.WsSecuritySignatureAssertionHandler;
import com.vmware.sso.client.soaphandlers.SamlTokenHandler;
import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.vmware.vsphere.soaphandlers.HeaderCookieExtractionHandler;
import javax.xml.datatype.DatatypeConfigurationException;
import com.vmware.sso.client.samples.AcquireHoKTokenByUserCredentialSample;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.samples.AcquireBearerTokenByUserCredentialSample;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import org.w3c.dom.Node;
import com.vmware.sso.client.utils.Utils;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.HostnameVerifier;
import java.security.cert.X509Certificate;
import java.security.PrivateKey;
import org.w3c.dom.Element;
import javax.xml.ws.soap.SOAPFaultException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import com.vmware.vim25.ServiceContent;
import javax.xml.ws.handler.HandlerResolver;
import com.vmware.vim25.VimService;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.VimPortType;

public class LoginByTokenSample
{
    public static VimPortType vimPort;
    public static ManagedObjectReference SVC_INST_REF;
    private static VimService vimService;
    private static HandlerResolver defaultHandler;
    private static ServiceContent serviceContent;
    private static boolean isConnected;
    
    private static void clearHandlerResolver(final String s, final String s2) {
        LoginByTokenSample.vimService.setHandlerResolver(LoginByTokenSample.defaultHandler);
        LoginByTokenSample.vimPort = LoginByTokenSample.vimService.getVimPort();
        final Map<String, Object> requestContext = ((BindingProvider)LoginByTokenSample.vimPort).getRequestContext();
        requestContext.put("javax.xml.ws.service.endpoint.address", s);
        requestContext.put("javax.xml.ws.session.maintain", true);
        Map<?, ?> map = requestContext.get("javax.xml.ws.http.request.headers");
        if (map == null) {
            map = new HashMap<Object, Object>();
        }
        map.put("Cookie", Arrays.asList(s2));
        requestContext.put("javax.xml.ws.http.request.headers", map);
    }
    
    public static void getCurrentTime() {
        try {
            System.out.println("Server current time: " + new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss.SSSZ").format(LoginByTokenSample.vimPort.currentTime(LoginByTokenSample.SVC_INST_REF).toGregorianCalendar().getTime()));
        }
        catch (SOAPFaultException ex) {
            ex.printStackTrace();
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
        }
    }
    
    public static String loginUsingSAMLToken(final Element element, final String s, final PrivateKey privateKey, final X509Certificate x509Certificate) throws RuntimeFaultFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(final String s, final SSLSession sslSession) {
                return true;
            }
        });
        LoginByTokenSample.vimService = new VimService();
        LoginByTokenSample.SVC_INST_REF.setType("ServiceInstance");
        LoginByTokenSample.SVC_INST_REF.setValue("ServiceInstance");
        LoginByTokenSample.vimPort = LoginByTokenSample.vimService.getVimPort();
        final Map<String, Object> requestContext = ((BindingProvider)LoginByTokenSample.vimPort).getRequestContext();
        requestContext.put("javax.xml.ws.service.endpoint.address", s);
        requestContext.put("javax.xml.ws.session.maintain", false);
        LoginByTokenSample.serviceContent = LoginByTokenSample.vimPort.retrieveServiceContent(LoginByTokenSample.SVC_INST_REF);
        if (Utils.isHoKToken(element)) {
            return getSessionCookieUsingHokToken(element, s, privateKey, x509Certificate);
        }
        return getSessionCookieUsingBearerToken(element, s);
    }
    
    public static void logout() throws RuntimeFaultFaultMsg {
        if (LoginByTokenSample.isConnected) {
            LoginByTokenSample.vimPort.logout(LoginByTokenSample.serviceContent.getSessionManager());
        }
        System.out.println("Logged out....");
        LoginByTokenSample.isConnected = false;
    }
    
    public static void main(final String[] array) throws DatatypeConfigurationException, RuntimeFaultFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg {
        if (array.length < 4) {
            printUsage();
            return;
        }
        Utils.trustAllHttpsCertificates();
        System.out.println("Acquiring a bearer token using the AcquireBearerTokenByUserCredentialSample sample");
        final Element token = AcquireBearerTokenByUserCredentialSample.getToken(array);
        Utils.printToken(token);
        System.out.println("Bearer Token received....");
        System.out.println("Connecting to the vCenter " + array[3] + "....");
        System.out.println("Invoking the loginUsingSAMLToken method");
        loginUsingSAMLToken(token, array[3], null, null);
        System.out.println("Now getting the current time on the server....");
        getCurrentTime();
        logout();
        System.out.println("Acquiring a Holder-Of-Key token using the AcquireHoKTokenByUserCredentialSample sample....");
        final SecurityUtil loadFromDefaultFiles = SecurityUtil.loadFromDefaultFiles();
        final Element token2 = AcquireHoKTokenByUserCredentialSample.getToken(array, loadFromDefaultFiles.getPrivateKey(), loadFromDefaultFiles.getUserCert());
        Utils.printToken(token2);
        System.out.println("HoK Token received....");
        System.out.println("Connecting to the vCenter " + array[3] + "....");
        loginUsingSAMLToken(token2, array[3], loadFromDefaultFiles.getPrivateKey(), loadFromDefaultFiles.getUserCert());
        System.out.println("Now getting the current time on the server....");
        getCurrentTime();
        logout();
    }
    
    private static void printUsage() {
        System.out.println("run.bat com.vmware.vsphere.samples.LoginByTokenSample [sso url] [username] [password] [vCenter url]");
    }
    
    private static String getSessionCookieUsingBearerToken(final Element element, final String s) throws InvalidLocaleFaultMsg, InvalidLoginFaultMsg, RuntimeFaultFaultMsg {
        final HeaderCookieExtractionHandler headerCookieExtractionHandler = new HeaderCookieExtractionHandler();
        final HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
        handlerResolver.addHandler(new TimeStampHandler());
        handlerResolver.addHandler(new SamlTokenHandler(element));
        handlerResolver.addHandler(headerCookieExtractionHandler);
        LoginByTokenSample.vimService.setHandlerResolver((HandlerResolver)handlerResolver);
        LoginByTokenSample.vimPort = LoginByTokenSample.vimService.getVimPort();
        final Map<String, Object> requestContext = ((BindingProvider)LoginByTokenSample.vimPort).getRequestContext();
        requestContext.put("javax.xml.ws.service.endpoint.address", s);
        requestContext.put("javax.xml.ws.session.maintain", true);
        LoginByTokenSample.vimPort.loginByToken(LoginByTokenSample.serviceContent.getSessionManager(), (String)null);
        final String cookie = headerCookieExtractionHandler.getCookie();
        LoginByTokenSample.isConnected = true;
        clearHandlerResolver(s, cookie);
        return cookie;
    }
    
    private static String getSessionCookieUsingHokToken(final Element element, final String s, final PrivateKey privateKey, final X509Certificate x509Certificate) throws InvalidLocaleFaultMsg, InvalidLoginFaultMsg, RuntimeFaultFaultMsg {
        final HeaderCookieExtractionHandler headerCookieExtractionHandler = new HeaderCookieExtractionHandler();
        final HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
        handlerResolver.addHandler(new TimeStampHandler());
        handlerResolver.addHandler(new SamlTokenHandler(element));
        handlerResolver.addHandler(headerCookieExtractionHandler);
        handlerResolver.addHandler(new WsSecuritySignatureAssertionHandler(privateKey, x509Certificate, Utils.getNodeProperty(element, "ID")));
        LoginByTokenSample.vimService.setHandlerResolver((HandlerResolver)handlerResolver);
        LoginByTokenSample.vimPort = LoginByTokenSample.vimService.getVimPort();
        final Map<String, Object> requestContext = ((BindingProvider)LoginByTokenSample.vimPort).getRequestContext();
        requestContext.put("javax.xml.ws.service.endpoint.address", s);
        requestContext.put("javax.xml.ws.session.maintain", true);
        LoginByTokenSample.vimPort.loginByToken(LoginByTokenSample.serviceContent.getSessionManager(), (String)null);
        final String cookie = headerCookieExtractionHandler.getCookie();
        LoginByTokenSample.isConnected = true;
        clearHandlerResolver(s, cookie);
        return cookie;
    }
    
    static {
        LoginByTokenSample.SVC_INST_REF = new ManagedObjectReference();
        LoginByTokenSample.vimService = new VimService();
        LoginByTokenSample.defaultHandler = LoginByTokenSample.vimService.getHandlerResolver();
    }
}
