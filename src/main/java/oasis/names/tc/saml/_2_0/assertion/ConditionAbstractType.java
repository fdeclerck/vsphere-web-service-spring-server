// 
// Decompiled by Procyon v0.5.36
// 

package oasis.names.tc.saml._2_0.assertion;

import oasis.names.tc.saml._2_0.conditions.delegation.DelegationRestrictionType;
import com.rsa.names._2009._12.std_ext.saml2.RenewRestrictionType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionAbstractType")
@XmlSeeAlso({ ProxyRestrictionType.class, AudienceRestrictionType.class, RenewRestrictionType.class, DelegationRestrictionType.class })
public abstract class ConditionAbstractType
{
}
