// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2000._09.xmldsig;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureType", propOrder = { "signedInfo", "signatureValue", "keyInfo" })
public class SignatureType
{
    @XmlElement(name = "SignedInfo", required = true)
    protected SignedInfoType signedInfo;
    @XmlElement(name = "SignatureValue", required = true)
    protected SignatureValueType signatureValue;
    @XmlElement(name = "KeyInfo")
    protected KeyInfoType keyInfo;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    
    public SignedInfoType getSignedInfo() {
        return this.signedInfo;
    }
    
    public void setSignedInfo(final SignedInfoType signedInfo) {
        this.signedInfo = signedInfo;
    }
    
    public SignatureValueType getSignatureValue() {
        return this.signatureValue;
    }
    
    public void setSignatureValue(final SignatureValueType signatureValue) {
        this.signatureValue = signatureValue;
    }
    
    public KeyInfoType getKeyInfo() {
        return this.keyInfo;
    }
    
    public void setKeyInfo(final KeyInfoType keyInfo) {
        this.keyInfo = keyInfo;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
}
