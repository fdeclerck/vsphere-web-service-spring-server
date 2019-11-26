package fr.f74;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import com.rsa.names._2009._12.product.riat.wsdl.STSServicePortType;
import com.vmware.sso.client.soaphandlers.*; */
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;
/* import org.oasis_open.docs.ws_sx.ws_trust._200512.LifetimeType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RenewingType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import org.w3c.dom.Element;
 */

import java.util.Arrays; 

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TimeZone; */

// import java.lang.reflect.InvocationTargetException;
// import com.vmware.common.samples.registry.SampleReference;
/* import java.util.Arrays;
import java.net.URI;
import java.net.URL;
import javax.xml.ws.soap.SOAPFaultException; */
// import com.vmware.common.samples.SampleException;
// import com.vmware.common.samples.reflection.SampleReflectionException;
// import com.vmware.common.samples.registry.SampleNotFoundException;
// import com.vmware.common.samples.SampleRegistry;
/* import java.io.FilenameFilter;
import java.util.List;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.LinkedList;
import java.io.File; */
// import com.vmware.common.samples.registry.SampleExecutionRecord;
// import java.util.Iterator;
// import com.vmware.common.samples.reflection.UnregisteredSampleHandler;
/* import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException; */
// import com.vmware.common.ssl.TrustAll;
// import com.vmware.common.samples.SystemParameters;

//import fr.f74.AcquireHoKTokenByUserCredentialSample;
import fr.f74.connection.*;
//import com.vmware.connection.ConnectedVimServiceBase;
//import com.vmware.connection.SsoConnection;
//import com.vmware.connection.BasicConnection;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class);
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(VsphereClientConfiguration.class);
        System.out.println("Let's inspect the numbers of beans provided by Spring Boot AnnotationConfigApplicationContext:");
        System.out.println(context.getBeanDefinitionCount());
        String[] beanAnnotationNames = context.getBeanDefinitionNames();
        Arrays.sort(beanAnnotationNames);
        for (String beanAnnotationName: beanAnnotationNames) {
            System.out.println(beanAnnotationName);
        }
                
        System.out.println("Let's inspect the beans provided by Spring Boot ApplicationContext:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String urlHostName, SSLSession session) {
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
        
        Utils.trustAllHttpsCertificates();

        UserConnect ssoConnection = (UserConnect) ctx.getBean("userConnect");
        UserProfile userProfile = (UserProfile) ctx.getBean("userProfile");

        ssoConnection.connect();
        /* String url = userProfile.getUrl();
        String ssoUrl = userProfile.getStsUrl();
        String username = userProfile.getUsername();
        String password =  userProfile.getPassword();
        System.out.println("ssoConnection");
        System.out.println("userProfile.getUrl() : " + userProfile.getUrl());
        System.out.println("userProfile.getUsername() : " + userProfile.getUsername());
        System.out.println("userProfile.getPassword() : " + userProfile.getPassword());

        ssoConnection.setUrl(url);
        System.out.println("ssoConnection.getUrl : " + ssoConnection.getUrl());
        ssoConnection.setUsername(username);
        System.out.println("ssoConnection.getUrl : " + ssoConnection.getUsername());
        ssoConnection.setPassword(password);
        System.out.println("ssoConnection.getUrl : " + ssoConnection.getPassword());
        System.out.println("ssoConnection.connect()");
        ssoConnection.connect();
        System.out.println("après ssoConnection.connect()");
    
        System.out.println("ssoConnection.getHost() : " + ssoConnection.getHost()); */

        //VsphereClientAuth client = context.getBean(VsphereClientAuth.class);

    }
}
/*     @Bean
	CommandLineRunner  acquireHoKTokenByUserCredential() {
		return args -> {
                        
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
                AcquireHoKTokenByUserCredentialSample  tokenClient = new AcquireHoKTokenByUserCredentialSample();
                Utils.printToken(tokenClient.getToken(argsCnx,userCert.getPrivateKey(),
                userCert.getUserCert()));
        };
    }   
} */
