// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RenewingType")
public class RenewingType
{
    @XmlAttribute(name = "Allow")
    protected Boolean allow;
    @XmlAttribute(name = "OK")
    protected Boolean ok;
    
    public Boolean isAllow() {
        return this.allow;
    }
    
    public void setAllow(final Boolean allow) {
        this.allow = allow;
    }
    
    public boolean isOK() {
        return this.ok != null && this.ok;
    }
    
    public void setOK(final Boolean ok) {
        this.ok = ok;
    }
}
