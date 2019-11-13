
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSMacLearningPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSMacLearningPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InheritablePolicy">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="allowUnicastFlooding" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="limit" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="limitPolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSMacLearningPolicy", propOrder = {
    "enabled",
    "allowUnicastFlooding",
    "limit",
    "limitPolicy"
})
public class DVSMacLearningPolicy
    extends InheritablePolicy
{

    protected boolean enabled;
    protected Boolean allowUnicastFlooding;
    protected Integer limit;
    protected String limitPolicy;

    /**
     * Gets the value of the enabled property.
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the allowUnicastFlooding property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowUnicastFlooding() {
        return allowUnicastFlooding;
    }

    /**
     * Sets the value of the allowUnicastFlooding property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowUnicastFlooding(Boolean value) {
        this.allowUnicastFlooding = value;
    }

    /**
     * Gets the value of the limit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the value of the limit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLimit(Integer value) {
        this.limit = value;
    }

    /**
     * Gets the value of the limitPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLimitPolicy() {
        return limitPolicy;
    }

    /**
     * Sets the value of the limitPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLimitPolicy(String value) {
        this.limitPolicy = value;
    }

}
