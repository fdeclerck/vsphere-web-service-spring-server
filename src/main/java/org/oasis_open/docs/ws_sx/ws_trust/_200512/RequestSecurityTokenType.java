// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.Map;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import com.rsa.names._2009._12.std_ext.ws_trust1_4.advice.AdviceSetType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestSecurityTokenType", propOrder = {})
public class RequestSecurityTokenType
{
    @XmlElement(name = "TokenType")
    protected String tokenType;
    @XmlElement(name = "RequestType", required = true)
    protected String requestType;
    @XmlElement(name = "Lifetime")
    protected LifetimeType lifetime;
    @XmlElement(name = "Renewing")
    protected RenewingType renewing;
    @XmlElement(name = "BinaryExchange")
    protected BinaryExchangeType binaryExchange;
    @XmlElement(name = "KeyType")
    protected String keyType;
    @XmlElement(name = "SignatureAlgorithm")
    protected String signatureAlgorithm;
    @XmlElement(name = "UseKey")
    protected UseKeyType useKey;
    @XmlElement(name = "DelegateTo")
    protected DelegateToType delegateTo;
    @XmlElement(name = "Delegatable")
    protected Boolean delegatable;
    @XmlElement(name = "Participants")
    protected ParticipantsType participants;
    @XmlElement(name = "AdviceSet", namespace = "http://www.rsa.com/names/2009/12/std-ext/WS-Trust1.4/advice")
    protected AdviceSetType adviceSet;
    @XmlElement(name = "ValidateTarget")
    protected ValidateTargetType validateTarget;
    @XmlElement(name = "RenewTarget")
    protected RenewTargetType renewTarget;
    @XmlAttribute(name = "Context")
    @XmlSchemaType(name = "anyURI")
    protected String context;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes;
    
    public RequestSecurityTokenType() {
        this.otherAttributes = new HashMap<QName, String>();
    }
    
    public String getTokenType() {
        return this.tokenType;
    }
    
    public void setTokenType(final String tokenType) {
        this.tokenType = tokenType;
    }
    
    public String getRequestType() {
        return this.requestType;
    }
    
    public void setRequestType(final String requestType) {
        this.requestType = requestType;
    }
    
    public LifetimeType getLifetime() {
        return this.lifetime;
    }
    
    public void setLifetime(final LifetimeType lifetime) {
        this.lifetime = lifetime;
    }
    
    public RenewingType getRenewing() {
        return this.renewing;
    }
    
    public void setRenewing(final RenewingType renewing) {
        this.renewing = renewing;
    }
    
    public BinaryExchangeType getBinaryExchange() {
        return this.binaryExchange;
    }
    
    public void setBinaryExchange(final BinaryExchangeType binaryExchange) {
        this.binaryExchange = binaryExchange;
    }
    
    public String getKeyType() {
        return this.keyType;
    }
    
    public void setKeyType(final String keyType) {
        this.keyType = keyType;
    }
    
    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }
    
    public void setSignatureAlgorithm(final String signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
    }
    
    public UseKeyType getUseKey() {
        return this.useKey;
    }
    
    public void setUseKey(final UseKeyType useKey) {
        this.useKey = useKey;
    }
    
    public DelegateToType getDelegateTo() {
        return this.delegateTo;
    }
    
    public void setDelegateTo(final DelegateToType delegateTo) {
        this.delegateTo = delegateTo;
    }
    
    public Boolean isDelegatable() {
        return this.delegatable;
    }
    
    public void setDelegatable(final Boolean delegatable) {
        this.delegatable = delegatable;
    }
    
    public ParticipantsType getParticipants() {
        return this.participants;
    }
    
    public void setParticipants(final ParticipantsType participants) {
        this.participants = participants;
    }
    
    public AdviceSetType getAdviceSet() {
        return this.adviceSet;
    }
    
    public void setAdviceSet(final AdviceSetType adviceSet) {
        this.adviceSet = adviceSet;
    }
    
    public ValidateTargetType getValidateTarget() {
        return this.validateTarget;
    }
    
    public void setValidateTarget(final ValidateTargetType validateTarget) {
        this.validateTarget = validateTarget;
    }
    
    public RenewTargetType getRenewTarget() {
        return this.renewTarget;
    }
    
    public void setRenewTarget(final RenewTargetType renewTarget) {
        this.renewTarget = renewTarget;
    }
    
    public String getContext() {
        return this.context;
    }
    
    public void setContext(final String context) {
        this.context = context;
    }
    
    public Map<QName, String> getOtherAttributes() {
        return this.otherAttributes;
    }
}
