
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NvdimmNamespaceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NvdimmNamespaceInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="friendlyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="blockSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="blockCount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="namespaceHealthStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="locationID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NvdimmNamespaceInfo", propOrder = {
    "uuid",
    "friendlyName",
    "blockSize",
    "blockCount",
    "type",
    "namespaceHealthStatus",
    "locationID",
    "state"
})
public class NvdimmNamespaceInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String uuid;
    @XmlElement(required = true)
    protected String friendlyName;
    protected long blockSize;
    protected long blockCount;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String namespaceHealthStatus;
    protected int locationID;
    @XmlElement(required = true)
    protected String state;

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the friendlyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Sets the value of the friendlyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFriendlyName(String value) {
        this.friendlyName = value;
    }

    /**
     * Gets the value of the blockSize property.
     * 
     */
    public long getBlockSize() {
        return blockSize;
    }

    /**
     * Sets the value of the blockSize property.
     * 
     */
    public void setBlockSize(long value) {
        this.blockSize = value;
    }

    /**
     * Gets the value of the blockCount property.
     * 
     */
    public long getBlockCount() {
        return blockCount;
    }

    /**
     * Sets the value of the blockCount property.
     * 
     */
    public void setBlockCount(long value) {
        this.blockCount = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the namespaceHealthStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamespaceHealthStatus() {
        return namespaceHealthStatus;
    }

    /**
     * Sets the value of the namespaceHealthStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamespaceHealthStatus(String value) {
        this.namespaceHealthStatus = value;
    }

    /**
     * Gets the value of the locationID property.
     * 
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * Sets the value of the locationID property.
     * 
     */
    public void setLocationID(int value) {
        this.locationID = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

}
