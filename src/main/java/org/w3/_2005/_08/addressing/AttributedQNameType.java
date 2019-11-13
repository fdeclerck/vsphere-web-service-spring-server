// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2005._08.addressing;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlAnyAttribute;
import java.util.Map;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributedQNameType", propOrder = { "value" })
public class AttributedQNameType
{
    @XmlValue
    protected QName value;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes;
    
    public AttributedQNameType() {
        this.otherAttributes = new HashMap<QName, String>();
    }
    
    public QName getValue() {
        return this.value;
    }
    
    public void setValue(final QName value) {
        this.value = value;
    }
    
    public Map<QName, String> getOtherAttributes() {
        return this.otherAttributes;
    }
}
