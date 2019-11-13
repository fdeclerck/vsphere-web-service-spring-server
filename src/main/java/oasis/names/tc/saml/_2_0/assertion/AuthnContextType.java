// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthnContextType", propOrder = { "authnContextClassRef" })
public class AuthnContextType
{
    @XmlElement(name = "AuthnContextClassRef", required = true)
    protected String authnContextClassRef;
    
    public String getAuthnContextClassRef() {
        return this.authnContextClassRef;
    }
    
    public void setAuthnContextClassRef(final String authnContextClassRef) {
        this.authnContextClassRef = authnContextClassRef;
    }
}
