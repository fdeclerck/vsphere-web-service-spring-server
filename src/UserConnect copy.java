package fr.f74;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.vmware.sso.client.utils.Utils;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.connection.Connection;
import com.vmware.connection.SsoConnection;
import com.vmware.connection.SsoConnection.SSOLoginException;

import org.w3c.dom.Element;

//de login
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;

//import org.w3c.dom.Element;

import com.vmware.sso.client.samples.AcquireBearerTokenByUserCredentialSample;
import com.vmware.sso.client.samples.AcquireHoKTokenByUserCredentialSample;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.vmware.sso.client.soaphandlers.SamlTokenHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.WsSecuritySignatureAssertionHandler;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;
import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService;
import com.vmware.vsphere.soaphandlers.HeaderCookieExtractionHandler;
//fin de login

@RestController
public class UserConnect {

    //@Autowired
    private UserProfile userProfile;

   //@Autowired
    private AcquireHoKTokenByUserCredential acquireHoKTokenByUserCredential;

   /*  public static VimPortType vimPort;
    public static ManagedObjectReference SVC_INST_REF = new ManagedObjectReference();
    private static VimService vimService = new VimService();
    private static HandlerResolver defaultHandler = vimService.getHandlerResolver();
 
    private static ServiceContent serviceContent;
    private static boolean isConnected; */

    @RequestMapping("/userconnect")
    public String userconnect() {

        HostnameVerifier hv = new HostnameVerifier() {
        @Override
        public boolean verify(String urlHostName, SSLSession session) {
            return true;
        }
        };

        try {

            HttpsURLConnection.setDefaultHostnameVerifier(hv);

            Utils.trustAllHttpsCertificates();
            
            //loadUserCert();

            //ssoconnection.connect();

            userProfile.setPrivateKey();
            userProfile.setCertificate();
            System.out.println("token = acquireHoKTokenByUserCredential.getToken");
            Element token = acquireHoKTokenByUserCredential.getToken(userProfile.getArgsCnx(), userProfile.getPrivateKey(), userProfile.getCertificate());
            Utils.printToken(token);
            //loginUsingSAMLToken(token,userProfile.getUrl(),userProfile.getPrivateKey(), userProfile.getCertificate());


        } catch (Exception e) {
            //throw new SSOLoginException("login fault", (e.getCause() != null)?e.getCause():e);
            System.out.println("userconnect() exception");
            
        }

        return "userconnect";
    }

    public static String loginUsingSAMLToken(Element token, String vcServerUrl,
         PrivateKey privateKey, X509Certificate publicCert)
         throws RuntimeFaultFaultMsg, InvalidLocaleFaultMsg,
         InvalidLoginFaultMsg {

      // Setting up the configuration for ignoring the SSL certificates
      HostnameVerifier hv = new HostnameVerifier() {
         @Override
         public boolean verify(String urlHostName, SSLSession session) {
            return true;
         }
      };
      HttpsURLConnection.setDefaultHostnameVerifier(hv);
      System.out.println("vimService = new VimService();");
      vimService = new VimService();
      // Step 1 Retrieve the service content
      SVC_INST_REF.setType("ServiceInstance");
      SVC_INST_REF.setValue("ServiceInstance");
      System.out.println("vimService.getVimPort();");
      vimPort = vimService.getVimPort();

      Map<String, Object> ctxt =
            ((BindingProvider) vimPort).getRequestContext();
      ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
      ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, false);
      System.out.println("serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF;");
      serviceContent = vimPort.retrieveServiceContent(SVC_INST_REF);

      if (Utils.isHoKToken(token)) {
         return getSessionCookieUsingHokToken(token, vcServerUrl, privateKey,
               publicCert);
      } else {
         return getSessionCookieUsingBearerToken(token, vcServerUrl);
      }
   }

   private static String getSessionCookieUsingBearerToken(Element token,
         String vcServerUrl) throws InvalidLocaleFaultMsg,
         InvalidLoginFaultMsg, RuntimeFaultFaultMsg {

      // Step 2 Invoking the loginByToken method
	  HeaderCookieExtractionHandler cookieExtractor =
         new HeaderCookieExtractionHandler();
      {
         HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
         handlerResolver.addHandler(new TimeStampHandler());
         handlerResolver.addHandler(new SamlTokenHandler(token));
         handlerResolver.addHandler(cookieExtractor);
         vimService.setHandlerResolver(handlerResolver);
      }
      vimPort = vimService.getVimPort();

      Map<String, Object> ctxt =
            ((BindingProvider) vimPort).getRequestContext();
      ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
      ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

      vimPort.loginByToken(serviceContent.getSessionManager(), null);
      String cookie = cookieExtractor.getCookie();
      isConnected = true;
      // Step 3 Now perform some task as the authenticated user
      clearHandlerResolver(vcServerUrl, cookie);
      return cookie;
   }

   /**
    * Method that sets up the HandlerResolver chain for the HolderOfKey tokens
    *
    * @param token
    *           {@link Element} representing the Bearer SAML token
    * @param vcServerUrl
    *           The vCenter server url that needs to be connected
    * @param publicCert
    * @param privateKey
    * @return String authenticated session cookie used by the connection
    * @throws InvalidLocaleFaultMsg
    * @throws InvalidLoginFaultMsg
    * @throws RuntimeFaultFaultMsg
    */
   private static String getSessionCookieUsingHokToken(Element token,
         String vcServerUrl, PrivateKey privateKey,
         X509Certificate publicCert) throws InvalidLocaleFaultMsg,
         InvalidLoginFaultMsg, RuntimeFaultFaultMsg {

      // Step 2 Invoking the loginByToken method
	  HeaderCookieExtractionHandler cookieExtractor =
         new HeaderCookieExtractionHandler();
      {
         HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
         handlerResolver.addHandler(new TimeStampHandler());
         handlerResolver.addHandler(new SamlTokenHandler(token));
         handlerResolver.addHandler(cookieExtractor);
         handlerResolver.addHandler(new WsSecuritySignatureAssertionHandler(
               privateKey, publicCert, Utils.getNodeProperty(token, "ID")));
         vimService.setHandlerResolver(handlerResolver);
      }
      vimPort = vimService.getVimPort();

      Map<String, Object> ctxt =
            ((BindingProvider) vimPort).getRequestContext();
      ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
      ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

      vimPort.loginByToken(serviceContent.getSessionManager(), null);
      String cookie = cookieExtractor.getCookie();
      isConnected = true;
      // Step 3 Now perform some task as the authenticated user
      clearHandlerResolver(vcServerUrl, cookie);
      return cookie;
   }

   private static void clearHandlerResolver(String vcServerUrl, String cookie) {
    // After login we do not need this handler thus reverting to the
    // original one
    vimService.setHandlerResolver(defaultHandler);
    vimPort = vimService.getVimPort();
    // Set the validated session cookie and set it in the header for once,
    // JAXWS will maintain that cookie for all the subsequent requests
    {
       Map<String, Object> ctxt =
             ((BindingProvider) vimPort).getRequestContext();
       ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, vcServerUrl);
       ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
       // One time setting of the cookie
       @SuppressWarnings("unchecked")
       Map<String, List<String>> headers =
             (Map<String, List<String>>) ctxt
                   .get(MessageContext.HTTP_REQUEST_HEADERS);
       if (headers == null) {
          headers = new HashMap<String, List<String>>();
       }
       headers.put("Cookie", Arrays.asList(cookie));
       ctxt.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
    }
 }

}