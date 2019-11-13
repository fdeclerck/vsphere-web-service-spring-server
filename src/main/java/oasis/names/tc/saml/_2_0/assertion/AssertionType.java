// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAttribute;
import org.w3._2000._09.xmldsig.SignatureType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssertionType", propOrder = { "issuer", "signature", "subject", "conditions", "advice", "authnStatement", "attributeStatement" })
public class AssertionType
{
    @XmlElement(name = "Issuer", required = true)
    protected NameIDType issuer;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected SignatureType signature;
    @XmlElement(name = "Subject", required = true)
    protected SubjectType subject;
    @XmlElement(name = "Conditions", required = true)
    protected ConditionsType conditions;
    @XmlElement(name = "Advice")
    protected AdviceType advice;
    @XmlElement(name = "AuthnStatement", required = true)
    protected AuthnStatementType authnStatement;
    @XmlElement(name = "AttributeStatement")
    protected AttributeStatementType attributeStatement;
    @XmlAttribute(name = "Version", required = true)
    protected String version;
    @XmlAttribute(name = "ID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlAttribute(name = "IssueInstant", required = true)
    protected XMLGregorianCalendar issueInstant;
    
    public NameIDType getIssuer() {
        return this.issuer;
    }
    
    public void setIssuer(final NameIDType issuer) {
        this.issuer = issuer;
    }
    
    public SignatureType getSignature() {
        return this.signature;
    }
    
    public void setSignature(final SignatureType signature) {
        this.signature = signature;
    }
    
    public SubjectType getSubject() {
        return this.subject;
    }
    
    public void setSubject(final SubjectType subject) {
        this.subject = subject;
    }
    
    public ConditionsType getConditions() {
        return this.conditions;
    }
    
    public void setConditions(final ConditionsType conditions) {
        this.conditions = conditions;
    }
    
    public AdviceType getAdvice() {
        return this.advice;
    }
    
    public void setAdvice(final AdviceType advice) {
        this.advice = advice;
    }
    
    public AuthnStatementType getAuthnStatement() {
        return this.authnStatement;
    }
    
    public void setAuthnStatement(final AuthnStatementType authnStatement) {
        this.authnStatement = authnStatement;
    }
    
    public AttributeStatementType getAttributeStatement() {
        return this.attributeStatement;
    }
    
    public void setAttributeStatement(final AttributeStatementType attributeStatement) {
        this.attributeStatement = attributeStatement;
    }
    
    public String getVersion() {
        if (this.version == null) {
            return "2.0";
        }
        return this.version;
    }
    
    public void setVersion(final String version) {
        this.version = version;
    }
    
    public String getID() {
        return this.id;
    }
    
    public void setID(final String id) {
        this.id = id;
    }
    
    public XMLGregorianCalendar getIssueInstant() {
        return this.issueInstant;
    }
    
    public void setIssueInstant(final XMLGregorianCalendar issueInstant) {
        this.issueInstant = issueInstant;
    }
}
