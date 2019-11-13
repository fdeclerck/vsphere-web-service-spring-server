// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubjectType", propOrder = { "nameID", "subjectConfirmation" })
public class SubjectType
{
    @XmlElement(name = "NameID", required = true)
    protected NameIDType nameID;
    @XmlElement(name = "SubjectConfirmation", required = true)
    protected SubjectConfirmationType subjectConfirmation;
    
    public NameIDType getNameID() {
        return this.nameID;
    }
    
    public void setNameID(final NameIDType nameID) {
        this.nameID = nameID;
    }
    
    public SubjectConfirmationType getSubjectConfirmation() {
        return this.subjectConfirmation;
    }
    
    public void setSubjectConfirmation(final SubjectConfirmationType subjectConfirmation) {
        this.subjectConfirmation = subjectConfirmation;
    }
}
