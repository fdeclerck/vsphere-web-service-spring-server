// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2000._09.xmldsig;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementRef;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignatureMethodType", propOrder = { "content" })
public class SignatureMethodType
{
    @XmlElementRef(name = "HMACOutputLength", namespace = "http://www.w3.org/2000/09/xmldsig#", type = JAXBElement.class, required = false)
    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<Object> content;
    @XmlAttribute(name = "Algorithm", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String algorithm;
    
    public List<Object> getContent() {
        if (this.content == null) {
            this.content = new ArrayList<Object>();
        }
        return this.content;
    }
    
    public String getAlgorithm() {
        return this.algorithm;
    }
    
    public void setAlgorithm(final String algorithm) {
        this.algorithm = algorithm;
    }
}