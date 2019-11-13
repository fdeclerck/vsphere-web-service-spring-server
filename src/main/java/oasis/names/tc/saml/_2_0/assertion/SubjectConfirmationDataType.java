// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlMixed;
import java.util.List;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubjectConfirmationDataType", propOrder = { "content" })
@XmlSeeAlso({ KeyInfoConfirmationDataType.class })
public class SubjectConfirmationDataType
{
    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<Object> content;
    @XmlAttribute(name = "NotOnOrAfter")
    protected XMLGregorianCalendar notOnOrAfter;
    
    public List<Object> getContent() {
        if (this.content == null) {
            this.content = new ArrayList<Object>();
        }
        return this.content;
    }
    
    public XMLGregorianCalendar getNotOnOrAfter() {
        return this.notOnOrAfter;
    }
    
    public void setNotOnOrAfter(final XMLGregorianCalendar notOnOrAfter) {
        this.notOnOrAfter = notOnOrAfter;
    }
}
