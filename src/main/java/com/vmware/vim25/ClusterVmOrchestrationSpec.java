
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterVmOrchestrationSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterVmOrchestrationSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ArrayUpdateSpec">
 *       &lt;sequence>
 *         &lt;element name="info" type="{urn:vim25}ClusterVmOrchestrationInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterVmOrchestrationSpec", propOrder = {
    "info"
})
public class ClusterVmOrchestrationSpec
    extends ArrayUpdateSpec
{

    protected ClusterVmOrchestrationInfo info;

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterVmOrchestrationInfo }
     *     
     */
    public ClusterVmOrchestrationInfo getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterVmOrchestrationInfo }
     *     
     */
    public void setInfo(ClusterVmOrchestrationInfo value) {
        this.info = value;
    }

}
