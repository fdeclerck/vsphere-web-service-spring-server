// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthnStatementType", propOrder = { "authnContext" })
public class AuthnStatementType extends StatementAbstractType
{
    @XmlElement(name = "AuthnContext", required = true)
    protected AuthnContextType authnContext;
    @XmlAttribute(name = "AuthnInstant", required = true)
    protected XMLGregorianCalendar authnInstant;
    
    public AuthnContextType getAuthnContext() {
        return this.authnContext;
    }
    
    public void setAuthnContext(final AuthnContextType authnContext) {
        this.authnContext = authnContext;
    }
    
    public XMLGregorianCalendar getAuthnInstant() {
        return this.authnInstant;
    }
    
    public void setAuthnInstant(final XMLGregorianCalendar authnInstant) {
        this.authnInstant = authnInstant;
    }
}
