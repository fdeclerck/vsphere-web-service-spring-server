
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseConfigInfoDiskFileBackingInfoProvisioningType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BaseConfigInfoDiskFileBackingInfoProvisioningType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="thin"/>
 *     &lt;enumeration value="eagerZeroedThick"/>
 *     &lt;enumeration value="lazyZeroedThick"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BaseConfigInfoDiskFileBackingInfoProvisioningType")
@XmlEnum
public enum BaseConfigInfoDiskFileBackingInfoProvisioningType {

    @XmlEnumValue("thin")
    THIN("thin"),
    @XmlEnumValue("eagerZeroedThick")
    EAGER_ZEROED_THICK("eagerZeroedThick"),
    @XmlEnumValue("lazyZeroedThick")
    LAZY_ZEROED_THICK("lazyZeroedThick");
    private final String value;

    BaseConfigInfoDiskFileBackingInfoProvisioningType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BaseConfigInfoDiskFileBackingInfoProvisioningType fromValue(String v) {
        for (BaseConfigInfoDiskFileBackingInfoProvisioningType c: BaseConfigInfoDiskFileBackingInfoProvisioningType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
