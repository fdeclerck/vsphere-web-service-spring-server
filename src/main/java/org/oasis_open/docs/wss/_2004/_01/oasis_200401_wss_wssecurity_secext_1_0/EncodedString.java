// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EncodedString")
@XmlSeeAlso({ BinarySecurityTokenType.class, KeyIdentifierType.class })
public class EncodedString extends AttributedString
{
    @XmlAttribute(name = "EncodingType", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String encodingType;
    
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
