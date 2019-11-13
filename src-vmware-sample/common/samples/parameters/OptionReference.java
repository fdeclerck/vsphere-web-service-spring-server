// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.parameters;

import java.lang.reflect.Method;

public class OptionReference
{
    public static final String OPTION_SWITCH = "--";
    public final String name;
    public final String systemProperty;
    public final boolean required;
    public final boolean parameter;
    public final String description;
    public final Method method;
    
    public OptionReference(final String name, final String systemProperty, final boolean required, final boolean parameter, final String description, final Method method) {
        this.name = name.toLowerCase();
        this.required = required;
        this.parameter = parameter;
        this.description = description;
        this.method = method;
        this.systemProperty = systemProperty;
    }
    
    public OptionReference(final String name, final boolean required, final boolean parameter, final String description, final Method method) {
        this.name = name.toLowerCase();
        this.required = required;
        this.parameter = parameter;
        this.description = description;
        this.method = method;
        this.systemProperty = null;
    }
    
    public boolean match(final String argument) {
        return new String("--" + this.name.toString()).equalsIgnoreCase(argument);
    }
    
    @Override
    public String toString() {
        return "--" + this.name.toString().toLowerCase();
    }
}
