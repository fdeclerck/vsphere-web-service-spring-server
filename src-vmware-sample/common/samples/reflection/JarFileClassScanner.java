// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.reflection;

import java.util.jar.JarEntry;
import java.util.Set;
import java.util.jar.JarInputStream;
import java.util.HashSet;
import java.io.IOException;
import java.util.Collection;
import java.net.URL;

public class JarFileClassScanner implements ClassScanner
{
    private final String classFileSuffix;
    
    public JarFileClassScanner(final String classFileSuffix) {
        this.classFileSuffix = classFileSuffix;
    }
    
    @Override
    public Collection<String> scan(final URL url) {
        Collection<String> out = null;
        try {
            out = this.scanJarFile(url);
        }
        catch (IOException e) {
            throw new SampleJarFileReflectionException(e);
        }
        return out;
    }
    
    private Collection<String> scanJarFile(final URL url) throws IOException {
        final Set<String> classNames = new HashSet<String>();
        final JarInputStream jarInputStream = new JarInputStream(url.openStream());
        for (JarEntry entry = jarInputStream.getNextJarEntry(); entry != null; entry = jarInputStream.getNextJarEntry()) {
            final String name = entry.toString();
            if (name.endsWith(this.classFileSuffix)) {
                final String className = name.substring(0, name.length() - this.classFileSuffix.length()).replaceAll("\\\\|/", ".");
                classNames.add(className);
            }
        }
        return classNames;
    }
    
    private class SampleJarFileReflectionException extends SampleReflectionException
    {
        private static final long serialVersionUID = 1L;
        
        public SampleJarFileReflectionException(final IOException e) {
            super("typically thrown due to a classpath problem", e);
        }
    }
}
