// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.registry;

public class SampleExecutionRecord
{
    public static final SampleExecutionRecord NULL_RECORD;
    final Object sample;
    InvocationRecord before;
    InvocationRecord action;
    InvocationRecord after;
    Boolean ran;
    
    public SampleExecutionRecord(final Object sample) {
        this.before = InvocationRecord.NULL_RECORD;
        this.action = InvocationRecord.NULL_RECORD;
        this.after = InvocationRecord.NULL_RECORD;
        this.ran = Boolean.FALSE;
        this.sample = sample;
    }
    
    public boolean isGood() {
        return this.ran && this.before.isGood() && this.action.isGood() && this.after.isGood();
    }
    
    public Object getSample() {
        return this.sample;
    }
    
    public InvocationRecord getBefore() {
        return this.before;
    }
    
    public InvocationRecord getAction() {
        return this.action;
    }
    
    public InvocationRecord getAfter() {
        return this.after;
    }
    
    SampleExecutionRecord hasRun() {
        this.ran = Boolean.TRUE;
        return this;
    }
    
    public boolean hasFault() {
        return this.ran && (this.before.hasFault() || this.action.hasFault() || this.after.hasFault());
    }
    
    public Throwable getFault() {
        Throwable fault = null;
        for (final InvocationRecord record : new InvocationRecord[] { this.before, this.action, this.after }) {
            fault = record.getFault();
            if (fault != null) {
                break;
            }
        }
        return fault;
    }
    
    static {
        NULL_RECORD = new SampleExecutionRecord(null);
    }
    
    public static class InvocationRecord
    {
        Object output;
        Throwable fault;
        public static final InvocationRecord NULL_RECORD;
        
        public Object getOutput() {
            return this.output;
        }
        
        public Throwable getFault() {
            return this.fault;
        }
        
        public boolean isGood() {
            return this.fault == null;
        }
        
        public boolean hasFault() {
            return this.fault != null;
        }
        
        static {
            NULL_RECORD = new InvocationRecord() {
                @Override
                public boolean isGood() {
                    return true;
                }
            };
        }
    }
}
