// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.vsphere.soaphandlers;

import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;

public class HeaderCookieExtractionHandler extends SSOHeaderHandler
{
    private String extractedCookie;
    
    @Override
    public boolean handleMessage(final SOAPMessageContext soapMessageContext) {
        if (!((Map<K, Boolean>)soapMessageContext).get("javax.xml.ws.handler.message.outbound")) {
            final Map<Object, List> map = ((Map<K, Map<Object, List>>)soapMessageContext).get("javax.xml.ws.http.response.headers");
            if (map != null) {
                final List<String> list = map.get("Set-cookie");
                if (list != null) {
                    this.extractedCookie = list.get(0);
                }
            }
        }
        return true;
    }
    
    public String getCookie() {
        return this.extractedCookie;
    }
}
