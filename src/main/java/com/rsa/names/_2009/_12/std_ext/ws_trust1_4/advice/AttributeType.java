// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2009._12.std_ext.ws_trust1_4.advice;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeType", propOrder = { "attributeValue" })
public class AttributeType
{
    @XmlElement(name = "AttributeValue")
    protected List<Object> attributeValue;
    @XmlAttribute(name = "Name", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String name;
    @XmlAttribute(name = "FriendlyName")
    protected String friendlyName;
    
    public List<Object> getAttributeValue() {
        if (this.attributeValue == null) {
            this.attributeValue = new ArrayList<Object>();
        }
        return this.attributeValue;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getFriendlyName() {
        return this.friendlyName;
    }
    
    public void setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
    }
}
