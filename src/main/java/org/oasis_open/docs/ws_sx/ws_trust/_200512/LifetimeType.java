// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlElement;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.AttributedDateTime;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LifetimeType", propOrder = { "created", "expires" })
public class LifetimeType
{
    @XmlElement(name = "Created", namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd")
    protected AttributedDateTime created;
    @XmlElement(name = "Expires", namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd")
    protected AttributedDateTime expires;
    
    public AttributedDateTime getCreated() {
        return this.created;
    }
    
    public void setCreated(final AttributedDateTime created) {
        this.created = created;
    }
    
    public AttributedDateTime getExpires() {
        return this.expires;
    }
    
    public void setExpires(final AttributedDateTime expires) {
        this.expires = expires;
    }
}
