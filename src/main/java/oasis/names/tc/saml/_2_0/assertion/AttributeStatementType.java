// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeStatementType", propOrder = { "attribute" })
public class AttributeStatementType extends StatementAbstractType
{
    @XmlElement(name = "Attribute")
    protected List<AttributeType> attribute;
    
    public List<AttributeType> getAttribute() {
        if (this.attribute == null) {
            this.attribute = new ArrayList<AttributeType>();
        }
        return this.attribute;
    }
}
