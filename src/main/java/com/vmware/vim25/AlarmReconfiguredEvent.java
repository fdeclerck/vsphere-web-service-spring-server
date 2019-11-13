
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlarmReconfiguredEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmReconfiguredEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}AlarmEvent">
 *       &lt;sequence>
 *         &lt;element name="entity" type="{urn:vim25}ManagedEntityEventArgument"/>
 *         &lt;element name="configChanges" type="{urn:vim25}ChangesInfoEventArgument" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmReconfiguredEvent", propOrder = {
    "entity",
    "configChanges"
})
public class AlarmReconfiguredEvent
    extends AlarmEvent
{

    @XmlElement(required = true)
    protected ManagedEntityEventArgument entity;
    protected ChangesInfoEventArgument configChanges;

    /**
     * Gets the value of the entity property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEntityEventArgument }
     *     
     */
    public ManagedEntityEventArgument getEntity() {
        return entity;
    }

    /**
     * Sets the value of the entity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEntityEventArgument }
     *     
     */
    public void setEntity(ManagedEntityEventArgument value) {
        this.entity = value;
    }

    /**
     * Gets the value of the configChanges property.
     * 
     * @return
     *     possible object is
     *     {@link ChangesInfoEventArgument }
     *     
     */
    public ChangesInfoEventArgument getConfigChanges() {
        return configChanges;
    }

    /**
     * Sets the value of the configChanges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangesInfoEventArgument }
     *     
     */
    public void setConfigChanges(ChangesInfoEventArgument value) {
        this.configChanges = value;
    }

}
