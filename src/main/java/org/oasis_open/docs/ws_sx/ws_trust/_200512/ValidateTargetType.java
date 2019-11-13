// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlAnyElement;
import org.w3c.dom.Element;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateTargetType", propOrder = { "any" })
public class ValidateTargetType
{
    @XmlAnyElement
    protected Element any;
    
    public Element getAny() {
        return this.any;
    }
    
    public void setAny(final Element any) {
        this.any = any;
    }
}
