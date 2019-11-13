// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestSecurityTokenResponseType", propOrder = {})
public class RequestSecurityTokenResponseType
{
    @XmlElement(name = "TokenType", required = true)
    protected String tokenType;
    @XmlElement(name = "Lifetime")
    protected LifetimeType lifetime;
    @XmlElement(name = "RequestedSecurityToken")
    protected RequestedSecurityTokenType requestedSecurityToken;
    @XmlElement(name = "Renewing")
    protected RenewingType renewing;
    @XmlElement(name = "BinaryExchange")
    protected BinaryExchangeType binaryExchange;
    @XmlElement(name = "KeyType")
    protected String keyType;
    @XmlElement(name = "SignatureAlgorithm")
    protected String signatureAlgorithm;
    @XmlElement(name = "Delegatable")
    protected Boolean delegatable;
    @XmlElement(name = "Status")
    protected StatusType status;
    @XmlAttribute(name = "Context")
    @XmlSchemaType(name = "anyURI")
    protected String context;
    
    public String getTokenType() {
        return this.tokenType;
    }
    
    public void setTokenType(final String tokenType) {
        this.tokenType = tokenType;
    }
    
    public LifetimeType getLifetime() {
        return this.lifetime;
    }
    
    public void setLifetime(final LifetimeType lifetime) {
        this.lifetime = lifetime;
    }
    
    public RequestedSecurityTokenType getRequestedSecurityToken() {
        return this.requestedSecurityToken;
    }
    
    public void setRequestedSecurityToken(final RequestedSecurityTokenType requestedSecurityToken) {
        this.requestedSecurityToken = requestedSecurityToken;
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
    
    public Boolean isDelegatable() {
        return this.delegatable;
    }
    
    public void setDelegatable(final Boolean delegatable) {
        this.delegatable = delegatable;
    }
    
    public StatusType getStatus() {
        return this.status;
    }
    
    public void setStatus(final StatusType status) {
        this.status = status;
    }
    
    public String getContext() {
        return this.context;
    }
    
    public void setContext(final String context) {
        this.context = context;
    }
}
