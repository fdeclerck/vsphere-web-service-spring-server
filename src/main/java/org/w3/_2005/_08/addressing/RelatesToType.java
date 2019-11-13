// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2005._08.addressing;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.Map;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelatesToType", propOrder = { "value" })
public class RelatesToType
{
    @XmlValue
    @XmlSchemaType(name = "anyURI")
    protected String value;
    @XmlAttribute(name = "RelationshipType")
    protected String relationshipType;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes;
    
    public RelatesToType() {
        this.otherAttributes = new HashMap<QName, String>();
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(final String value) {
        this.value = value;
    }
    
    public String getRelationshipType() {
        if (this.relationshipType == null) {
            return "http://www.w3.org/2005/08/addressing/reply";
        }
        return this.relationshipType;
    }
    
    public void setRelationshipType(final String relationshipType) {
        this.relationshipType = relationshipType;
    }
    
    public Map<QName, String> getOtherAttributes() {
        return this.otherAttributes;
    }
}
