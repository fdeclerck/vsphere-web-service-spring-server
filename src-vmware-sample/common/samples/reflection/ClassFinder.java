// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.reflection;

import java.lang.annotation.Annotation;
import java.util.Collection;

public interface ClassFinder
{
    Collection<String> getClassNames();
    
    Class<?>[] find(final Collection<String> p0, final Class<? extends Annotation> p1);
}
