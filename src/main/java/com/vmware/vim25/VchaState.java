
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VchaState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VchaState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="configured"/>
 *     &lt;enumeration value="notConfigured"/>
 *     &lt;enumeration value="invalid"/>
 *     &lt;enumeration value="prepared"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VchaState")
@XmlEnum
public enum VchaState {

    @XmlEnumValue("configured")
    CONFIGURED("configured"),
    @XmlEnumValue("notConfigured")
    NOT_CONFIGURED("notConfigured"),
    @XmlEnumValue("invalid")
    INVALID("invalid"),
    @XmlEnumValue("prepared")
    PREPARED("prepared");
    private final String value;

    VchaState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VchaState fromValue(String v) {
        for (VchaState c: VchaState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
