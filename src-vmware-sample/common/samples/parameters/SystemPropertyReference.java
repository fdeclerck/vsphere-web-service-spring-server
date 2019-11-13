// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.parameters;

import java.lang.reflect.Method;

public class SystemPropertyReference
{
    final String property;
    final String defaultValue;
    final Boolean required;
    final String description;
    final Method method;
    
    public SystemPropertyReference(final String property, final String defaultValue, final String description, final Method method) {
        this(property, defaultValue, Boolean.FALSE, description, method);
    }
    
    public SystemPropertyReference(final String property, final String defaultValue, final Boolean required, final String description, final Method method) {
        this.property = property;
        this.defaultValue = defaultValue;
        this.required = required;
        this.description = description;
        this.method = method;
    }
    
    public String getProperty() {
        return this.property;
    }
    
    public String getDefaultValue() {
        return this.defaultValue;
    }
    
    public Boolean getRequired() {
        return this.required;
    }
    
    public String getDescription() {
        return this.description;
    }
}
