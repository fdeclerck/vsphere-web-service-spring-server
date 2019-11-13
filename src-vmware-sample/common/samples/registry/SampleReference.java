// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.registry;

import com.vmware.common.samples.parameters.Parameters;
import java.lang.reflect.InvocationTargetException;
import com.vmware.common.samples.parameters.SampleParameters;
import com.vmware.common.samples.parameters.OptionReference;
import java.util.Set;
import com.vmware.common.samples.SystemParameters;
import com.vmware.common.samples.parameters.Options;

public class SampleReference implements Comparable<SampleReference>
{
    private final String name;
    private final String description;
    private final Class<?> sample;
    private final ActionReference action;
    private final Options options;
    private final SystemParameters systemParameters;
    
    public SampleReference(final SystemParameters systemParameters, final String name, final String description, final Class<?> sample, final ActionReference action, final Options options) {
        this.systemParameters = systemParameters;
        this.name = name;
        this.description = description;
        this.sample = sample;
        this.action = action;
        this.options = options;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getPackage() {
        return this.sample.getPackage().getName();
    }
    
    public Set<OptionReference> listOptions() {
        return this.options.list;
    }
    
    public SampleExecutionRecord run(final String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        final SampleParameters parameters = this.parse(args, this.systemParameters);
        Object pojo = this.sample.newInstance();
        pojo = parameters.inject(pojo);
        return this.run(pojo);
    }
    
    public SampleExecutionRecord run(final Object pojo) {
        return this.action.action(pojo);
    }
    
    private SampleParameters parse(final String[] args, final SystemParameters systemParameters) {
        return Parameters.build(this.sample, this.options, args, systemParameters);
    }
    
    @Override
    public int compareTo(final SampleReference sampleReference) {
        return this.sample.getCanonicalName().compareTo(sampleReference.sample.getCanonicalName());
    }
}
