
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostProtocolEndpointProtocolEndpointType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostProtocolEndpointProtocolEndpointType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="scsi"/>
 *     &lt;enumeration value="nfs"/>
 *     &lt;enumeration value="nfs4x"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostProtocolEndpointProtocolEndpointType")
@XmlEnum
public enum HostProtocolEndpointProtocolEndpointType {

    @XmlEnumValue("scsi")
    SCSI("scsi"),
    @XmlEnumValue("nfs")
    NFS("nfs"),
    @XmlEnumValue("nfs4x")
    NFS_4_X("nfs4x");
    private final String value;

    HostProtocolEndpointProtocolEndpointType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostProtocolEndpointProtocolEndpointType fromValue(String v) {
        for (HostProtocolEndpointProtocolEndpointType c: HostProtocolEndpointProtocolEndpointType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
