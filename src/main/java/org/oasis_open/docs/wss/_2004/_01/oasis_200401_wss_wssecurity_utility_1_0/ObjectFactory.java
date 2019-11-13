// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _Expires_QNAME;
    private static final QName _Timestamp_QNAME;
    private static final QName _Created_QNAME;
    
    public AttributedDateTime createAttributedDateTime() {
        return new AttributedDateTime();
    }
    
    public TimestampType createTimestampType() {
        return new TimestampType();
    }
    
    public AttributedURI createAttributedURI() {
        return new AttributedURI();
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", name = "Expires")
    public JAXBElement<AttributedDateTime> createExpires(final AttributedDateTime attributedDateTime) {
        return new JAXBElement<AttributedDateTime>(ObjectFactory._Expires_QNAME, AttributedDateTime.class, null, attributedDateTime);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", name = "Timestamp")
    public JAXBElement<TimestampType> createTimestamp(final TimestampType timestampType) {
        return new JAXBElement<TimestampType>(ObjectFactory._Timestamp_QNAME, TimestampType.class, null, timestampType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", name = "Created")
    public JAXBElement<AttributedDateTime> createCreated(final AttributedDateTime attributedDateTime) {
        return new JAXBElement<AttributedDateTime>(ObjectFactory._Created_QNAME, AttributedDateTime.class, null, attributedDateTime);
    }
    
    static {
        _Expires_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Expires");
        _Timestamp_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Timestamp");
        _Created_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Created");
    }
}
