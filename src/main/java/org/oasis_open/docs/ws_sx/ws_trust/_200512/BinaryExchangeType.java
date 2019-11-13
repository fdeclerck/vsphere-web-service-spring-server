// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.ws_sx.ws_trust._200512;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BinaryExchangeType", propOrder = { "value" })
public class BinaryExchangeType
{
    @XmlValue
    protected String value;
    @XmlAttribute(name = "ValueType", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String valueType;
    @XmlAttribute(name = "EncodingType", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String encodingType;
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(final String value) {
        this.value = value;
    }
    
    public String getValueType() {
        if (this.valueType == null) {
            return "http://schemas.xmlsoap.org/ws/2005/02/trust/spnego";
        }
        return this.valueType;
    }
    
    public void setValueType(final String valueType) {
        this.valueType = valueType;
    }
    
    public String getEncodingType() {
        if (this.encodingType == null) {
            return "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary";
        }
        return this.encodingType;
    }
    
    public void setEncodingType(final String encodingType) {
        this.encodingType = encodingType;
    }
}
