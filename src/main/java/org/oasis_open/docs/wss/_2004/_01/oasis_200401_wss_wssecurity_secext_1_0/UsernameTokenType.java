// 
// Decompiled by Procyon v0.5.36
// 

package org.oasis_open.docs.wss._2004._01.oasis_200401_wss_wssecurity_secext_1_0;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsernameTokenType", propOrder = { "username", "password" })
public class UsernameTokenType
{
    @XmlElement(name = "Username", required = true)
    protected AttributedString username;
    @XmlElement(name = "Password")
    protected PasswordString password;
    @XmlAttribute(name = "Id", namespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    
    public AttributedString getUsername() {
        return this.username;
    }
    
    public void setUsername(final AttributedString username) {
        this.username = username;
    }
    
    public PasswordString getPassword() {
        return this.password;
    }
    
    public void setPassword(final PasswordString password) {
        this.password = password;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
}
