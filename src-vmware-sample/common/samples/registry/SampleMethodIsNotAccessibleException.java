// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.registry;

import java.lang.reflect.Method;

public class SampleMethodIsNotAccessibleException extends SampleRegistryException
{
    public SampleMethodIsNotAccessibleException(final Object sample, final Method before, final Method action, final Throwable cause) {
        super(message(sample, before, action), cause);
    }
    
    private static String message(final Object sample, final Method before, final Method action) {
        final String beforeName = (before != null) ? before.getName() : "[none]";
        final String actionName = (action != null) ? action.getName() : "[none]";
        final String name = (sample != null) ? sample.getClass().getCanonicalName() : "[none]";
        return String.format("The sample %s has an annotated method that is not public. Before %s and Action %s ", name, beforeName, actionName);
    }
    
    public SampleMethodIsNotAccessibleException(final Object sample, final Method after, final Throwable cause) {
        super(message(sample, after), cause);
    }
    
    private static String message(final Object sample, final Method method) {
        final String methodName = (method != null) ? method.getName() : "[none]";
        final String name = (sample != null) ? sample.getClass().getCanonicalName() : "[none]";
        return String.format("The sample %s has an annotated method that is not public. Check the method %s.", name, methodName);
    }
}
