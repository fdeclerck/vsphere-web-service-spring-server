// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.reflection;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.net.URL;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.net.URLClassLoader;

public class SmartClassFinder implements ClassFinder
{
    public static final String JAR_URL_SUFFIX = ".jar";
    public static final String CLASS_FILE_SUFFIX = ".class";
    URLClassLoader urlClassLoader;
    final ClassScanner jar;
    final ClassScanner dir;
    final String rootPackage;
    
    public SmartClassFinder(final String rootPackage) {
        this((URLClassLoader)Thread.currentThread().getContextClassLoader(), rootPackage);
    }
    
    public SmartClassFinder(final URLClassLoader classLoader, final String rootPackage) {
        this.urlClassLoader = classLoader;
        this.jar = new JarFileClassScanner(".class");
        this.dir = new DirectoryClassScanner(".class");
        this.rootPackage = ((rootPackage != null) ? rootPackage : "");
    }
    
    @Override
    public Collection<String> getClassNames() {
        final Set<String> classNames = new HashSet<String>();
        final URL[] arr$;
        final URL[] urls = arr$ = this.urlClassLoader.getURLs();
        for (final URL url : arr$) {
            if (url.toString().endsWith(".jar")) {
                classNames.addAll(this.jar.scan(url));
            }
            else if (DirectoryClassScanner.file(url).isDirectory()) {
                classNames.addAll(this.dir.scan(url));
            }
        }
        return this.filter(classNames);
    }
    
    public Collection<String> filter(final Set<String> classNames) {
        if ("".equals(this.rootPackage)) {
            return classNames;
        }
        final Set<String> out = new HashSet<String>();
        for (final String name : classNames) {
            if (name.startsWith(this.rootPackage)) {
                out.add(name);
            }
        }
        return out;
    }
    
    @Override
    public Class<?>[] find(final Collection<String> classNames, final Class<? extends Annotation> annotation) {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        for (final String name : classNames) {
            try {
                final Class<?> clazz = Class.forName(name, false, this.urlClassLoader);
                if (!clazz.isAnnotationPresent(annotation)) {
                    continue;
                }
                classes.add(clazz);
            }
            catch (NoClassDefFoundError ncdfe) {}
            catch (ClassNotFoundException ex) {}
        }
        return classes.toArray(new Class[classes.size()]);
    }
}
