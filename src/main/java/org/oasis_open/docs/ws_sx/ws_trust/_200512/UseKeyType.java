// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UseKeyType")
public class UseKeyType
{
    @XmlAttribute(name = "Sig", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String sig;
    
    public String getSig() {
        return this.sig;
    }
    
    public void setSig(final String sig) {
        this.sig = sig;
    }
}
