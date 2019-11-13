
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BatchAddHostsToClusterRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchAddHostsToClusterRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="cluster" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="newHosts" type="{urn:vim25}FolderNewHostSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="existingHosts" type="{urn:vim25}ManagedObjectReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="compResSpec" type="{urn:vim25}ComputeResourceConfigSpec" minOccurs="0"/>
 *         &lt;element name="desiredState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchAddHostsToClusterRequestType", propOrder = {
    "_this",
    "cluster",
    "newHosts",
    "existingHosts",
    "compResSpec",
    "desiredState"
})
public class BatchAddHostsToClusterRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected ManagedObjectReference cluster;
    protected List<FolderNewHostSpec> newHosts;
    protected List<ManagedObjectReference> existingHosts;
    protected ComputeResourceConfigSpec compResSpec;
    protected String desiredState;

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
     * Gets the value of the cluster property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getCluster() {
        return cluster;
    }

    /**
     * Sets the value of the cluster property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setCluster(ManagedObjectReference value) {
        this.cluster = value;
    }

    /**
     * Gets the value of the newHosts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the newHosts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNewHosts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FolderNewHostSpec }
     * 
     * 
     */
    public List<FolderNewHostSpec> getNewHosts() {
        if (newHosts == null) {
            newHosts = new ArrayList<FolderNewHostSpec>();
        }
        return this.newHosts;
    }

    /**
     * Gets the value of the existingHosts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the existingHosts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExistingHosts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManagedObjectReference }
     * 
     * 
     */
    public List<ManagedObjectReference> getExistingHosts() {
        if (existingHosts == null) {
            existingHosts = new ArrayList<ManagedObjectReference>();
        }
        return this.existingHosts;
    }

    /**
     * Gets the value of the compResSpec property.
     * 
     * @return
     *     possible object is
     *     {@link ComputeResourceConfigSpec }
     *     
     */
    public ComputeResourceConfigSpec getCompResSpec() {
        return compResSpec;
    }

    /**
     * Sets the value of the compResSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComputeResourceConfigSpec }
     *     
     */
    public void setCompResSpec(ComputeResourceConfigSpec value) {
        this.compResSpec = value;
    }

    /**
     * Gets the value of the desiredState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesiredState() {
        return desiredState;
    }

    /**
     * Sets the value of the desiredState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesiredState(String value) {
        this.desiredState = value;
    }

}
