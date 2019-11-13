// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.parameters;

import java.text.MessageFormat;
import com.vmware.common.samples.registry.SampleRegistryException;

public class IllegalOptionException extends SampleRegistryException
{
    private static final long serialVersionUID = 1L;
    
    public IllegalOptionException(final ComplexOptionReference ref) {
        super(MessageFormat.format("The class {0} method {1}, takes {2} which has no default constructor! ", ref.setter.getDeclaringClass(), ref.setter.getName(), ref.type));
    }
}
