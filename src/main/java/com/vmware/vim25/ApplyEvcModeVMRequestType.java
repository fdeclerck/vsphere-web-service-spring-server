
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ApplyEvcModeVMRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ApplyEvcModeVMRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="mask" type="{urn:vim25}HostFeatureMask" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="completeMasks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplyEvcModeVMRequestType", propOrder = {
    "_this",
    "mask",
    "completeMasks"
})
public class ApplyEvcModeVMRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    protected List<HostFeatureMask> mask;
    protected Boolean completeMasks;

    /**
     * Gets the value of the this property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getThis() {
        return _this;
    }

    /**
     * Sets the value of the this property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setThis(ManagedObjectReference value) {
        this._this = value;
    }

    /**
     * Gets the value of the mask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostFeatureMask }
     * 
     * 
     */
    public List<HostFeatureMask> getMask() {
        if (mask == null) {
            mask = new ArrayList<HostFeatureMask>();
        }
        return this.mask;
    }

    /**
     * Gets the value of the completeMasks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCompleteMasks() {
        return completeMasks;
    }

    /**
     * Sets the value of the completeMasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCompleteMasks(Boolean value) {
        this.completeMasks = value;
    }

}
