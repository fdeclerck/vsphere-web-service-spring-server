// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.parameters;

import com.vmware.common.samples.registry.SampleRegistryException;

public class MissingSystemPropertyException extends SampleRegistryException
{
    public MissingSystemPropertyException(final String property, final String description) {
        super(String.format("The system property %s must be set.%n%s%n", property, description));
    }
}
