// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2005._08.addressing;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.Map;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProblemActionType", propOrder = { "action", "soapAction" })
public class ProblemActionType
{
    @XmlElement(name = "Action")
    protected AttributedURIType action;
    @XmlElement(name = "SoapAction")
    @XmlSchemaType(name = "anyURI")
    protected String soapAction;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes;
    
    public ProblemActionType() {
        this.otherAttributes = new HashMap<QName, String>();
    }
    
    public AttributedURIType getAction() {
        return this.action;
    }
    
    public void setAction(final AttributedURIType action) {
        this.action = action;
    }
    
    public String getSoapAction() {
        return this.soapAction;
    }
    
    public void setSoapAction(final String soapAction) {
        this.soapAction = soapAction;
    }
    
    public Map<QName, String> getOtherAttributes() {
        return this.otherAttributes;
    }
}
