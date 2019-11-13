// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.parameters;

import java.lang.reflect.InvocationTargetException;
import com.vmware.common.samples.SystemParameters;

public interface SampleParameters
{
    Class<?> getSampleClass();
    
    String get(final String p0);
    
    SampleParameters parse(final String[] p0, final SystemParameters p1) throws IllegalArgumentException;
    
    Object inject(final Object p0) throws InvocationTargetException, IllegalAccessException, InstantiationException;
}
