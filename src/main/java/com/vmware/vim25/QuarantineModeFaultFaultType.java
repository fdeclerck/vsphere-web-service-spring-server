
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QuarantineModeFaultFaultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="QuarantineModeFaultFaultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoCompatibleNonQuarantinedHost"/>
 *     &lt;enumeration value="CorrectionDisallowed"/>
 *     &lt;enumeration value="CorrectionImpact"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "QuarantineModeFaultFaultType")
@XmlEnum
public enum QuarantineModeFaultFaultType {

    @XmlEnumValue("NoCompatibleNonQuarantinedHost")
    NO_COMPATIBLE_NON_QUARANTINED_HOST("NoCompatibleNonQuarantinedHost"),
    @XmlEnumValue("CorrectionDisallowed")
    CORRECTION_DISALLOWED("CorrectionDisallowed"),
    @XmlEnumValue("CorrectionImpact")
    CORRECTION_IMPACT("CorrectionImpact");
    private final String value;

    QuarantineModeFaultFaultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QuarantineModeFaultFaultType fromValue(String v) {
        for (QuarantineModeFaultFaultType c: QuarantineModeFaultFaultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
