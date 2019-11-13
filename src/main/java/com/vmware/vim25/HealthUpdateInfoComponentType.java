
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HealthUpdateInfoComponentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HealthUpdateInfoComponentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Memory"/>
 *     &lt;enumeration value="Power"/>
 *     &lt;enumeration value="Fan"/>
 *     &lt;enumeration value="Network"/>
 *     &lt;enumeration value="Storage"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HealthUpdateInfoComponentType")
@XmlEnum
public enum HealthUpdateInfoComponentType {

    @XmlEnumValue("Memory")
    MEMORY("Memory"),
    @XmlEnumValue("Power")
    POWER("Power"),
    @XmlEnumValue("Fan")
    FAN("Fan"),
    @XmlEnumValue("Network")
    NETWORK("Network"),
    @XmlEnumValue("Storage")
    STORAGE("Storage");
    private final String value;

    HealthUpdateInfoComponentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HealthUpdateInfoComponentType fromValue(String v) {
        for (HealthUpdateInfoComponentType c: HealthUpdateInfoComponentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
