/*
 * ******************************************************
 * Copyright VMware, Inc. 2010-2012.  All Rights Reserved.
 * ******************************************************
 *
 * DISCLAIMER. THIS PROGRAM IS PROVIDED TO YOU "AS IS" WITHOUT
 * WARRANTIES OR CONDITIONS # OF ANY KIND, WHETHER ORAL OR WRITTEN,
 * EXPRESS OR IMPLIED. THE AUTHOR SPECIFICALLY # DISCLAIMS ANY IMPLIED
 * WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY # QUALITY,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE.
 */

package com.vmware.general;

import com.vmware.common.annotations.Action;
import com.vmware.common.annotations.Option;
import com.vmware.common.annotations.Sample;
import com.vmware.connection.ConnectedVimServiceBase;
import com.vmware.vim25.*;

import java.rmi.RemoteException;
import java.util.*;


/**
 * <pre>
 * Delete
 *
 * This sample deletes the specified managed entity from the inventory tree
 * The managed entity can be a virtual machine, ClusterComputeResource or a Folder
 *
 * <b>Parameters</b>
 * url          [required] : url of the web service
 * username     [required] : username for the authentication
 * password     [required] : password for the authentication
 * entityname   [required] : Virtual Machine|ClusterComputeResource|Folder
 *
 * <b>Command Line:</b>
 * To delete a folder named 'testFolder'
 * run.bat com.vmware.general.Delete --url [webserviceurl]
 * --username [username] --password [password] --entityname [testFolder]
 *
 * To delete a datacenter named myData
 * run.bat com.vmware.general.Delete --url [webserviceurl]
 * --username [username] --password [password] --entityname [myData]
 * </pre>
 */
@Sample(
        name = "delete",
        description = "This sample deletes the specified managed entity from the inventory tree " +
                "The managed entity can be a virtual machine, ClusterComputeResource or a Folder."
)
public class Delete extends ConnectedVimServiceBase {
    private String managedEntityName;

    @Option(name = "entityname", description = "name of entity to delete")
    public void setManagedEntityName(String name) {
        this.managedEntityName = name;
    }

    /**
     * This method returns a boolean value specifying whether the Task is
     * succeeded or failed.
     *
     * @param task ManagedObjectReference representing the Task.
     * @return boolean value representing the Task result.
     * @throws InvalidCollectorVersionFaultMsg
     *
     * @throws RuntimeFaultFaultMsg
     * @throws InvalidPropertyFaultMsg
     */
    boolean getTaskResultAfterDone(ManagedObjectReference task)
            throws InvalidPropertyFaultMsg, RuntimeFaultFaultMsg,
            InvalidCollectorVersionFaultMsg {

        boolean retVal = false;

        // info has a property - state for state of the task
        Object[] result =
                waitForValues.wait(task, new String[]{"info.state", "info.error"},
                        new String[]{"state"}, new Object[][]{new Object[]{
                        TaskInfoState.SUCCESS, TaskInfoState.ERROR}});

        if (result[0].equals(TaskInfoState.SUCCESS)) {
            retVal = true;
        }
        if (result[1] instanceof LocalizedMethodFault) {
            throw new RuntimeException(
                    ((LocalizedMethodFault) result[1]).getLocalizedMessage());
        }
        return retVal;
    }

    @Action
    public void deleteManagedEntity() throws RuntimeFaultFaultMsg,
            RemoteException, InvalidPropertyFaultMsg, VimFaultFaultMsg, InvalidCollectorVersionFaultMsg {

        Map<String, ManagedObjectReference> entities = getMOREFs.inContainerByType(serviceContent
                .getRootFolder(), "ManagedEntity");

        ManagedObjectReference manobjref = entities.get(managedEntityName);
        if (manobjref == null) {
            System.out.printf(" Unable to find a Managed Entity By name [ %s ]",
                    managedEntityName);
            return;
        } else {
            ManagedObjectReference taskmor = vimPort.destroyTask(manobjref);
            if (getTaskResultAfterDone(taskmor)) {
                System.out.printf(
                        "Successful delete of Managed Entity Name - [ %s ]"
                                + " and Entity Type - [ %s ]%n", managedEntityName,
                        manobjref.getType());
            }
        }
    }
}