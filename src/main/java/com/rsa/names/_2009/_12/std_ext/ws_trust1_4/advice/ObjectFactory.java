// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2009._12.std_ext.ws_trust1_4.advice;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _AttributeValue_QNAME;
    private static final QName _AdviceSet_QNAME;
    
    public AdviceSetType createAdviceSetType() {
        return new AdviceSetType();
    }
    
    public AttributeType createAttributeType() {
        return new AttributeType();
    }
    
    public AdviceType createAdviceType() {
        return new AdviceType();
    }
    
    @XmlElementDecl(namespace = "http://www.rsa.com/names/2009/12/std-ext/WS-Trust1.4/advice", name = "AttributeValue")
    public JAXBElement<Object> createAttributeValue(final Object o) {
        return new JAXBElement<Object>(ObjectFactory._AttributeValue_QNAME, Object.class, null, o);
    }
    
    @XmlElementDecl(namespace = "http://www.rsa.com/names/2009/12/std-ext/WS-Trust1.4/advice", name = "AdviceSet")
    public JAXBElement<AdviceSetType> createAdviceSet(final AdviceSetType adviceSetType) {
        return new JAXBElement<AdviceSetType>(ObjectFactory._AdviceSet_QNAME, AdviceSetType.class, null, adviceSetType);
    }
    
    static {
        _AttributeValue_QNAME = new QName("http://www.rsa.com/names/2009/12/std-ext/WS-Trust1.4/advice", "AttributeValue");
        _AdviceSet_QNAME = new QName("http://www.rsa.com/names/2009/12/std-ext/WS-Trust1.4/advice", "AdviceSet");
    }
}
