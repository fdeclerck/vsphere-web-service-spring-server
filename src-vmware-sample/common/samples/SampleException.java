// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples;

public class SampleException extends RuntimeException
{
    private static final long serialVersionUID = 4871074456189936655L;
    
    public SampleException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    public SampleException(final Throwable cause) {
        super(cause);
    }
    
    public SampleException(final String message) {
        super(message);
    }
}
