
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComplianceFailure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComplianceFailure">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="failureType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="message" type="{urn:vim25}LocalizableMessage"/>
 *         &lt;element name="expressionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="failureValues" type="{urn:vim25}ComplianceFailureComplianceFailureValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplianceFailure", propOrder = {
    "failureType",
    "message",
    "expressionName",
    "failureValues"
})
public class ComplianceFailure
    extends DynamicData
{

    @XmlElement(required = true)
    protected String failureType;
    @XmlElement(required = true)
    protected LocalizableMessage message;
    protected String expressionName;
    protected List<ComplianceFailureComplianceFailureValues> failureValues;

    /**
     * Gets the value of the failureType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailureType() {
        return failureType;
    }

    /**
     * Sets the value of the failureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailureType(String value) {
        this.failureType = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link LocalizableMessage }
     *     
     */
    public LocalizableMessage getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizableMessage }
     *     
     */
    public void setMessage(LocalizableMessage value) {
        this.message = value;
    }

    /**
     * Gets the value of the expressionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpressionName() {
        return expressionName;
    }

    /**
     * Sets the value of the expressionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpressionName(String value) {
        this.expressionName = value;
    }

    /**
     * Gets the value of the failureValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the failureValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFailureValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComplianceFailureComplianceFailureValues }
     * 
     * 
     */
    public List<ComplianceFailureComplianceFailureValues> getFailureValues() {
        if (failureValues == null) {
            failureValues = new ArrayList<ComplianceFailureComplianceFailureValues>();
        }
        return this.failureValues;
    }

}
