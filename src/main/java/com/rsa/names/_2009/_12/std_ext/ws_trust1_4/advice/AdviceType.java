// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2009._12.std_ext.ws_trust1_4.advice;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdviceType", propOrder = { "attribute" })
public class AdviceType
{
    @XmlElement(name = "Attribute", required = true)
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
