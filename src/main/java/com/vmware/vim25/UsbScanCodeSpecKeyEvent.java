
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UsbScanCodeSpecKeyEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsbScanCodeSpecKeyEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="usbHidCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modifiers" type="{urn:vim25}UsbScanCodeSpecModifierType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsbScanCodeSpecKeyEvent", propOrder = {
    "usbHidCode",
    "modifiers"
})
public class UsbScanCodeSpecKeyEvent
    extends DynamicData
{

    protected int usbHidCode;
    protected UsbScanCodeSpecModifierType modifiers;

    /**
     * Gets the value of the usbHidCode property.
     * 
     */
    public int getUsbHidCode() {
        return usbHidCode;
    }

    /**
     * Sets the value of the usbHidCode property.
     * 
     */
    public void setUsbHidCode(int value) {
        this.usbHidCode = value;
    }

    /**
     * Gets the value of the modifiers property.
     * 
     * @return
     *     possible object is
     *     {@link UsbScanCodeSpecModifierType }
     *     
     */
    public UsbScanCodeSpecModifierType getModifiers() {
        return modifiers;
    }

    /**
     * Sets the value of the modifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsbScanCodeSpecModifierType }
     *     
     */
    public void setModifiers(UsbScanCodeSpecModifierType value) {
        this.modifiers = value;
    }

}
