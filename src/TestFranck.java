/*
 * ******************************************************
 * Copyright VMware, Inc. 2010-2012.  All Rights Reserved.
 * ******************************************************
 *
 * DISCLAIMER. THIS PROGRAM IS PROVIDED TO YOU "AS IS" WITHOUT
 * WARRANTIES OR CONDITIONS # OF ANY KIND, WHETHER ORAL OR WRITTEN,
 * EXPRESS OR IMPLIED. THE AUTHOR SPECIFICALLY # DISCLAIMS ANY IMPLIED
 * WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY # QUALITY,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE.
 */

package fr.f74;

//import com.vmware.common.annotations.Action;
//import com.vmware.common.annotations.Sample;
import com.vmware.connection.ConnectedVimServiceBase;
import com.vmware.vim25.AboutInfo;
//import com.vmware.vim25.RuntimeFaultFaultMsg;
//import com.vmware.vim25.AboutInfo;
import com.vmware.vim25.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import fr.f74.AcquireHoKTokenByUserCredentialSample;
import fr.f74.connection.helpers.builders.*;

//import static com.vmware.sso.client.samples.AcquireHoKTokenByUserCredentialSample.getToken;
//import com.vmware.GetCurrentTime;
//import com.vmware.connection.ConnectedVimServiceBase;
import com.vmware.connection.Connection;
import com.vmware.connection.SsoConnection;
import com.vmware.connection.BasicConnection;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vmware.sso.client.soaphandlers.*;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;
import com.vmware.vim25.*;
import com.vmware.vsphere.soaphandlers.HeaderCookieExtractionHandler;
import org.w3c.dom.Element;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vmware.sso.client.soaphandlers.*;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;
import com.vmware.vim25.*;
import com.vmware.vsphere.soaphandlers.HeaderCookieExtractionHandler;

//import static com.vmware.sso.client.samples.AcquireHoKTokenByUserCredentialSample.getToken;
import static fr.f74.AcquireHoKTokenByUserCredentialSample.getToken;

/**
 * <pre>
 * GetCurrentTime
 *
 * This sample gets the current time of the vSphere Server
 *
 * <b>Parameters:</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 *
 * <b>Command Line:</b>
 * run.bat com.vmware.general.GetCurrentTime
 * --url [webservicesurl] --username [Username] --password [password]
 * </pre>
 */
@RestController
public class TestFranck extends SsoConnection {

    private static final Logger log = LoggerFactory.getLogger(TestFranck.class);

    VimService vimService;
    VimPortType vimPort;
    ServiceContent serviceContent;
    UserSession userSession;
    ManagedObjectReference svcInstRef = null;
    String url = "https://10.200.19.122/sdk";
    String username = "visu2016";
    String password = "visu@vsphere.local"; 
    String STSurl = "https://10.200.19.122/sts/STSService"; 
    String[] argsCnx = {"https://10.200.19.122/sts/STSService","visu@vsphere.local","visu2016"} ;
    URL ssoUrl = null;
    @SuppressWarnings("rawtypes")
    Map headers;
    PrivateKey privateKey;
    X509Certificate certificate;  

    private ManagedObjectReference propCollectorRef; 

    //HttpsURLConnection.setDefaultHostnameVerifier(hv);
            
    //Utils.trustAllHttpsCertificates();

