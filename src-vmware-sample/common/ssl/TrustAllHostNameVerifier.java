// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.ssl;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.HostnameVerifier;

public class TrustAllHostNameVerifier implements HostnameVerifier
{
    @Override
    public boolean verify(final String urlHostName, final SSLSession session) {
        return true;
    }
    
    public HostnameVerifier register() {
        HttpsURLConnection.setDefaultHostnameVerifier(this);
        return this;
    }
}
