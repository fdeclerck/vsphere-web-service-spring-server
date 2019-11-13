// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.registry;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActionReference
{
    private final Method before;
    private final Method action;
    private final Method after;
    
    public ActionReference(final Method before, final Method action, final Method after) {
        this.before = before;
        this.action = action;
        this.after = after;
    }
    
    public SampleExecutionRecord action(final Object sample) {
        final SampleExecutionRecord record = new SampleExecutionRecord(sample);
        synchronized (sample) {
            try {
                record.before = this.invokeAction(this.before, sample);
                if (record.before.isGood()) {
                    record.action = this.invokeAction(this.action, sample);
                }
                record.after = this.invokeAction(this.after, sample);
            }
            finally {
                record.hasRun();
            }
        }
        return record;
    }
    
    public SampleExecutionRecord.InvocationRecord invokeAction(final Method method, final Object sample) {
        final SampleExecutionRecord.InvocationRecord record = new SampleExecutionRecord.InvocationRecord();
        try {
            if (method != null) {
                record.output = this.invoke(method, sample);
            }
        }
        catch (InvocationTargetException e) {
            record.fault = e.getCause();
        }
        catch (IllegalAccessException e2) {
            record.fault = e2;
        }
        return record;
    }
    
    private Object invoke(final Method method, final Object sample) throws InvocationTargetException, IllegalAccessException {
        return (method != null && sample != null) ? method.invoke(sample, new Object[0]) : null;
    }
}
