// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.conditions.delegation;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _Delegate_QNAME;
    
    public DelegateType createDelegateType() {
        return new DelegateType();
    }
    
    public DelegationRestrictionType createDelegationRestrictionType() {
        return new DelegationRestrictionType();
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:conditions:delegation", name = "Delegate")
    public JAXBElement<DelegateType> createDelegate(final DelegateType delegateType) {
        return new JAXBElement<DelegateType>(ObjectFactory._Delegate_QNAME, DelegateType.class, null, delegateType);
    }
    
    static {
        _Delegate_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:conditions:delegation", "Delegate");
    }
}
