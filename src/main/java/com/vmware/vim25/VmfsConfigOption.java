
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmfsConfigOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmfsConfigOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="blockSizeOption" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unmapGranularityOption" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="unmapBandwidthFixedValue" type="{urn:vim25}LongOption" minOccurs="0"/>
 *         &lt;element name="unmapBandwidthDynamicMin" type="{urn:vim25}LongOption" minOccurs="0"/>
 *         &lt;element name="unmapBandwidthDynamicMax" type="{urn:vim25}LongOption" minOccurs="0"/>
 *         &lt;element name="unmapBandwidthIncrement" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmfsConfigOption", propOrder = {
    "blockSizeOption",
    "unmapGranularityOption",
    "unmapBandwidthFixedValue",
    "unmapBandwidthDynamicMin",
    "unmapBandwidthDynamicMax",
    "unmapBandwidthIncrement"
})
public class VmfsConfigOption
    extends DynamicData
{

    protected int blockSizeOption;
    @XmlElement(type = Integer.class)
    protected List<Integer> unmapGranularityOption;
    protected LongOption unmapBandwidthFixedValue;
    protected LongOption unmapBandwidthDynamicMin;
    protected LongOption unmapBandwidthDynamicMax;
    protected Long unmapBandwidthIncrement;

    /**
     * Gets the value of the blockSizeOption property.
     * 
     */
    public int getBlockSizeOption() {
        return blockSizeOption;
    }

    /**
     * Sets the value of the blockSizeOption property.
     * 
     */
    public void setBlockSizeOption(int value) {
        this.blockSizeOption = value;
    }

    /**
     * Gets the value of the unmapGranularityOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unmapGranularityOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnmapGranularityOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getUnmapGranularityOption() {
        if (unmapGranularityOption == null) {
            unmapGranularityOption = new ArrayList<Integer>();
        }
        return this.unmapGranularityOption;
    }

    /**
     * Gets the value of the unmapBandwidthFixedValue property.
     * 
     * @return
     *     possible object is
     *     {@link LongOption }
     *     
     */
    public LongOption getUnmapBandwidthFixedValue() {
        return unmapBandwidthFixedValue;
    }

    /**
     * Sets the value of the unmapBandwidthFixedValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongOption }
     *     
     */
    public void setUnmapBandwidthFixedValue(LongOption value) {
        this.unmapBandwidthFixedValue = value;
    }

    /**
     * Gets the value of the unmapBandwidthDynamicMin property.
     * 
     * @return
     *     possible object is
     *     {@link LongOption }
     *     
     */
    public LongOption getUnmapBandwidthDynamicMin() {
        return unmapBandwidthDynamicMin;
    }

    /**
     * Sets the value of the unmapBandwidthDynamicMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongOption }
     *     
     */
    public void setUnmapBandwidthDynamicMin(LongOption value) {
        this.unmapBandwidthDynamicMin = value;
    }

    /**
     * Gets the value of the unmapBandwidthDynamicMax property.
     * 
     * @return
     *     possible object is
     *     {@link LongOption }
     *     
     */
    public LongOption getUnmapBandwidthDynamicMax() {
        return unmapBandwidthDynamicMax;
    }

    /**
     * Sets the value of the unmapBandwidthDynamicMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongOption }
     *     
     */
    public void setUnmapBandwidthDynamicMax(LongOption value) {
        this.unmapBandwidthDynamicMax = value;
    }

    /**
     * Gets the value of the unmapBandwidthIncrement property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUnmapBandwidthIncrement() {
        return unmapBandwidthIncrement;
    }

    /**
     * Sets the value of the unmapBandwidthIncrement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUnmapBandwidthIncrement(Long value) {
        this.unmapBandwidthIncrement = value;
    }

}
