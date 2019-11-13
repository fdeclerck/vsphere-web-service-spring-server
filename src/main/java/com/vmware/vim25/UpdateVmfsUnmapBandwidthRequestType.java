
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateVmfsUnmapBandwidthRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateVmfsUnmapBandwidthRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="vmfsUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="unmapBandwidthSpec" type="{urn:vim25}VmfsUnmapBandwidthSpec"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateVmfsUnmapBandwidthRequestType", propOrder = {
    "_this",
    "vmfsUuid",
    "unmapBandwidthSpec"
})
public class UpdateVmfsUnmapBandwidthRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected String vmfsUuid;
    @XmlElement(required = true)
    protected VmfsUnmapBandwidthSpec unmapBandwidthSpec;

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
     * Gets the value of the vmfsUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmfsUuid() {
        return vmfsUuid;
    }

    /**
     * Sets the value of the vmfsUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmfsUuid(String value) {
        this.vmfsUuid = value;
    }

    /**
     * Gets the value of the unmapBandwidthSpec property.
     * 
     * @return
     *     possible object is
     *     {@link VmfsUnmapBandwidthSpec }
     *     
     */
    public VmfsUnmapBandwidthSpec getUnmapBandwidthSpec() {
        return unmapBandwidthSpec;
    }

    /**
     * Sets the value of the unmapBandwidthSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link VmfsUnmapBandwidthSpec }
     *     
     */
    public void setUnmapBandwidthSpec(VmfsUnmapBandwidthSpec value) {
        this.unmapBandwidthSpec = value;
    }

}
