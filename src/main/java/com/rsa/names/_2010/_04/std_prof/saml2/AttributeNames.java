// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2010._04.std_prof.saml2;

import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AttributeNames", namespace = "http://www.rsa.com/names/2010/04/std-prof/SAML2.0")
@XmlEnum
public enum AttributeNames
{
    @XmlEnumValue("http://rsa.com/schemas/attr-names/2009/01/GroupIdentity")
    HTTP_RSA_COM_SCHEMAS_ATTR_NAMES_2009_01_GROUP_IDENTITY("http://rsa.com/schemas/attr-names/2009/01/GroupIdentity"), 
    @XmlEnumValue("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/givenname")
    HTTP_SCHEMAS_XMLSOAP_ORG_WS_2005_05_IDENTITY_CLAIMS_GIVENNAME("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/givenname"), 
    @XmlEnumValue("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/surname")
    HTTP_SCHEMAS_XMLSOAP_ORG_WS_2005_05_IDENTITY_CLAIMS_SURNAME("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/surname");
    
    private final String value;
    
    private AttributeNames(final String value) {
        this.value = value;
    }
    
    public String value() {
        return this.value;
    }
    
    public static AttributeNames fromValue(final String s) {
        for (final AttributeNames attributeNames : values()) {
            if (attributeNames.value.equals(s)) {
                return attributeNames;
            }
        }
        throw new IllegalArgumentException(s);
    }
}
