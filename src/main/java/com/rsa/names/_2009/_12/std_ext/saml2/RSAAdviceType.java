// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2009._12.std_ext.saml2;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import oasis.names.tc.saml._2_0.assertion.AttributeType;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RSAAdviceType", propOrder = { "attribute" })
public class RSAAdviceType
{
    @XmlElement(name = "Attribute", namespace = "urn:oasis:names:tc:SAML:2.0:assertion", required = true)
    protected List<AttributeType> attribute;
    @XmlAttribute(name = "AdviceSource", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String adviceSource;
    
    public List<AttributeType> getAttribute() {
        if (this.attribute == null) {
            this.attribute = new ArrayList<AttributeType>();
        }
        return this.attribute;
    }
    
    public String getAdviceSource() {
        return this.adviceSource;
    }
    
    public void setAdviceSource(final String adviceSource) {
        this.adviceSource = adviceSource;
    }
}
