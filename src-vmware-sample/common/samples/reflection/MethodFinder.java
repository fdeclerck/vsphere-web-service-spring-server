// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.reflection;

import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

public class MethodFinder
{
    public Method[] find(final Class<?> clazz, final Class<? extends Annotation> annotation) {
        final List<Method> methods = this.getMethods(clazz, annotation);
        return methods.toArray(new Method[methods.size()]);
    }
    
    private List<Method> getMethods(final Class<?> clazz, final Class<? extends Annotation> annotation) {
        final List<Method> methods = new LinkedList<Method>();
        if (clazz == null) {
            return methods;
        }
        if (!Object.class.equals(clazz) && clazz.getSuperclass() != null) {
            methods.addAll(this.getMethods(clazz.getSuperclass(), annotation));
        }
        for (final Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotation)) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    throw new SampleAnnotationException(clazz, method, annotation);
                }
                methods.add(method);
            }
        }
        return methods;
    }
}
