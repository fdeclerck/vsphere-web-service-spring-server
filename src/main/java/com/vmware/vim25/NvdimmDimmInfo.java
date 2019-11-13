
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NvdimmDimmInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NvdimmDimmInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="dimmHandle" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="healthInfo" type="{urn:vim25}NvdimmHealthInfo"/>
 *         &lt;element name="totalCapacity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="persistentCapacity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="availablePersistentCapacity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="volatileCapacity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="availableVolatileCapacity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="blockCapacity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="regionInfo" type="{urn:vim25}NvdimmRegionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="representationString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NvdimmDimmInfo", propOrder = {
    "dimmHandle",
    "healthInfo",
    "totalCapacity",
    "persistentCapacity",
    "availablePersistentCapacity",
    "volatileCapacity",
    "availableVolatileCapacity",
    "blockCapacity",
    "regionInfo",
    "representationString"
})
public class NvdimmDimmInfo
    extends DynamicData
{

    protected int dimmHandle;
    @XmlElement(required = true)
    protected NvdimmHealthInfo healthInfo;
    protected long totalCapacity;
    protected long persistentCapacity;
    protected long availablePersistentCapacity;
    protected long volatileCapacity;
    protected long availableVolatileCapacity;
    protected long blockCapacity;
    protected List<NvdimmRegionInfo> regionInfo;
    @XmlElement(required = true)
    protected String representationString;

    /**
     * Gets the value of the dimmHandle property.
     * 
     */
    public int getDimmHandle() {
        return dimmHandle;
    }

    /**
     * Sets the value of the dimmHandle property.
     * 
     */
    public void setDimmHandle(int value) {
        this.dimmHandle = value;
    }

    /**
     * Gets the value of the healthInfo property.
     * 
     * @return
     *     possible object is
     *     {@link NvdimmHealthInfo }
     *     
     */
    public NvdimmHealthInfo getHealthInfo() {
        return healthInfo;
    }

    /**
     * Sets the value of the healthInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link NvdimmHealthInfo }
     *     
     */
    public void setHealthInfo(NvdimmHealthInfo value) {
        this.healthInfo = value;
    }

    /**
     * Gets the value of the totalCapacity property.
     * 
     */
    public long getTotalCapacity() {
        return totalCapacity;
    }

    /**
     * Sets the value of the totalCapacity property.
     * 
     */
    public void setTotalCapacity(long value) {
        this.totalCapacity = value;
    }

    /**
     * Gets the value of the persistentCapacity property.
     * 
     */
    public long getPersistentCapacity() {
        return persistentCapacity;
    }

    /**
     * Sets the value of the persistentCapacity property.
     * 
     */
    public void setPersistentCapacity(long value) {
        this.persistentCapacity = value;
    }

    /**
     * Gets the value of the availablePersistentCapacity property.
     * 
     */
    public long getAvailablePersistentCapacity() {
        return availablePersistentCapacity;
    }

    /**
     * Sets the value of the availablePersistentCapacity property.
     * 
     */
    public void setAvailablePersistentCapacity(long value) {
        this.availablePersistentCapacity = value;
    }

    /**
     * Gets the value of the volatileCapacity property.
     * 
     */
    public long getVolatileCapacity() {
        return volatileCapacity;
    }

    /**
     * Sets the value of the volatileCapacity property.
     * 
     */
    public void setVolatileCapacity(long value) {
        this.volatileCapacity = value;
    }

    /**
     * Gets the value of the availableVolatileCapacity property.
     * 
     */
    public long getAvailableVolatileCapacity() {
        return availableVolatileCapacity;
    }

    /**
     * Sets the value of the availableVolatileCapacity property.
     * 
     */
    public void setAvailableVolatileCapacity(long value) {
        this.availableVolatileCapacity = value;
    }

    /**
     * Gets the value of the blockCapacity property.
     * 
     */
    public long getBlockCapacity() {
        return blockCapacity;
    }

    /**
     * Sets the value of the blockCapacity property.
     * 
     */
    public void setBlockCapacity(long value) {
        this.blockCapacity = value;
    }

    /**
     * Gets the value of the regionInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NvdimmRegionInfo }
     * 
     * 
     */
    public List<NvdimmRegionInfo> getRegionInfo() {
        if (regionInfo == null) {
            regionInfo = new ArrayList<NvdimmRegionInfo>();
        }
        return this.regionInfo;
    }

    /**
     * Gets the value of the representationString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepresentationString() {
        return representationString;
    }

    /**
     * Sets the value of the representationString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepresentationString(String value) {
        this.representationString = value;
    }

}
