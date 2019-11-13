// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2000._09.xmldsig;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "X509IssuerSerialType", propOrder = { "x509IssuerName", "x509SerialNumber" })
public class X509IssuerSerialType
{
    @XmlElement(name = "X509IssuerName", required = true)
    protected String x509IssuerName;
    @XmlElement(name = "X509SerialNumber", required = true)
    protected BigInteger x509SerialNumber;
    
    public String getX509IssuerName() {
        return this.x509IssuerName;
    }
    
    public void setX509IssuerName(final String x509IssuerName) {
        this.x509IssuerName = x509IssuerName;
    }
    
    public BigInteger getX509SerialNumber() {
        return this.x509SerialNumber;
    }
    
    public void setX509SerialNumber(final BigInteger x509SerialNumber) {
        this.x509SerialNumber = x509SerialNumber;
    }
}
