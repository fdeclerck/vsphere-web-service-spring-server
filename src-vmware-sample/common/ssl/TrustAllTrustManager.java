// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.HttpsURLConnection;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.TrustManager;

public final class TrustAllTrustManager implements TrustManager, X509TrustManager
{
    public void register() throws NoSuchAlgorithmException, KeyManagementException {
        register(this);
    }
    
    public static void register(final TrustManager tm) throws NoSuchAlgorithmException, KeyManagementException {
        final TrustManager[] trustAllCerts = { tm };
        final SSLContext sc = SSLContext.getInstance("SSL");
        final SSLSessionContext sslsc = sc.getServerSessionContext();
        sslsc.setSessionTimeout(0);
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
    
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
    
    @Override
    public void checkServerTrusted(final X509Certificate[] certs, final String authType) throws CertificateException {
    }
    
    @Override
    public void checkClientTrusted(final X509Certificate[] certs, final String authType) throws CertificateException {
    }
}
