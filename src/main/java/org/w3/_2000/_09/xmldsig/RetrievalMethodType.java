// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2000._09.xmldsig;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrievalMethodType", propOrder = { "transforms" })
public class RetrievalMethodType
{
    @XmlElement(name = "Transforms")
    protected TransformsType transforms;
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
