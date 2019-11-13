// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    private static final QName _Assertion_QNAME;
    private static final QName _AudienceRestriction_QNAME;
    private static final QName _AuthnContext_QNAME;
    private static final QName _Condition_QNAME;
    private static final QName _AuthnStatement_QNAME;
    private static final QName _SubjectConfirmation_QNAME;
    private static final QName _Issuer_QNAME;
    private static final QName _NameID_QNAME;
    private static final QName _AttributeStatement_QNAME;
    private static final QName _Attribute_QNAME;
    private static final QName _Subject_QNAME;
    private static final QName _Advice_QNAME;
    private static final QName _SubjectConfirmationData_QNAME;
    private static final QName _Conditions_QNAME;
    private static final QName _AttributeValue_QNAME;
    private static final QName _AuthnContextClassRef_QNAME;
    private static final QName _Audience_QNAME;
    private static final QName _ProxyRestriction_QNAME;
    
    public ConditionsType createConditionsType() {
        return new ConditionsType();
    }
    
    public AuthnContextType createAuthnContextType() {
        return new AuthnContextType();
    }
    
    public SubjectConfirmationDataType createSubjectConfirmationDataType() {
        return new SubjectConfirmationDataType();
    }
    
    public SubjectType createSubjectType() {
        return new SubjectType();
    }
    
    public SubjectConfirmationType createSubjectConfirmationType() {
        return new SubjectConfirmationType();
    }
    
    public AdviceType createAdviceType() {
        return new AdviceType();
    }
    
    public AuthnStatementType createAuthnStatementType() {
        return new AuthnStatementType();
    }
    
    public AssertionType createAssertionType() {
        return new AssertionType();
    }
    
    public NameIDType createNameIDType() {
        return new NameIDType();
    }
    
    public ProxyRestrictionType createProxyRestrictionType() {
        return new ProxyRestrictionType();
    }
    
    public AttributeType createAttributeType() {
        return new AttributeType();
    }
    
    public AttributeStatementType createAttributeStatementType() {
        return new AttributeStatementType();
    }
    
    public AudienceRestrictionType createAudienceRestrictionType() {
        return new AudienceRestrictionType();
    }
    
    public KeyInfoConfirmationDataType createKeyInfoConfirmationDataType() {
        return new KeyInfoConfirmationDataType();
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "Assertion")
    public JAXBElement<AssertionType> createAssertion(final AssertionType assertionType) {
        return new JAXBElement<AssertionType>(ObjectFactory._Assertion_QNAME, AssertionType.class, null, assertionType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "AudienceRestriction")
    public JAXBElement<AudienceRestrictionType> createAudienceRestriction(final AudienceRestrictionType audienceRestrictionType) {
        return new JAXBElement<AudienceRestrictionType>(ObjectFactory._AudienceRestriction_QNAME, AudienceRestrictionType.class, null, audienceRestrictionType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "AuthnContext")
    public JAXBElement<AuthnContextType> createAuthnContext(final AuthnContextType authnContextType) {
        return new JAXBElement<AuthnContextType>(ObjectFactory._AuthnContext_QNAME, AuthnContextType.class, null, authnContextType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "Condition")
    public JAXBElement<ConditionAbstractType> createCondition(final ConditionAbstractType conditionAbstractType) {
        return new JAXBElement<ConditionAbstractType>(ObjectFactory._Condition_QNAME, ConditionAbstractType.class, null, conditionAbstractType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "AuthnStatement")
    public JAXBElement<AuthnStatementType> createAuthnStatement(final AuthnStatementType authnStatementType) {
        return new JAXBElement<AuthnStatementType>(ObjectFactory._AuthnStatement_QNAME, AuthnStatementType.class, null, authnStatementType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "SubjectConfirmation")
    public JAXBElement<SubjectConfirmationType> createSubjectConfirmation(final SubjectConfirmationType subjectConfirmationType) {
        return new JAXBElement<SubjectConfirmationType>(ObjectFactory._SubjectConfirmation_QNAME, SubjectConfirmationType.class, null, subjectConfirmationType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "Issuer")
    public JAXBElement<NameIDType> createIssuer(final NameIDType nameIDType) {
        return new JAXBElement<NameIDType>(ObjectFactory._Issuer_QNAME, NameIDType.class, null, nameIDType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "NameID")
    public JAXBElement<NameIDType> createNameID(final NameIDType nameIDType) {
        return new JAXBElement<NameIDType>(ObjectFactory._NameID_QNAME, NameIDType.class, null, nameIDType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "AttributeStatement")
    public JAXBElement<AttributeStatementType> createAttributeStatement(final AttributeStatementType attributeStatementType) {
        return new JAXBElement<AttributeStatementType>(ObjectFactory._AttributeStatement_QNAME, AttributeStatementType.class, null, attributeStatementType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "Attribute")
    public JAXBElement<AttributeType> createAttribute(final AttributeType attributeType) {
        return new JAXBElement<AttributeType>(ObjectFactory._Attribute_QNAME, AttributeType.class, null, attributeType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "Subject")
    public JAXBElement<SubjectType> createSubject(final SubjectType subjectType) {
        return new JAXBElement<SubjectType>(ObjectFactory._Subject_QNAME, SubjectType.class, null, subjectType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "Advice")
    public JAXBElement<AdviceType> createAdvice(final AdviceType adviceType) {
        return new JAXBElement<AdviceType>(ObjectFactory._Advice_QNAME, AdviceType.class, null, adviceType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "SubjectConfirmationData")
    public JAXBElement<SubjectConfirmationDataType> createSubjectConfirmationData(final SubjectConfirmationDataType subjectConfirmationDataType) {
        return new JAXBElement<SubjectConfirmationDataType>(ObjectFactory._SubjectConfirmationData_QNAME, SubjectConfirmationDataType.class, null, subjectConfirmationDataType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "Conditions")
    public JAXBElement<ConditionsType> createConditions(final ConditionsType conditionsType) {
        return new JAXBElement<ConditionsType>(ObjectFactory._Conditions_QNAME, ConditionsType.class, null, conditionsType);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "AttributeValue")
    public JAXBElement<Object> createAttributeValue(final Object o) {
        return new JAXBElement<Object>(ObjectFactory._AttributeValue_QNAME, Object.class, null, o);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "AuthnContextClassRef")
    public JAXBElement<String> createAuthnContextClassRef(final String s) {
        return new JAXBElement<String>(ObjectFactory._AuthnContextClassRef_QNAME, String.class, null, s);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "Audience")
    public JAXBElement<String> createAudience(final String s) {
        return new JAXBElement<String>(ObjectFactory._Audience_QNAME, String.class, null, s);
    }
    
    @XmlElementDecl(namespace = "urn:oasis:names:tc:SAML:2.0:assertion", name = "ProxyRestriction")
    public JAXBElement<ProxyRestrictionType> createProxyRestriction(final ProxyRestrictionType proxyRestrictionType) {
        return new JAXBElement<ProxyRestrictionType>(ObjectFactory._ProxyRestriction_QNAME, ProxyRestrictionType.class, null, proxyRestrictionType);
    }
    
    static {
        _Assertion_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "Assertion");
        _AudienceRestriction_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "AudienceRestriction");
        _AuthnContext_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "AuthnContext");
        _Condition_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "Condition");
        _AuthnStatement_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "AuthnStatement");
        _SubjectConfirmation_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "SubjectConfirmation");
        _Issuer_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "Issuer");
        _NameID_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "NameID");
        _AttributeStatement_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "AttributeStatement");
        _Attribute_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "Attribute");
        _Subject_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "Subject");
        _Advice_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "Advice");
        _SubjectConfirmationData_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "SubjectConfirmationData");
        _Conditions_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "Conditions");
        _AttributeValue_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "AttributeValue");
        _AuthnContextClassRef_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "AuthnContextClassRef");
        _Audience_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "Audience");
        _ProxyRestriction_QNAME = new QName("urn:oasis:names:tc:SAML:2.0:assertion", "ProxyRestriction");
    }
}
