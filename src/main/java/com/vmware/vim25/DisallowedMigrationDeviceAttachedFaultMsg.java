
package com.vmware.vim25;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DisallowedMigrationDeviceAttachedFault", targetNamespace = "urn:vim25")
public class DisallowedMigrationDeviceAttachedFaultMsg
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DisallowedMigrationDeviceAttached faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public DisallowedMigrationDeviceAttachedFaultMsg(String message, DisallowedMigrationDeviceAttached faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public DisallowedMigrationDeviceAttachedFaultMsg(String message, DisallowedMigrationDeviceAttached faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.vmware.vim25.DisallowedMigrationDeviceAttached
     */
    public DisallowedMigrationDeviceAttached getFaultInfo() {
        return faultInfo;
    }

}
