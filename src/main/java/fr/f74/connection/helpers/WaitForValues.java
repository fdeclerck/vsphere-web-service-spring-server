/*
 * *****************************************************
 * Copyright VMware, Inc. 2010-2012.  All Rights Reserved.
 * *****************************************************
 *
 * DISCLAIMER. THIS PROGRAM IS PROVIDED TO YOU "AS IS" WITHOUT
 * WARRANTIES OR CONDITIONS # OF ANY KIND, WHETHER ORAL OR WRITTEN,
 * EXPRESS OR IMPLIED. THE AUTHOR SPECIFICALLY # DISCLAIMS ANY IMPLIED
 * WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY # QUALITY,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE.
 */

package fr.f74.connection.helpers;

import fr.f74.connection.Connection;
import com.vmware.vim25.*;
import org.w3c.dom.Element;

import java.util.Arrays;
import java.util.List;

public class WaitForValues extends BaseHelper {
    public WaitForValues(final Connection connection) {
        super(connection);
    }

    /**
     * Handle Updates for a single object. waits till expected values of
     * properties to check are reached Destroys the ObjectFilter when done.
     *
     * @param objmor       MOR of the Object to wait for
     * @param filterProps  Properties list to filter
     * @param endWaitProps Properties list to check for expected values these be properties
     *                     of a property in the filter properties list
     * @param expectedVals values for properties to end the wait
     * @return true indicating expected values were met, and false otherwise
     * @throws RuntimeFaultFaultMsg
     * @throws InvalidPropertyFaultMsg
     * @throws InvalidCollectorVersionFaultMsg
     *
     */
    public Object[] wait(ManagedObjectReference objmor,
                         String[] filterProps, String[] endWaitProps, Object[][] expectedVals)
            throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg,
            InvalidCollectorVersionFaultMsg {
        VimPortType vimPort;
        ManagedObjectReference filterSpecRef = null;
        ServiceContent serviceContent;

        try {
            vimPort = connection.connect().getVimPort();
            serviceContent = connection.connect().getServiceContent();
        } catch (Throwable cause) {
            throw new BaseHelper.HelperException(cause);
        }

        // version string is initially null
        String version = "";
        Object[] endVals = new Object[endWaitProps.length];
        Object[] filterVals = new Object[filterProps.length];
        String stateVal = null;

        PropertyFilterSpec spec = propertyFilterSpec(objmor, filterProps);

        filterSpecRef =
                vimPort.createFilter(serviceContent.getPropertyCollector(), spec,
                        true);

        boolean reached = false;

        UpdateSet updateset = null;
        List<PropertyFilterUpdate> filtupary = null;
        List<ObjectUpdate> objupary = null;
        List<PropertyChange> propchgary = null;
        while (!reached) {
            updateset =
                    vimPort.waitForUpdatesEx(serviceContent.getPropertyCollector(),
                            version, new WaitOptions());
            if (updateset == null || updateset.getFilterSet() == null) {
                continue;
            }
            version = updateset.getVersion();

            // Make this code more general purpose when PropCol changes later.
            filtupary = updateset.getFilterSet();

            for (PropertyFilterUpdate filtup : filtupary) {
                objupary = filtup.getObjectSet();
                for (ObjectUpdate objup : objupary) {
                    // TODO: Handle all "kind"s of updates.
                    if (objup.getKind() == ObjectUpdateKind.MODIFY
                            || objup.getKind() == ObjectUpdateKind.ENTER
                            || objup.getKind() == ObjectUpdateKind.LEAVE) {
                        propchgary = objup.getChangeSet();
                        for (PropertyChange propchg : propchgary) {
                            updateValues(endWaitProps, endVals, propchg);
                            updateValues(filterProps, filterVals, propchg);
                        }
                    }
                }
            }

            Object expctdval = null;
            // Check if the expected values have been reached and exit the loop
            // if done.
            // Also exit the WaitForUpdates loop if this is the case.
            for (int chgi = 0; chgi < endVals.length && !reached; chgi++) {
                for (int vali = 0; vali < expectedVals[chgi].length && !reached; vali++) {
                    expctdval = expectedVals[chgi][vali];
                    if (endVals[chgi] == null) {
                        // Do Nothing
                    } else if (endVals[chgi].toString().contains("val: null")) {
                        // Due to some issue in JAX-WS De-serialization getting the information from
                        // the nodes
                        Element stateElement = (Element) endVals[chgi];
                        if (stateElement != null && stateElement.getFirstChild() != null) {
                            stateVal = stateElement.getFirstChild().getTextContent();
                            reached = expctdval.toString().equalsIgnoreCase(stateVal) || reached;
                        }
                    } else {
                        expctdval = expectedVals[chgi][vali];
                        reached = expctdval.equals(endVals[chgi]) || reached;
                        stateVal = "filtervals";
                }
            }
        }
        }
            Object[] retVal = null;
            // Destroy the filter when we are done.
            try {
                vimPort.destroyPropertyFilter(filterSpecRef);
            } catch (RuntimeFaultFaultMsg e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (stateVal != null) {
                if (stateVal.equalsIgnoreCase("ready")) {
                    retVal = new Object[] { HttpNfcLeaseState.READY };
                }
                if (stateVal.equalsIgnoreCase("error")) {
                    retVal = new Object[] { HttpNfcLeaseState.ERROR };
                }
                if (stateVal.equals("filtervals")) {
                    retVal = filterVals;
                }
            } else {
                retVal = new Object[] { HttpNfcLeaseState.ERROR };
            }
            return retVal;
        }

    public PropertyFilterSpec propertyFilterSpec(ManagedObjectReference objmor, String[] filterProps) {
        PropertyFilterSpec spec = new PropertyFilterSpec();
        ObjectSpec oSpec = new ObjectSpec();
        oSpec.setObj(objmor);
        oSpec.setSkip(Boolean.FALSE);
        spec.getObjectSet().add(oSpec);

        PropertySpec pSpec = new PropertySpec();
        pSpec.getPathSet().addAll(Arrays.asList(filterProps));
        pSpec.setType(objmor.getType());
        spec.getPropSet().add(pSpec);
        return spec;
    }

    void updateValues(String[] props, Object[] vals, PropertyChange propchg) {
        for (int findi = 0; findi < props.length; findi++) {
            if (propchg.getName().lastIndexOf(props[findi]) >= 0) {
                if (propchg.getOp() == PropertyChangeOp.REMOVE) {
                    vals[findi] = "";
                } else {
                    vals[findi] = propchg.getVal();
                }
            }
        }
    }
}
