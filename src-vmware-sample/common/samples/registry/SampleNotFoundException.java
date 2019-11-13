// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.registry;

public class SampleNotFoundException extends SampleRegistryException
{
    private static final long serialVersionUID = 732020600082780541L;
    
    public SampleNotFoundException(final String message) {
        super(String.format("The sample '%s' was not found in the sample registry.", message));
    }
}
