// 
// Decompiled by Procyon v0.5.36
// 

package com.rsa.names._2009._12.std_ext.saml2;

import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import oasis.names.tc.saml._2_0.assertion.ConditionAbstractType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RenewRestrictionType")
public class RenewRestrictionType extends ConditionAbstractType
{
    @XmlAttribute(name = "Count")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger count;
    @XmlAttribute(name = "Postdatable")
    protected Boolean postdatable;
    @XmlAttribute(name = "RenewExpired")
    protected Boolean renewExpired;
    
    public BigInteger getCount() {
        if (this.count == null) {
            return new BigInteger("0");
        }
        return this.count;
    }
    
    public void setCount(final BigInteger count) {
        this.count = count;
    }
    
    public boolean isPostdatable() {
        return this.postdatable != null && this.postdatable;
    }
    
    public void setPostdatable(final Boolean postdatable) {
        this.postdatable = postdatable;
    }
    
    public boolean isRenewExpired() {
        return this.renewExpired != null && this.renewExpired;
    }
    
    public void setRenewExpired(final Boolean renewExpired) {
        this.renewExpired = renewExpired;
    }
}
