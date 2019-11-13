// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples;

import java.util.Hashtable;
import java.util.Iterator;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Set;
import java.util.Enumeration;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map;

public class SystemParameters
{
    final Map<String, String> parameters;
    
    public SystemParameters() {
        this.parameters = new HashMap<String, String>();
        final Properties properties = System.getProperties();
        final Enumeration<?> names = properties.propertyNames();
        while (names.hasMoreElements()) {
            final Object name = names.nextElement();
            this.set(name, ((Hashtable<K, Object>)properties).get(name));
        }
    }
    
    private void set(final Object key, final Object value) {
        if (key != null) {
            this.set(key.toString(), value.toString());
        }
    }
    
    public boolean has(final String name) {
        return this.parameters.containsKey(name);
    }
    
    public Set<String> parameterNames() {
        return this.parameters.keySet();
    }
    
    public String get(final String name) {
        String value = null;
        if (name != null && !"".equals(name)) {
            value = this.parameters.get(name);
        }
        return value;
    }
    
    public SystemParameters set(final String key, final String value) {
        if (key != null && value != null) {
            this.parameters.put(key, value);
        }
        return this;
    }
    
    public static SystemParameters parse(final File... files) throws IOException {
        final SystemParameters p = new SystemParameters();
        for (final File file : files) {
            p.parse(file);
        }
        return p;
    }
    
    public SystemParameters parse(final File file) throws IOException {
        final InputStream inputStream = new FileInputStream(file);
        return this.parse(inputStream);
    }
    
    public SystemParameters parse(final InputStream input) throws IOException {
        final Properties properties = new Properties();
        properties.load(input);
        final Set<String> keys = properties.stringPropertyNames();
        for (final String key : keys) {
            final String value = properties.getProperty(key);
            this.parameters.put(key, value);
        }
        return this;
    }
}
