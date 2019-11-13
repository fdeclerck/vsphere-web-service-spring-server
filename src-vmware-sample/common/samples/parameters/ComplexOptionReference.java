// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.parameters;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ComplexOptionReference extends OptionReference
{
    public final String property;
    public final Method setter;
    public final Class<?> type;
    
    public ComplexOptionReference(final String option, final String property, final Class<?> type, final String systemProperty, final boolean required, final boolean parameter, final String description, final Method method, final Method submethod) {
        super(option, systemProperty, required, parameter, description, method);
        this.property = property;
        this.setter = submethod;
        this.type = type;
    }
    
    static boolean hasDefaultConstructor(final Class<?> type) {
        boolean found = false;
        final Constructor[] arr$;
        final Constructor<?>[] constructors = (Constructor<?>[])(arr$ = type.getConstructors());
        for (final Constructor<?> cons : arr$) {
            found = (cons.getParameterTypes().length == 0);
            if (found) {
                break;
            }
        }
        return found;
    }
}
