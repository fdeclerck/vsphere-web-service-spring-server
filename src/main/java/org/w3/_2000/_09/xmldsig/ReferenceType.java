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
@XmlType(name = "ReferenceType", propOrder = { "transforms", "digestMethod", "digestValue" })
public class ReferenceType
{
    @XmlElement(name = "Transforms")
    protected TransformsType transforms;
    @XmlElement(name = "DigestMethod", required = true)
    protected DigestMethodType digestMethod;
    @XmlElement(name = "DigestValue", required = true)
    protected byte[] digestValue;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "URI")
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anyURI")
    protected String type;
    
    public TransformsType getTransforms() {
        return this.transforms;
    }
    
    public void setTransforms(final TransformsType transforms) {
        this.transforms = transforms;
    }
    
    public DigestMethodType getDigestMethod() {
        return this.digestMethod;
    }
    
    public void setDigestMethod(final DigestMethodType digestMethod) {
        this.digestMethod = digestMethod;
    }
    
    public byte[] getDigestValue() {
        return this.digestValue;
    }
    
    public void setDigestValue(final byte[] array) {
        this.digestValue = array;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getURI() {
        return this.uri;
    }
    
    public void setURI(final String uri) {
        this.uri = uri;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
}
