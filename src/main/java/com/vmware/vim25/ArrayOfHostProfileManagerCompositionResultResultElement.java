
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostProfileManagerCompositionResultResultElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostProfileManagerCompositionResultResultElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostProfileManagerCompositionResultResultElement" type="{urn:vim25}HostProfileManagerCompositionResultResultElement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostProfileManagerCompositionResultResultElement", propOrder = {
    "hostProfileManagerCompositionResultResultElement"
})
public class ArrayOfHostProfileManagerCompositionResultResultElement {

    @XmlElement(name = "HostProfileManagerCompositionResultResultElement")
    protected List<HostProfileManagerCompositionResultResultElement> hostProfileManagerCompositionResultResultElement;

    /**
     * Gets the value of the hostProfileManagerCompositionResultResultElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostProfileManagerCompositionResultResultElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostProfileManagerCompositionResultResultElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostProfileManagerCompositionResultResultElement }
     * 
     * 
     */
    public List<HostProfileManagerCompositionResultResultElement> getHostProfileManagerCompositionResultResultElement() {
        if (hostProfileManagerCompositionResultResultElement == null) {
            hostProfileManagerCompositionResultResultElement = new ArrayList<HostProfileManagerCompositionResultResultElement>();
        }
        return this.hostProfileManagerCompositionResultResultElement;
    }

}
