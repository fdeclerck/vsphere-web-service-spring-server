// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.conditions.delegation;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import oasis.names.tc.saml._2_0.assertion.ConditionAbstractType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DelegationRestrictionType", propOrder = { "delegate" })
public class DelegationRestrictionType extends ConditionAbstractType
{
    @XmlElement(name = "Delegate", required = true)
    protected List<DelegateType> delegate;
    
    public List<DelegateType> getDelegate() {
        if (this.delegate == null) {
            this.delegate = new ArrayList<DelegateType>();
        }
        return this.delegate;
    }
}
