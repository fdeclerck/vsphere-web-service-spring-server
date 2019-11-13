// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubjectConfirmationType", propOrder = { "nameID", "subjectConfirmationData" })
public class SubjectConfirmationType
{
    @XmlElement(name = "NameID")
    protected NameIDType nameID;
    @XmlElement(name = "SubjectConfirmationData", required = true)
    protected SubjectConfirmationDataType subjectConfirmationData;
    @XmlAttribute(name = "Method", required = true)
    protected String method;
    
    public NameIDType getNameID() {
        return this.nameID;
    }
    
    public void setNameID(final NameIDType nameID) {
        this.nameID = nameID;
    }
    
    public SubjectConfirmationDataType getSubjectConfirmationData() {
        return this.subjectConfirmationData;
    }
    
    public void setSubjectConfirmationData(final SubjectConfirmationDataType subjectConfirmationData) {
        this.subjectConfirmationData = subjectConfirmationData;
    }
    
    public String getMethod() {
        return this.method;
    }
    
    public void setMethod(final String method) {
        this.method = method;
    }
}
