// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.conditions.delegation;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.annotation.XmlElement;
import oasis.names.tc.saml._2_0.assertion.NameIDType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DelegateType", propOrder = { "nameID" })
public class DelegateType
{
    @XmlElement(name = "NameID", namespace = "urn:oasis:names:tc:SAML:2.0:assertion", required = true)
    protected NameIDType nameID;
    @XmlAttribute(name = "DelegationInstant")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar delegationInstant;
    
    public NameIDType getNameID() {
        return this.nameID;
    }
    
    public void setNameID(final NameIDType nameID) {
        this.nameID = nameID;
    }
    
    public XMLGregorianCalendar getDelegationInstant() {
        return this.delegationInstant;
    }
    
    public void setDelegationInstant(final XMLGregorianCalendar delegationInstant) {
        this.delegationInstant = delegationInstant;
    }
}
