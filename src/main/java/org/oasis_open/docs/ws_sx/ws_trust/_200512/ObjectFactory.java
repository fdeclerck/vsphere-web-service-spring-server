// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.ws.wsaddressing.W3CEndpointReference;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _Issuer_QNAME;
    private static final QName _AllowPostdating_QNAME;
    private static final QName _RequestSecurityToken_QNAME;
    private static final QName _RequestSecurityTokenResponse_QNAME;
    private static final QName _RequestedSecurityToken_QNAME;
    private static final QName _RequestSecurityTokenResponseCollection_QNAME;
    private static final QName _SignatureAlgorithm_QNAME;
    private static final QName _RenewTarget_QNAME;
    private static final QName _Delegatable_QNAME;
    private static final QName _UseKey_QNAME;
    private static final QName _DelegateTo_QNAME;
    private static final QName _Participants_QNAME;
    private static final QName _KeyType_QNAME;
    private static final QName _Renewing_QNAME;
    private static final QName _TokenType_QNAME;
    private static final QName _Lifetime_QNAME;
    private static final QName _ValidateTarget_QNAME;
    private static final QName _Status_QNAME;
    private static final QName _RequestType_QNAME;
    private static final QName _BinaryExchange_QNAME;
    
    public DelegateToType createDelegateToType() {
        return new DelegateToType();
    }
    
    public RequestSecurityTokenType createRequestSecurityTokenType() {
        return new RequestSecurityTokenType();
    }
    
    public UseKeyType createUseKeyType() {
        return new UseKeyType();
    }
    
    public RequestSecurityTokenResponseType createRequestSecurityTokenResponseType() {
        return new RequestSecurityTokenResponseType();
    }
    
    public RequestedSecurityTokenType createRequestedSecurityTokenType() {
        return new RequestedSecurityTokenType();
    }
    
    public RequestSecurityTokenResponseCollectionType createRequestSecurityTokenResponseCollectionType() {
        return new RequestSecurityTokenResponseCollectionType();
    }
    
    public ParticipantsType createParticipantsType() {
        return new ParticipantsType();
    }
    
    public StatusType createStatusType() {
        return new StatusType();
    }
    
    public ValidateTargetType createValidateTargetType() {
        return new ValidateTargetType();
    }
    
    public LifetimeType createLifetimeType() {
        return new LifetimeType();
    }
    
    public RenewTargetType createRenewTargetType() {
        return new RenewTargetType();
    }
    
    public AllowPostdatingType createAllowPostdatingType() {
        return new AllowPostdatingType();
    }
    
    public RenewingType createRenewingType() {
        return new RenewingType();
    }
    
    public BinaryExchangeType createBinaryExchangeType() {
        return new BinaryExchangeType();
    }
    
    public ParticipantType createParticipantType() {
        return new ParticipantType();
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Issuer")
    public JAXBElement<W3CEndpointReference> createIssuer(final W3CEndpointReference w3CEndpointReference) {
        return new JAXBElement<W3CEndpointReference>(ObjectFactory._Issuer_QNAME, W3CEndpointReference.class, null, w3CEndpointReference);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "AllowPostdating")
    public JAXBElement<AllowPostdatingType> createAllowPostdating(final AllowPostdatingType allowPostdatingType) {
        return new JAXBElement<AllowPostdatingType>(ObjectFactory._AllowPostdating_QNAME, AllowPostdatingType.class, null, allowPostdatingType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestSecurityToken")
    public JAXBElement<RequestSecurityTokenType> createRequestSecurityToken(final RequestSecurityTokenType requestSecurityTokenType) {
        return new JAXBElement<RequestSecurityTokenType>(ObjectFactory._RequestSecurityToken_QNAME, RequestSecurityTokenType.class, null, requestSecurityTokenType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestSecurityTokenResponse")
    public JAXBElement<RequestSecurityTokenResponseType> createRequestSecurityTokenResponse(final RequestSecurityTokenResponseType requestSecurityTokenResponseType) {
        return new JAXBElement<RequestSecurityTokenResponseType>(ObjectFactory._RequestSecurityTokenResponse_QNAME, RequestSecurityTokenResponseType.class, null, requestSecurityTokenResponseType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestedSecurityToken")
    public JAXBElement<RequestedSecurityTokenType> createRequestedSecurityToken(final RequestedSecurityTokenType requestedSecurityTokenType) {
        return new JAXBElement<RequestedSecurityTokenType>(ObjectFactory._RequestedSecurityToken_QNAME, RequestedSecurityTokenType.class, null, requestedSecurityTokenType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestSecurityTokenResponseCollection")
    public JAXBElement<RequestSecurityTokenResponseCollectionType> createRequestSecurityTokenResponseCollection(final RequestSecurityTokenResponseCollectionType requestSecurityTokenResponseCollectionType) {
        return new JAXBElement<RequestSecurityTokenResponseCollectionType>(ObjectFactory._RequestSecurityTokenResponseCollection_QNAME, RequestSecurityTokenResponseCollectionType.class, null, requestSecurityTokenResponseCollectionType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "SignatureAlgorithm")
    public JAXBElement<String> createSignatureAlgorithm(final String s) {
        return new JAXBElement<String>(ObjectFactory._SignatureAlgorithm_QNAME, String.class, null, s);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RenewTarget")
    public JAXBElement<RenewTargetType> createRenewTarget(final RenewTargetType renewTargetType) {
        return new JAXBElement<RenewTargetType>(ObjectFactory._RenewTarget_QNAME, RenewTargetType.class, null, renewTargetType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Delegatable")
    public JAXBElement<Boolean> createDelegatable(final Boolean b) {
        return new JAXBElement<Boolean>(ObjectFactory._Delegatable_QNAME, Boolean.class, null, b);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "UseKey")
    public JAXBElement<UseKeyType> createUseKey(final UseKeyType useKeyType) {
        return new JAXBElement<UseKeyType>(ObjectFactory._UseKey_QNAME, UseKeyType.class, null, useKeyType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "DelegateTo")
    public JAXBElement<DelegateToType> createDelegateTo(final DelegateToType delegateToType) {
        return new JAXBElement<DelegateToType>(ObjectFactory._DelegateTo_QNAME, DelegateToType.class, null, delegateToType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Participants")
    public JAXBElement<ParticipantsType> createParticipants(final ParticipantsType participantsType) {
        return new JAXBElement<ParticipantsType>(ObjectFactory._Participants_QNAME, ParticipantsType.class, null, participantsType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "KeyType")
    public JAXBElement<String> createKeyType(final String s) {
        return new JAXBElement<String>(ObjectFactory._KeyType_QNAME, String.class, null, s);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Renewing")
    public JAXBElement<RenewingType> createRenewing(final RenewingType renewingType) {
        return new JAXBElement<RenewingType>(ObjectFactory._Renewing_QNAME, RenewingType.class, null, renewingType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "TokenType")
    public JAXBElement<String> createTokenType(final String s) {
        return new JAXBElement<String>(ObjectFactory._TokenType_QNAME, String.class, null, s);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Lifetime")
    public JAXBElement<LifetimeType> createLifetime(final LifetimeType lifetimeType) {
        return new JAXBElement<LifetimeType>(ObjectFactory._Lifetime_QNAME, LifetimeType.class, null, lifetimeType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "ValidateTarget")
    public JAXBElement<ValidateTargetType> createValidateTarget(final ValidateTargetType validateTargetType) {
        return new JAXBElement<ValidateTargetType>(ObjectFactory._ValidateTarget_QNAME, ValidateTargetType.class, null, validateTargetType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "Status")
    public JAXBElement<StatusType> createStatus(final StatusType statusType) {
        return new JAXBElement<StatusType>(ObjectFactory._Status_QNAME, StatusType.class, null, statusType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "RequestType")
    public JAXBElement<String> createRequestType(final String s) {
        return new JAXBElement<String>(ObjectFactory._RequestType_QNAME, String.class, null, s);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/ws-sx/ws-trust/200512", name = "BinaryExchange")
    public JAXBElement<BinaryExchangeType> createBinaryExchange(final BinaryExchangeType binaryExchangeType) {
        return new JAXBElement<BinaryExchangeType>(ObjectFactory._BinaryExchange_QNAME, BinaryExchangeType.class, null, binaryExchangeType);
    }
    
    static {
        _Issuer_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Issuer");
        _AllowPostdating_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "AllowPostdating");
        _RequestSecurityToken_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestSecurityToken");
        _RequestSecurityTokenResponse_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestSecurityTokenResponse");
        _RequestedSecurityToken_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestedSecurityToken");
        _RequestSecurityTokenResponseCollection_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestSecurityTokenResponseCollection");
        _SignatureAlgorithm_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "SignatureAlgorithm");
        _RenewTarget_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RenewTarget");
        _Delegatable_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Delegatable");
        _UseKey_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "UseKey");
        _DelegateTo_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "DelegateTo");
        _Participants_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Participants");
        _KeyType_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "KeyType");
        _Renewing_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Renewing");
        _TokenType_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "TokenType");
        _Lifetime_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Lifetime");
        _ValidateTarget_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "ValidateTarget");
        _Status_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "Status");
        _RequestType_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "RequestType");
        _BinaryExchange_QNAME = new QName("http://docs.oasis-open.org/ws-sx/ws-trust/200512", "BinaryExchange");
    }
}
