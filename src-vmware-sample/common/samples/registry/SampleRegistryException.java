// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.registry;

import com.vmware.common.samples.SampleException;

public class SampleRegistryException extends SampleException
{
    public SampleRegistryException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public SampleRegistryException(final Throwable cause) {
        super(cause);
    }
    
    public SampleRegistryException(final String message) {
        super(message);
    }
}
