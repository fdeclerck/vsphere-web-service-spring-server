// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2005._08.addressing;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.Map;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlValue;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributedUnsignedLongType", propOrder = { "value" })
public class AttributedUnsignedLongType
{
    @XmlValue
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger value;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes;
    
    public AttributedUnsignedLongType() {
        this.otherAttributes = new HashMap<QName, String>();
    }
    
    public BigInteger getValue() {
        return this.value;
    }
    
    public void setValue(final BigInteger value) {
        this.value = value;
    }
    
    public Map<QName, String> getOtherAttributes() {
        return this.otherAttributes;
    }
}
