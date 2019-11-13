// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.wsaddressing.W3CEndpointReference;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParticipantType", propOrder = { "endpointReference" })
public class ParticipantType
{
    @XmlElement(name = "EndpointReference", namespace = "http://www.w3.org/2005/08/addressing", required = true)
    protected W3CEndpointReference endpointReference;
    
    public W3CEndpointReference getEndpointReference() {
        return this.endpointReference;
    }
    
    public void setEndpointReference(final W3CEndpointReference endpointReference) {
        this.endpointReference = endpointReference;
    }
}
