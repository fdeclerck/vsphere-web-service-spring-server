// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2000._09.xmldsig;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RSAKeyValueType", propOrder = { "modulus", "exponent" })
public class RSAKeyValueType
{
    @XmlElement(name = "Modulus", required = true)
    protected byte[] modulus;
    @XmlElement(name = "Exponent", required = true)
    protected byte[] exponent;
    
    public byte[] getModulus() {
        return this.modulus;
    }
    
    public void setModulus(final byte[] array) {
        this.modulus = array;
    }
    
    public byte[] getExponent() {
        return this.exponent;
    }
    
    public void setExponent(final byte[] array) {
        this.exponent = array;
    }
}
