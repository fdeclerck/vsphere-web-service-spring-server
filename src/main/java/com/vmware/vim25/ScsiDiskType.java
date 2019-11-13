
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScsiDiskType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ScsiDiskType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="native512"/>
 *     &lt;enumeration value="emulated512"/>
 *     &lt;enumeration value="native4k"/>
 *     &lt;enumeration value="SoftwareEmulated4k"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ScsiDiskType")
@XmlEnum
public enum ScsiDiskType {

    @XmlEnumValue("native512")
    NATIVE_512("native512"),
    @XmlEnumValue("emulated512")
    EMULATED_512("emulated512"),
    @XmlEnumValue("native4k")
    NATIVE_4_K("native4k"),
    @XmlEnumValue("SoftwareEmulated4k")
    SOFTWARE_EMULATED_4_K("SoftwareEmulated4k"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    ScsiDiskType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScsiDiskType fromValue(String v) {
        for (ScsiDiskType c: ScsiDiskType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
