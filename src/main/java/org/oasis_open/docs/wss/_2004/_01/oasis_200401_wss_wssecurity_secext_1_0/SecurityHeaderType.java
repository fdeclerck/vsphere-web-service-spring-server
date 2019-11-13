// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.Map;
import org.w3._2000._09.xmldsig.SignatureType;
import oasis.names.tc.saml._2_0.assertion.AssertionType;
import javax.xml.bind.annotation.XmlElement;
import org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_utility_1_0.TimestampType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityHeaderType", propOrder = {})
public class SecurityHeaderType
{
    @XmlElement(name = "Timestamp", namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", required = true)
    protected TimestampType timestamp;
    @XmlElement(name = "UsernameToken")
    protected UsernameTokenType usernameToken;
    @XmlElement(name = "BinarySecurityToken")
    protected BinarySecurityTokenType binarySecurityToken;
    @XmlElement(name = "Assertion", namespace = "urn:oasis:names:tc:SAML:2.0:assertion")
    protected AssertionType assertion;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes;
    
    public SecurityHeaderType() {
        this.otherAttributes = new HashMap<QName, String>();
    }
    
    public TimestampType getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(final TimestampType timestamp) {
        this.timestamp = timestamp;
    }
    
    public UsernameTokenType getUsernameToken() {
        return this.usernameToken;
    }
    
    public void setUsernameToken(final UsernameTokenType usernameToken) {
        this.usernameToken = usernameToken;
    }
    
    public BinarySecurityTokenType getBinarySecurityToken() {
        return this.binarySecurityToken;
    }
    
    public void setBinarySecurityToken(final BinarySecurityTokenType binarySecurityToken) {
        this.binarySecurityToken = binarySecurityToken;
    }
    
    public AssertionType getAssertion() {
        return this.assertion;
    }
    
    public void setAssertion(final AssertionType assertion) {
        this.assertion = assertion;
    }
    
    public SignatureType getSignature() {
        return this.signature;
    }
    
    public void setSignature(final SignatureType signature) {
        this.signature = signature;
    }
    
    public Map<QName, String> getOtherAttributes() {
        return this.otherAttributes;
    }
}
