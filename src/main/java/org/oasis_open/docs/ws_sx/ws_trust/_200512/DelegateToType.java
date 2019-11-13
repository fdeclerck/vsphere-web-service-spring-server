// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlElement;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0.UsernameTokenType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DelegateToType", propOrder = { "usernameToken" })
public class DelegateToType
{
    @XmlElement(name = "UsernameToken", namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", required = true)
    protected UsernameTokenType usernameToken;
    
    public UsernameTokenType getUsernameToken() {
        return this.usernameToken;
    }
    
    public void setUsernameToken(final UsernameTokenType usernameToken) {
        this.usernameToken = usernameToken;
    }
}
