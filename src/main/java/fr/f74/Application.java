
package fr.f74;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rsa.names._2009._12.product.riat.wsdl.STSService;
import com.rsa.names._2009._12.product.riat.wsdl.STSServicePortType;
import com.vmware.sso.client.soaphandlers.*;
import com.vmware.sso.client.utils.SecurityUtil;
import com.vmware.sso.client.utils.Utils;
import org.oasis_open.docs.ws_sx.ws_trust._200512.LifetimeType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RenewingType;
import org.oasis_open.docs.ws_sx.ws_trust._200512.RequestSecurityTokenType;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import org.w3c.dom.Element;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TimeZone;

import fr.f74.AcquireHoKTokenByUserCredentialSample;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    @Bean
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
            if (args.length == 3) {
                System.out
                        .println("Aquiring a HoK token by using user credentials, "
                                + "use the pre-generated private key and certificate ");
    
                SecurityUtil userCert = SecurityUtil.loadFromDefaultFiles();
                AcquireHoKTokenByUserCredentialSample  tokenClient = new AcquireHoKTokenByUserCredentialSample();
                Utils.printToken(tokenClient.getToken(args, userCert.getPrivateKey(),
                userCert.getUserCert()));
            } else if (args.length == 5) {
                System.out
                        .println("Aquiring a HoK token by using user credentials, "
                                + "private key and certificate ");
                SecurityUtil userCert = SecurityUtil.loadFromFiles(args[3], args[4]);
                AcquireHoKTokenByUserCredentialSample  tokenClient = new AcquireHoKTokenByUserCredentialSample();
                Utils.printToken(tokenClient.getToken(args, userCert.getPrivateKey(),
                userCert.getUserCert()));
            } else if (args.length == 6) {
                System.out
                        .println("Aquiring a HoK token by using user credentials, "
                                + "private key and certificate ");
                SecurityUtil userCert = SecurityUtil.loadFromKeystore(args[3], args[4], args[5]);
                AcquireHoKTokenByUserCredentialSample  tokenClient = new AcquireHoKTokenByUserCredentialSample();
                Utils.printToken(tokenClient.getToken(args, userCert.getPrivateKey(),
                userCert.getUserCert()));        
            } else {
                System.out
                        .println("args.length : "
                                + args.length);
                String username = "visu2016";
                String password = "visu@vsphere.local"; 
                String STSurl = "https://10.200.19.122/sts/STSService";                
                SecurityUtil userCert = SecurityUtil.loadFromDefaultFiles();
                AcquireHoKTokenByUserCredentialSample  tokenClient = new AcquireHoKTokenByUserCredentialSample();
                Utils.printToken(tokenClient.getToken(args, userCert.getPrivateKey(),
                userCert.getUserCert()));               
                return;
            }
        };
    }   
}
