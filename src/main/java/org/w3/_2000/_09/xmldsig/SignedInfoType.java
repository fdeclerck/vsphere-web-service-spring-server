// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2000._09.xmldsig;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignedInfoType", propOrder = { "canonicalizationMethod", "signatureMethod", "reference" })
public class SignedInfoType
{
    @XmlElement(name = "CanonicalizationMethod", required = true)
    protected CanonicalizationMethodType canonicalizationMethod;
    @XmlElement(name = "SignatureMethod", required = true)
    protected SignatureMethodType signatureMethod;
    @XmlElement(name = "Reference", required = true)
    protected List<ReferenceType> reference;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    
    public CanonicalizationMethodType getCanonicalizationMethod() {
        return this.canonicalizationMethod;
    }
    
    public void setCanonicalizationMethod(final CanonicalizationMethodType canonicalizationMethod) {
        this.canonicalizationMethod = canonicalizationMethod;
    }
    
    public SignatureMethodType getSignatureMethod() {
        return this.signatureMethod;
    }
    
    public void setSignatureMethod(final SignatureMethodType signatureMethod) {
        this.signatureMethod = signatureMethod;
    }
    
    public List<ReferenceType> getReference() {
        if (this.reference == null) {
            this.reference = new ArrayList<ReferenceType>();
        }
        return this.reference;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
}
