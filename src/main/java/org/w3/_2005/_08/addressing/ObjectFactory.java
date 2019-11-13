// 
// Decompiled by Procyon v0.5.36
// 

package org.w3._2005._08.addressing;

import javax.xml.ws.wsaddressing.W3CEndpointReference;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _ProblemHeaderQName_QNAME;
    private static final QName _ReferenceParameters_QNAME;
    private static final QName _RetryAfter_QNAME;
    private static final QName _To_QNAME;
    private static final QName _Metadata_QNAME;
    private static final QName _MessageID_QNAME;
    private static final QName _ProblemIRI_QNAME;
    private static final QName _From_QNAME;
    private static final QName _ReplyTo_QNAME;
    private static final QName _Action_QNAME;
    private static final QName _FaultTo_QNAME;
    private static final QName _ProblemAction_QNAME;
    private static final QName _RelatesTo_QNAME;
    
    public ProblemActionType createProblemActionType() {
        return new ProblemActionType();
    }
    
    public AttributedURIType createAttributedURIType() {
        return new AttributedURIType();
    }
    
    public AttributedQNameType createAttributedQNameType() {
        return new AttributedQNameType();
    }
    
    public AttributedUnsignedLongType createAttributedUnsignedLongType() {
        return new AttributedUnsignedLongType();
    }
    
    public MetadataType createMetadataType() {
        return new MetadataType();
    }
    
    public ReferenceParametersType createReferenceParametersType() {
        return new ReferenceParametersType();
    }
    
    public RelatesToType createRelatesToType() {
        return new RelatesToType();
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "ProblemHeaderQName")
    public JAXBElement<AttributedQNameType> createProblemHeaderQName(final AttributedQNameType attributedQNameType) {
        return new JAXBElement<AttributedQNameType>(ObjectFactory._ProblemHeaderQName_QNAME, AttributedQNameType.class, null, attributedQNameType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "ReferenceParameters")
    public JAXBElement<ReferenceParametersType> createReferenceParameters(final ReferenceParametersType referenceParametersType) {
        return new JAXBElement<ReferenceParametersType>(ObjectFactory._ReferenceParameters_QNAME, ReferenceParametersType.class, null, referenceParametersType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "RetryAfter")
    public JAXBElement<AttributedUnsignedLongType> createRetryAfter(final AttributedUnsignedLongType attributedUnsignedLongType) {
        return new JAXBElement<AttributedUnsignedLongType>(ObjectFactory._RetryAfter_QNAME, AttributedUnsignedLongType.class, null, attributedUnsignedLongType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "To")
    public JAXBElement<AttributedURIType> createTo(final AttributedURIType attributedURIType) {
        return new JAXBElement<AttributedURIType>(ObjectFactory._To_QNAME, AttributedURIType.class, null, attributedURIType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "Metadata")
    public JAXBElement<MetadataType> createMetadata(final MetadataType metadataType) {
        return new JAXBElement<MetadataType>(ObjectFactory._Metadata_QNAME, MetadataType.class, null, metadataType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "MessageID")
    public JAXBElement<AttributedURIType> createMessageID(final AttributedURIType attributedURIType) {
        return new JAXBElement<AttributedURIType>(ObjectFactory._MessageID_QNAME, AttributedURIType.class, null, attributedURIType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "ProblemIRI")
    public JAXBElement<AttributedURIType> createProblemIRI(final AttributedURIType attributedURIType) {
        return new JAXBElement<AttributedURIType>(ObjectFactory._ProblemIRI_QNAME, AttributedURIType.class, null, attributedURIType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "From")
    public JAXBElement<W3CEndpointReference> createFrom(final W3CEndpointReference w3CEndpointReference) {
        return new JAXBElement<W3CEndpointReference>(ObjectFactory._From_QNAME, W3CEndpointReference.class, null, w3CEndpointReference);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "ReplyTo")
    public JAXBElement<W3CEndpointReference> createReplyTo(final W3CEndpointReference w3CEndpointReference) {
        return new JAXBElement<W3CEndpointReference>(ObjectFactory._ReplyTo_QNAME, W3CEndpointReference.class, null, w3CEndpointReference);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "Action")
    public JAXBElement<AttributedURIType> createAction(final AttributedURIType attributedURIType) {
        return new JAXBElement<AttributedURIType>(ObjectFactory._Action_QNAME, AttributedURIType.class, null, attributedURIType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "FaultTo")
    public JAXBElement<W3CEndpointReference> createFaultTo(final W3CEndpointReference w3CEndpointReference) {
        return new JAXBElement<W3CEndpointReference>(ObjectFactory._FaultTo_QNAME, W3CEndpointReference.class, null, w3CEndpointReference);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "ProblemAction")
    public JAXBElement<ProblemActionType> createProblemAction(final ProblemActionType problemActionType) {
        return new JAXBElement<ProblemActionType>(ObjectFactory._ProblemAction_QNAME, ProblemActionType.class, null, problemActionType);
    }
    
    @XmlElementDecl(namespace = "http://www.w3.org/2005/08/addressing", name = "RelatesTo")
    public JAXBElement<RelatesToType> createRelatesTo(final RelatesToType relatesToType) {
        return new JAXBElement<RelatesToType>(ObjectFactory._RelatesTo_QNAME, RelatesToType.class, null, relatesToType);
    }
    
    static {
        _ProblemHeaderQName_QNAME = new QName("http://www.w3.org/2005/08/addressing", "ProblemHeaderQName");
        _ReferenceParameters_QNAME = new QName("http://www.w3.org/2005/08/addressing", "ReferenceParameters");
        _RetryAfter_QNAME = new QName("http://www.w3.org/2005/08/addressing", "RetryAfter");
        _To_QNAME = new QName("http://www.w3.org/2005/08/addressing", "To");
        _Metadata_QNAME = new QName("http://www.w3.org/2005/08/addressing", "Metadata");
        _MessageID_QNAME = new QName("http://www.w3.org/2005/08/addressing", "MessageID");
        _ProblemIRI_QNAME = new QName("http://www.w3.org/2005/08/addressing", "ProblemIRI");
        _From_QNAME = new QName("http://www.w3.org/2005/08/addressing", "From");
        _ReplyTo_QNAME = new QName("http://www.w3.org/2005/08/addressing", "ReplyTo");
        _Action_QNAME = new QName("http://www.w3.org/2005/08/addressing", "Action");
        _FaultTo_QNAME = new QName("http://www.w3.org/2005/08/addressing", "FaultTo");
        _ProblemAction_QNAME = new QName("http://www.w3.org/2005/08/addressing", "ProblemAction");
        _RelatesTo_QNAME = new QName("http://www.w3.org/2005/08/addressing", "RelatesTo");
    }
}
