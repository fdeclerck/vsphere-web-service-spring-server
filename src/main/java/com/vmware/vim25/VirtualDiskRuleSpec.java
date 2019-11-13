
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDiskRuleSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDiskRuleSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterRuleInfo">
 *       &lt;sequence>
 *         &lt;element name="diskRuleType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="diskId" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDiskRuleSpec", propOrder = {
    "diskRuleType",
    "diskId"
})
public class VirtualDiskRuleSpec
    extends ClusterRuleInfo
{

    @XmlElement(required = true)
    protected String diskRuleType;
    @XmlElement(type = Integer.class)
    protected List<Integer> diskId;

    /**
     * Gets the value of the diskRuleType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiskRuleType() {
        return diskRuleType;
    }

    /**
     * Sets the value of the diskRuleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiskRuleType(String value) {
        this.diskRuleType = value;
    }

    /**
     * Gets the value of the diskId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diskId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiskId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getDiskId() {
        if (diskId == null) {
            diskId = new ArrayList<Integer>();
        }
        return this.diskId;
    }

}
