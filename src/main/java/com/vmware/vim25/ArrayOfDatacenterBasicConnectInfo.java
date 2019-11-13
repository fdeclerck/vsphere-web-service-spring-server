
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDatacenterBasicConnectInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDatacenterBasicConnectInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatacenterBasicConnectInfo" type="{urn:vim25}DatacenterBasicConnectInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDatacenterBasicConnectInfo", propOrder = {
    "datacenterBasicConnectInfo"
})
public class ArrayOfDatacenterBasicConnectInfo {

    @XmlElement(name = "DatacenterBasicConnectInfo")
    protected List<DatacenterBasicConnectInfo> datacenterBasicConnectInfo;

    /**
     * Gets the value of the datacenterBasicConnectInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datacenterBasicConnectInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatacenterBasicConnectInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatacenterBasicConnectInfo }
     * 
     * 
     */
    public List<DatacenterBasicConnectInfo> getDatacenterBasicConnectInfo() {
        if (datacenterBasicConnectInfo == null) {
            datacenterBasicConnectInfo = new ArrayList<DatacenterBasicConnectInfo>();
        }
        return this.datacenterBasicConnectInfo;
    }

}
