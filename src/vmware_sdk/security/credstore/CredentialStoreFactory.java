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

package com.vmware.security.credstore;

import java.io.File;
import java.io.IOException;

/**
 * Factory class providing instances of a {linkplain CredentialStore credential
 * store}.
 * <p>
 * <p>
 * If the file backing a credential store does not already exist, it is created
 * on the first call to {@link CredentialStore#addPassword}. If the default file
 * is being used, its directory will also be created if necessary.
 * <p>
 * <p>
 * Each method of the returned credential store acquires a
 * <a href="http://java.sun.com/javase/6/docs/api/java/nio/channels/FileLock.html"> lock</a>
 * on the store for the duration of the method call, blocking if necessary to do
 * so. The implementation may time out (throwing {@code IOException}) if the
 * lock cannot be acquired within a reasonable amount of time, on the order of a
 * minute. Locks are acquired on behalf of the entire Java virtual machine, not
 * just the current thread.
 * <p>
 * <p>
 * The methods in this class may be invoked concurrently by multiple threads.
 */
public class CredentialStoreFactory {

    /**
     * Returns the default credential store.
     */
    public static CredentialStore getCredentialStore() throws IOException {
        return new CredentialStoreImpl();
    }

    /**
     * Returns a credential store given the file backing it.
     *
     * @param file the file to use, or {@code null} to use the default
     * @return the credential store for the specified file
     */
    public static CredentialStore getCredentialStore(File file)
            throws IOException {
        return new CredentialStoreImpl(file);
    }
}
