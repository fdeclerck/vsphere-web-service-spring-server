// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.ssl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import com.vmware.common.Main;

public class TrustAll
{
    public static void trust() throws NoSuchAlgorithmException, KeyManagementException {
        final Boolean trustAll = new Boolean(System.getProperty("ssl.trustAll.enabled", Main.Defaults.TRUST_ALL));
        if (trustAll) {
            new TrustAllTrustManager().register();
            new TrustAllHostNameVerifier().register();
            System.err.println(System.getProperty("ssl.trustAll.message", "WARNING: Java is now set to trust all SSL certificates."));
        }
    }
}
