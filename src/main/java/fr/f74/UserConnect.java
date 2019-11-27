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
/* import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException; */

//import org.w3c.dom.Element;

import com.vmware.sso.client.samples.AcquireBearerTokenByUserCredentialSample;
import com.vmware.sso.client.samples.AcquireHoKTokenByUserCredentialSample;
import com.vmware.sso.client.soaphandlers.HeaderHandlerResolver;
import com.vmware.sso.client.soaphandlers.SamlTokenHandler;
import com.vmware.sso.client.soaphandlers.TimeStampHandler;
import com.vmware.sso.client.soaphandlers.WsSecuritySignatureAssertionHandler;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;
/* import com.vmware.vim25.InvalidLocaleFaultMsg;
import com.vmware.vim25.InvalidLoginFaultMsg;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFaultFaultMsg;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.VimPortType;
import com.vmware.vim25.VimService; */
//import com.vmware.vsphere.soaphandlers.HeaderCookieExtractionHandler;
//fin de login

@Component
public class UserConnect {

    @Autowired
    private UserProfile userProfile;

    @Autowired
    private AcquireHoKTokenByUserCredential acquireHoKTokenByUserCredential;

    @Autowired
    private LoginByToken loginByToken;

    public String connect() {

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
            //loginByToken.getSessionCookieUsingHokToken(token, userProfile.getUrl(),userProfile.getPrivateKey(), userProfile.getCertificate());
            String Cookie = loginByToken.loginUsingSAMLToken(token,userProfile.getUrl(),userProfile.getPrivateKey(), userProfile.getCertificate());
            loginByToken.getCurrentTime();
            loginByToken.logout();



        } catch (Exception e) {
            //throw new SSOLoginException("login fault", (e.getCause() != null)?e.getCause():e);
            System.out.println("userconnect() exception : " + e.getMessage());
            
        }
        
        return "userconnect";

    }
    
/*     public VimService setupVimService(Element token, SSOHeaderHandler... handlers) {
        VimService vimSvc = new VimService();
        HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
        handlerResolver.addHandler(new TimeStampHandler());
        handlerResolver.addHandler(new SamlTokenHandler(token));
        handlerResolver.addHandler(new WsSecuritySignatureAssertionHandler(
                privateKey, certificate, Utils
                .getNodeProperty(token, "ID")));
        for (SSOHeaderHandler handler : handlers) {
            handlerResolver.addHandler(handler);
        }
        vimSvc.setHandlerResolver(handlerResolver);
        return vimSvc;
    } */
}