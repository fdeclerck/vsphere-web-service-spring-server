// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.vsphere.soaphandlers;

import javax.xml.ws.handler.MessageContext;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import com.vmware.sso.client.soaphandlers.SSOHeaderHandler;

public class HeaderCookieHandler extends SSOHeaderHandler
{
    private final String _cookie;
    
    public HeaderCookieHandler(final String cookie) {
        this._cookie = cookie;
    }
    
    @Override
    public boolean handleMessage(final SOAPMessageContext soapMessageContext) {
        if (((Map<K, Boolean>)soapMessageContext).get("javax.xml.ws.handler.message.outbound")) {
            final Map<String, ArrayList<String>> map = ((Map<K, Map<String, ArrayList<String>>>)soapMessageContext).get("javax.xml.ws.http.request.headers");
            if (map == null) {
                final HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
                final ArrayList<String> list = new ArrayList<String>();
                list.add(this._cookie);
                hashMap.put("Cookie", list);
                ((Map<String, HashMap<String, ArrayList<String>>>)soapMessageContext).put("javax.xml.ws.http.request.headers", hashMap);
            }
            else {
                final ArrayList<String> list2 = new ArrayList<String>();
                list2.add(this._cookie);
                map.put("Cookie", list2);
            }
        }
        return true;
    }
}
