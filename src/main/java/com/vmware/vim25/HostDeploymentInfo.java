
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDeploymentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDeploymentInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="bootedFromStatelessCache" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDeploymentInfo", propOrder = {
    "bootedFromStatelessCache"
})
public class HostDeploymentInfo
    extends DynamicData
{

    protected Boolean bootedFromStatelessCache;

    /**
     * Gets the value of the bootedFromStatelessCache property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBootedFromStatelessCache() {
        return bootedFromStatelessCache;
    }

    /**
     * Sets the value of the bootedFromStatelessCache property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBootedFromStatelessCache(Boolean value) {
        this.bootedFromStatelessCache = value;
    }

}
