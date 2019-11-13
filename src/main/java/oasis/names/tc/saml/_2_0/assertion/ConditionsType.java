// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionsType", propOrder = { "conditionOrAudienceRestrictionOrProxyRestriction" })
public class ConditionsType
{
    @XmlElements({ @XmlElement(name = "ProxyRestriction", type = ProxyRestrictionType.class), @XmlElement(name = "AudienceRestriction", type = AudienceRestrictionType.class), @XmlElement(name = "Condition") })
    protected List<ConditionAbstractType> conditionOrAudienceRestrictionOrProxyRestriction;
    @XmlAttribute(name = "NotBefore", required = true)
    protected XMLGregorianCalendar notBefore;
    @XmlAttribute(name = "NotOnOrAfter", required = true)
    protected XMLGregorianCalendar notOnOrAfter;
    
    public List<ConditionAbstractType> getConditionOrAudienceRestrictionOrProxyRestriction() {
        if (this.conditionOrAudienceRestrictionOrProxyRestriction == null) {
            this.conditionOrAudienceRestrictionOrProxyRestriction = new ArrayList<ConditionAbstractType>();
        }
        return this.conditionOrAudienceRestrictionOrProxyRestriction;
    }
    
    public XMLGregorianCalendar getNotBefore() {
        return this.notBefore;
    }
    
    public void setNotBefore(final XMLGregorianCalendar notBefore) {
        this.notBefore = notBefore;
    }
    
    public XMLGregorianCalendar getNotOnOrAfter() {
        return this.notOnOrAfter;
    }
    
    public void setNotOnOrAfter(final XMLGregorianCalendar notOnOrAfter) {
        this.notOnOrAfter = notOnOrAfter;
    }
}
