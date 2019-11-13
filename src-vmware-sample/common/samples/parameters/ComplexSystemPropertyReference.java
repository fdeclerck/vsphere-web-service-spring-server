// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.parameters;

import java.lang.reflect.Method;

public class ComplexSystemPropertyReference extends SystemPropertyReference
{
    public final String field;
    public final Method setter;
    public final Class<?> type;
    
    public ComplexSystemPropertyReference(final String field, final String property, final String defaultValue, final String description, final Method method, final Method setter, final Class<?> type) {
        this(field, property, defaultValue, false, description, method, setter, type);
    }
    
    public ComplexSystemPropertyReference(final String field, final String property, final String defaultValue, final Boolean required, final String description, final Method method, final Method setter, final Class<?> type) {
        super(property, defaultValue, required, description, method);
        this.field = field;
        this.setter = setter;
        this.type = type;
    }
}
