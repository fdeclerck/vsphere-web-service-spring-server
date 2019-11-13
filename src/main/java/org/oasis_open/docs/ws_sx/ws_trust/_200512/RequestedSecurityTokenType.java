// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestedSecurityTokenType", propOrder = { "any" })
public class RequestedSecurityTokenType
{
    @XmlAnyElement(lax = true)
    protected Object any;
    
    public Object getAny() {
        return this.any;
    }
    
    public void setAny(final Object any) {
        this.any = any;
    }
}
