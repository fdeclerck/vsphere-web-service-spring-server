// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.parameters;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Options
{
    public final Class<?> sample;
    public final Set<OptionReference> list;
    public final Set<SystemPropertyReference> systemProperties;
    
    public Options(final Class<?> sampleClass) {
        this.systemProperties = new LinkedHashSet<SystemPropertyReference>();
        this.list = new LinkedHashSet<OptionReference>();
        this.sample = sampleClass;
    }
    
    public int size() {
        return this.list.size();
    }
    
    public String usage() {
        return "Expected " + this.parameterList() + " arguments.";
    }
    
    public String parameterList() {
        final StringBuffer sb = new StringBuffer();
        for (final OptionReference param : this.list) {
            this.optionSwitch(sb, param);
            sb.append(" <");
            sb.append(param.toString());
            sb.append(">");
            sb.append(" ");
        }
        return sb.toString();
    }
    
    private void optionSwitch(final StringBuffer sb, final OptionReference param) {
        sb.append("--");
        sb.append(param.toString().toLowerCase());
    }
    
    public Options option(final String option, final boolean required, final boolean parameter, final String description, final Method method) {
        this.list.add(new OptionReference(option, required, parameter, description, method));
        return this;
    }
    
    public Options option(final String option, final String systemProperty, final boolean required, final boolean parameter, final String description, final Method method) {
        this.list.add(new OptionReference(option, systemProperty, required, parameter, description, method));
        return this;
    }
    
    public Options complex(final String option, final String property, final Class<?> type, final String systemProperty, final boolean required, final boolean parameter, final String description, final Method method, final Method submethod) {
        this.list.add(new ComplexOptionReference(option, property, type, systemProperty, required, parameter, description, method, submethod));
        return this;
    }
    
    public Options systemProperty(final String property, final String defaultValue, final boolean required, final String description, final Method method) {
        this.systemProperties.add(new SystemPropertyReference(property, defaultValue, required, description, method));
        return this;
    }
    
    public Options complexSystemProperties(final String field, final String property, final String defaultValue, final Boolean required, final String description, final Method method, final Method setter, final Class<?> type) {
        this.systemProperties.add(new ComplexSystemPropertyReference(field, property, defaultValue, required, description, method, setter, type));
        return this;
    }
    
    public Class<?> getSampleClass() {
        return this.sample;
    }
}
