package fr.f74;

import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.vmware.sso.client.utils.Utils;
import com.vmware.sso.client.utils.SecurityUtil;

@Component
public class UserProfile {
    private String url = "https://10.200.19.122/sdk";
    private String username = "visu2016";
    private String password = "visu@vsphere.local"; 
    private String stsUrl = "https://10.200.19.122/sts/STSService"; 
    private String[] argsCnx = {"https://10.200.19.122/sts/STSService","visu@vsphere.local","visu2016"} ;
    private PrivateKey privateKey;
    private X509Certificate certificate;
    
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url.toString();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username.toString();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password.toString();
    }

    public void setStsUrl(String stsUrl) {
        this.stsUrl = stsUrl;
    }

    public String getStsUrl() {
        return stsUrl.toString();
    }

    public String[] getArgsCnx() {
        return argsCnx;
    }

    public void setPrivateKey() {

        SecurityUtil userCert = SecurityUtil.loadFromDefaultFiles();    
            
        privateKey = userCert.getPrivateKey();
        //certificate = userCert.getUserCert();
        this.privateKey = privateKey;
    }

    public PrivateKey getPrivateKey() {
        
        return privateKey;
    }

    public void setCertificate() {

        SecurityUtil userCert = SecurityUtil.loadFromDefaultFiles();    
            
        //privateKey = userCert.getPrivateKey();
        certificate = userCert.getUserCert();
        this.certificate = certificate;
    }

    public X509Certificate getCertificate() {
        
        return certificate;
    }
}




