// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UnregisteredSampleHandler
{
    public static boolean isStandalone(final String name) {
        boolean found = false;
        try {
            final Method main = getMainMethod(name);
            found = (main != null);
        }
        catch (Throwable t) {
            found = false;
        }
        return found;
    }
    
    public static Method getMainMethod(final String className) throws ClassNotFoundException, NoSuchMethodException {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final Class<?> clazz = loader.loadClass(className);
        return clazz.getMethod("main", String[].class);
    }
    
    public static void handle(final String name, final Object args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method main = getMainMethod(name);
        main.invoke(null, args);
    }
}
