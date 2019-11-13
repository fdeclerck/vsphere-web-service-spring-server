
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVchaNodeRuntimeInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVchaNodeRuntimeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VchaNodeRuntimeInfo" type="{urn:vim25}VchaNodeRuntimeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVchaNodeRuntimeInfo", propOrder = {
    "vchaNodeRuntimeInfo"
})
public class ArrayOfVchaNodeRuntimeInfo {

    @XmlElement(name = "VchaNodeRuntimeInfo")
    protected List<VchaNodeRuntimeInfo> vchaNodeRuntimeInfo;

    /**
     * Gets the value of the vchaNodeRuntimeInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vchaNodeRuntimeInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVchaNodeRuntimeInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VchaNodeRuntimeInfo }
     * 
     * 
     */
    public List<VchaNodeRuntimeInfo> getVchaNodeRuntimeInfo() {
        if (vchaNodeRuntimeInfo == null) {
            vchaNodeRuntimeInfo = new ArrayList<VchaNodeRuntimeInfo>();
        }
        return this.vchaNodeRuntimeInfo;
    }

}
