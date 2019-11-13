
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostMonitoringStateChangedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostMonitoringStateChangedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterEvent">
 *       &lt;sequence>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prevState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostMonitoringStateChangedEvent", propOrder = {
    "state",
    "prevState"
})
public class HostMonitoringStateChangedEvent
    extends ClusterEvent
{

    @XmlElement(required = true)
    protected String state;
    protected String prevState;

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

    /**
     * Gets the value of the prevState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevState() {
        return prevState;
    }

    /**
     * Sets the value of the prevState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevState(String value) {
        this.prevState = value;
    }

}
