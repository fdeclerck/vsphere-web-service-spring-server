// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import com.vmware.common.samples.registry.SampleRegistryException;

public class SampleAnnotationException extends SampleRegistryException
{
    private static final long serialVersionUID = -5982607354573526023L;
    
    public SampleAnnotationException(final Class<?> clazz, final Method method, final Class<? extends Annotation> annotation) {
        super(clazz.getCanonicalName() + "." + method.getName() + " was annotated with " + annotation.getSimpleName() + " but was not public!");
    }
    
    public SampleAnnotationException(final Throwable throwable) {
        super(throwable);
    }
    
    public SampleAnnotationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
