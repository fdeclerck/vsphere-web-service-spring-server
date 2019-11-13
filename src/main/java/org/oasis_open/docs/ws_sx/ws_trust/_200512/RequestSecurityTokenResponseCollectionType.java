// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestSecurityTokenResponseCollectionType", propOrder = { "requestSecurityTokenResponse" })
public class RequestSecurityTokenResponseCollectionType
{
    @XmlElement(name = "RequestSecurityTokenResponse", required = true)
    protected RequestSecurityTokenResponseType requestSecurityTokenResponse;
    
    public RequestSecurityTokenResponseType getRequestSecurityTokenResponse() {
        return this.requestSecurityTokenResponse;
    }
    
    public void setRequestSecurityTokenResponse(final RequestSecurityTokenResponseType requestSecurityTokenResponse) {
        this.requestSecurityTokenResponse = requestSecurityTokenResponse;
    }
}