    @RequestMapping("/ssoconnect")
    public String ssoconnect() {

        final TestFranck ssoconnection = new TestFranck();

        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String urlHostName, SSLSession session) {
                return true;
            }
        };

        try {
            HttpsURLConnection.setDefaultHostnameVerifier(hv);

            Utils.trustAllHttpsCertificates();
            
            loadUserCert();
    
            ssoconnection.connect();
        } catch (Exception e) {
            throw new SSOLoginException("login fault", (e.getCause() != null)?e.getCause():e);
        }

        return "ssoconnected";
    }

    @Override
    public Element login() {
        Element token = null;
        try {
            //String[] args = {getSsoUrl().toString(), username, password};
            String[] argsCnx = {"https://10.200.19.122/sts/STSService","visu@vsphere.local","visu2016"} ;
            
            String[] args = argsCnx;
            SecurityUtil userCert = SecurityUtil.loadFromDefaultFiles();    
            
            privateKey = userCert.getPrivateKey();
            certificate = userCert.getUserCert();
            token = getToken(args, privateKey, certificate);
            Utils.printToken(token);
        } catch (Exception e) {
            throw new SSOLoginException("login fault", (e.getCause() != null)?e.getCause():e);
        }
        return token;
    }

    @Override
    public void loadUserCert() throws Exception{
        SecurityUtil userCert = SecurityUtil.loadFromDefaultFiles();    
            
            privateKey = userCert.getPrivateKey();
            certificate = userCert.getUserCert();
        return;
    }

    @Override
    public Connection connect() {
        if (!isConnected()) {
            try {
                this._connection();
            } catch (Exception e) {
                Throwable cause = (e.getCause() != null)?e.getCause():e;
                throw new SSOLoginException(
                        "could not connect: " + e.getMessage() + " : " + cause.getMessage(), cause
                );
            }
        }
        return this;
    }

    @SuppressWarnings("rawtypes")
	private void _connection() throws RuntimeFaultFaultMsg, InvalidLocaleFaultMsg, InvalidLoginFaultMsg, Exception {

        Element token = this.login();
        Utils.printToken(token);
        HeaderCookieExtractionHandler cookieExtracter = new HeaderCookieExtractionHandler();
        System.out.println("setupVimService(token, cookieExtracter)");
        vimService = setupVimService(token, cookieExtracter);
        System.out.println("vimService.getVimPort()");
        vimPort = vimService.getVimPort();
        System.out.println("getRequestContext()");
        Map<String, Object> ctxt =
                ((BindingProvider) vimPort).getRequestContext();
        System.out.println("ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url.toString())");
        ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
        System.out.println("serviceContent = vimPort.retrieveServiceContent(this.getServiceInstanceReference())");
        serviceContent = vimPort.retrieveServiceContent(this.getServiceInstanceReference());
        System.out.println("propCollectorRef = serviceContent.getPropertyCollector()");
        propCollectorRef = serviceContent.getPropertyCollector();
        XMLGregorianCalendar ct = vimPort.currentTime(this.getServiceInstanceReference());
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss.SSSZ");
        System.out.println("Server current time: "
                + sdf.format(ct.toGregorianCalendar().getTime()));
        //return sdf.format(ct.toGregorianCalendar().getTime());
    }

    @Override
    public String getServiceInstanceName() {
        return "ServiceInstanceTestFranck"; // Theoretically this could change but it never does in these samples.
    }

    /**
     * the cached headers gleaned from the last connection atttempt
     * @return
     */
    @SuppressWarnings("rawtypes")
	@Override
    public Map getHeaders() {
        return this.headers;
    }

    @Override
    public ManagedObjectReference getServiceInstanceReference() {
        if (svcInstRef == null) {
            ManagedObjectReference ref = new ManagedObjectReference();
            ref.setType(this.getServiceInstanceName());
            ref.setValue(this.getServiceInstanceName());
            svcInstRef = ref;
        }
        return this.svcInstRef;
    }
    //@Action
    @RequestMapping("/connect")
    public String fairechose() {
         return  "fairechose";
    }

    @RequestMapping("/test")
    public String index() {
    return "Greetings from TestFranck";
    }

    @RequestMapping("/test2")
    public String index2() {
    return "Greetings2 from TestFranck";
    }

    @Override
    public VimService getVimService() {
        return this.vimService;
    }

    @Override
    public VimPortType getVimPort() {
        return this.vimPort;
    }

    @Override
    public ServiceContent getServiceContent() {
        return this.serviceContent;
    }

    public VimService setupVimService(Element token, PrivateKey privateKey, X509Certificate certificate, SSOHeaderHandler... handlers) {
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
    }

    public String getCurrentTime() throws RuntimeFaultFaultMsg {
        XMLGregorianCalendar ct = vimPort.currentTime(this.getServiceInstanceReference());
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss.SSSZ");
        System.out.println("Server current time: "
                + sdf.format(ct.toGregorianCalendar().getTime()));
        return sdf.format(ct.toGregorianCalendar().getTime());
    }
}

/* public class TestFranck {

    @Action
    public void testconnect() throws RuntimeFaultFaultMsg {
        HostnameVerifier hv = new HostnameVerifier() {
                @Override
                public boolean verify(String urlHostName, SSLSession session) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            Utils.trustAllHttpsCertificates();

                String username = "visu2016";
                String password = "visu@vsphere.local"; 
                String STSurl = "https://10.200.19.122/sts/STSService"; 
                
                String[] argsCnx = {"https://10.200.19.122/sts/STSService","visu@vsphere.local","visu2016"} ;

                SecurityUtil userCert = SecurityUtil.loadFromDefaultFiles();
                System.out.println("SsoConnection");                
                SsoConnection connect = new SsoConnection();   
                //BasicConnection connect = new BasicConnection();   
                
                connect.setUrl("https://10.200.19.122/sts/STSService");
                connect.setPassword("visu2016"); 
                connect.setUsername("visu@vsphere.local");
                System.out.println("SsoConnection.coonect()"); 
                connect.connect(); 
                Utils.printToken(connect.login());
                System.out
                        .println("getServiceInstanceName : "
                                + connect.getServiceInstanceName());
            }

} */