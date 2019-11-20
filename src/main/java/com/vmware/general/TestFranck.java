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

package com.vmware.general;

import com.vmware.common.annotations.Action;
import com.vmware.common.annotations.Sample;
import com.vmware.connection.ConnectedVimServiceBase;
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

import static com.vmware.sso.client.samples.AcquireHoKTokenByUserCredentialSample.getToken;
//import com.vmware.GetCurrentTime;
import com.vmware.connection.ConnectedVimServiceBase;
import com.vmware.connection.SsoConnection;
import com.vmware.connection.BasicConnection;


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
@Sample(
        name = "test franck",
        description = "test franck"
)

public class TestFranck extends ConnectedVimServiceBase {
        /**
         * For details on how to form different types of connections
         * to various kinds of vSphere web service agents, see the
         * classes under the package com.vmware.connection,
         * @see com.vmware.connection.BasicConnection
         * @see com.vmware.connection.SsoConnection
         */
        @Action
        public void fairechose() {
                System.out.println("fairechose()"); 
               System.out.printf("connected to: %s", connection.getServiceContent().getAbout().getLicenseProductName());
               System.out.printf("ServiceInstanceReference: %s", connection.getServiceInstanceReference());
               System.out.printf("getUsername(): %s", connection.getUsername());
               System.out.printf("getUrl() : %s", connection.getUrl());

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