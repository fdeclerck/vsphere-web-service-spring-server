// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _Nonce_QNAME;
    private static final QName _Password_QNAME;
    private static final QName _Reference_QNAME;
    private static final QName _Security_QNAME;
    private static final QName _SecurityTokenReference_QNAME;
    private static final QName _BinarySecurityToken_QNAME;
    private static final QName _KeyIdentifier_QNAME;
    private static final QName _TransformationParameters_QNAME;
    private static final QName _UsernameToken_QNAME;
    
    public SecurityHeaderType createSecurityHeaderType() {
        return new SecurityHeaderType();
    }
    
    public TransformationParametersType createTransformationParametersType() {
        return new TransformationParametersType();
    }
    
    public PasswordString createPasswordString() {
        return new PasswordString();
    }
    
    public SecurityTokenReferenceType createSecurityTokenReferenceType() {
        return new SecurityTokenReferenceType();
    }
    
    public UsernameTokenType createUsernameTokenType() {
        return new UsernameTokenType();
    }
    
    public BinarySecurityTokenType createBinarySecurityTokenType() {
        return new BinarySecurityTokenType();
    }
    
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }
    
    public EncodedString createEncodedString() {
        return new EncodedString();
    }
    
    public KeyIdentifierType createKeyIdentifierType() {
        return new KeyIdentifierType();
    }
    
    public AttributedString createAttributedString() {
        return new AttributedString();
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", name = "Nonce")
    public JAXBElement<EncodedString> createNonce(final EncodedString encodedString) {
        return new JAXBElement<EncodedString>(ObjectFactory._Nonce_QNAME, EncodedString.class, null, encodedString);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", name = "Password")
    public JAXBElement<PasswordString> createPassword(final PasswordString passwordString) {
        return new JAXBElement<PasswordString>(ObjectFactory._Password_QNAME, PasswordString.class, null, passwordString);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", name = "Reference")
    public JAXBElement<ReferenceType> createReference(final ReferenceType referenceType) {
        return new JAXBElement<ReferenceType>(ObjectFactory._Reference_QNAME, ReferenceType.class, null, referenceType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", name = "Security")
    public JAXBElement<SecurityHeaderType> createSecurity(final SecurityHeaderType securityHeaderType) {
        return new JAXBElement<SecurityHeaderType>(ObjectFactory._Security_QNAME, SecurityHeaderType.class, null, securityHeaderType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", name = "SecurityTokenReference")
    public JAXBElement<SecurityTokenReferenceType> createSecurityTokenReference(final SecurityTokenReferenceType securityTokenReferenceType) {
        return new JAXBElement<SecurityTokenReferenceType>(ObjectFactory._SecurityTokenReference_QNAME, SecurityTokenReferenceType.class, null, securityTokenReferenceType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", name = "BinarySecurityToken")
    public JAXBElement<BinarySecurityTokenType> createBinarySecurityToken(final BinarySecurityTokenType binarySecurityTokenType) {
        return new JAXBElement<BinarySecurityTokenType>(ObjectFactory._BinarySecurityToken_QNAME, BinarySecurityTokenType.class, null, binarySecurityTokenType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", name = "KeyIdentifier")
    public JAXBElement<KeyIdentifierType> createKeyIdentifier(final KeyIdentifierType keyIdentifierType) {
        return new JAXBElement<KeyIdentifierType>(ObjectFactory._KeyIdentifier_QNAME, KeyIdentifierType.class, null, keyIdentifierType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", name = "TransformationParameters")
    public JAXBElement<TransformationParametersType> createTransformationParameters(final TransformationParametersType transformationParametersType) {
        return new JAXBElement<TransformationParametersType>(ObjectFactory._TransformationParameters_QNAME, TransformationParametersType.class, null, transformationParametersType);
    }
    
    @XmlElementDecl(namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", name = "UsernameToken")
    public JAXBElement<UsernameTokenType> createUsernameToken(final UsernameTokenType usernameTokenType) {
        return new JAXBElement<UsernameTokenType>(ObjectFactory._UsernameToken_QNAME, UsernameTokenType.class, null, usernameTokenType);
    }
    
    static {
        _Nonce_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Nonce");
        _Password_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Password");
        _Reference_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Reference");
        _Security_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
        _SecurityTokenReference_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "SecurityTokenReference");
        _BinarySecurityToken_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "BinarySecurityToken");
        _KeyIdentifier_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "KeyIdentifier");
        _TransformationParameters_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "TransformationParameters");
        _UsernameToken_QNAME = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "UsernameToken");
    }
}
