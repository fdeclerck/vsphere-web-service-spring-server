// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2009._12.std_ext.saml2;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _RSAAdvice_QNAME;
    
    public RSAAdviceType createRSAAdviceType() {
        return new RSAAdviceType();
    }
    
    public RenewRestrictionType createRenewRestrictionType() {
        return new RenewRestrictionType();
    }
    
    @XmlElementDecl(namespace = "http://www.rsa.com/names/2009/12/std-ext/SAML2.0", name = "RSAAdvice")
    public JAXBElement<RSAAdviceType> createRSAAdvice(final RSAAdviceType rsaAdviceType) {
        return new JAXBElement<RSAAdviceType>(ObjectFactory._RSAAdvice_QNAME, RSAAdviceType.class, null, rsaAdviceType);
    }
    
    static {
        _RSAAdvice_QNAME = new QName("http://www.rsa.com/names/2009/12/std-ext/SAML2.0", "RSAAdvice");
    }
}
