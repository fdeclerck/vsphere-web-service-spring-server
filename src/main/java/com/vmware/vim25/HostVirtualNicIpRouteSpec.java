
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostVirtualNicIpRouteSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostVirtualNicIpRouteSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="ipRouteConfig" type="{urn:vim25}HostIpRouteConfig" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostVirtualNicIpRouteSpec", propOrder = {
    "ipRouteConfig"
})
public class HostVirtualNicIpRouteSpec
    extends DynamicData
{

    protected HostIpRouteConfig ipRouteConfig;

    /**
     * Gets the value of the ipRouteConfig property.
     * 
     * @return
     *     possible object is
     *     {@link HostIpRouteConfig }
     *     
     */
    public HostIpRouteConfig getIpRouteConfig() {
        return ipRouteConfig;
    }

    /**
     * Sets the value of the ipRouteConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostIpRouteConfig }
     *     
     */
    public void setIpRouteConfig(HostIpRouteConfig value) {
        this.ipRouteConfig = value;
    }

}
