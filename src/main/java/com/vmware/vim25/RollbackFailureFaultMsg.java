
package com.vmware.vim25;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "RollbackFailureFault", targetNamespace = "urn:vim25")
public class RollbackFailureFaultMsg
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private RollbackFailure faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public RollbackFailureFaultMsg(String message, RollbackFailure faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public RollbackFailureFaultMsg(String message, RollbackFailure faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.vmware.vim25.RollbackFailure
     */
    public RollbackFailure getFaultInfo() {
        return faultInfo;
    }

}
