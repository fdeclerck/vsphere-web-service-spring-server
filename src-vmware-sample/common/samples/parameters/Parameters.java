// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.parameters;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.vmware.common.samples.SampleRegistry;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import com.vmware.common.samples.SystemParameters;
import java.util.LinkedHashMap;
import java.util.Map;

public class Parameters implements SampleParameters
{
    private final Class<?> sampleClass;
    private final Options options;
    private final Map<String, Object> parameters;
    
    @Override
    public Class<?> getSampleClass() {
        return this.sampleClass;
    }
    
    public Parameters(final Class<?> sampleClass, final Options options) {
        this.parameters = new LinkedHashMap<String, Object>();
        this.sampleClass = sampleClass;
        this.options = options;
    }
    
    public Options getOptions() {
        return this.options;
    }
    
    @Override
    public String get(final String param) {
        return this.parameters.get(param.toLowerCase()).toString();
    }
    
    @Override
    public SampleParameters parse(final String[] args, final SystemParameters systemParameters) throws IllegalArgumentException {
        this.parameters.putAll(systemArgs(this.options.list, systemParameters));
        this.parameters.putAll(parseArgs(this.options.list, args));
        this.validate();
        return this;
    }
    
    public void validate() {
        for (final OptionReference option : this.options.list) {
            if (option.required && !this.parameters.containsKey(option.name)) {
                throw new ParameterException("option " + option.toString() + " is required");
            }
            if (option.required && option.parameter && !validValue(this.parameters.get(option.name))) {
                throw new ParameterException("option " + option.toString() + " is required & must have a valid parameter entered after it");
            }
        }
    }
    
    public static Map<String, Object> systemArgs(final Collection<OptionReference> list, final SystemParameters systemParameters) {
        return systemArgs(list.toArray(new OptionReference[list.size()]), systemParameters);
    }
    
    public static Map<String, Object> systemArgs(final OptionReference[] options, final SystemParameters systemParameters) {
        final Map<String, Object> params = new HashMap<String, Object>();
        for (final OptionReference option : options) {
            if (option.systemProperty != null) {
                final String val = systemParameters.get(option.systemProperty);
                if (val != null) {
                    params.put(option.name, val);
                }
            }
        }
        return params;
    }
    
    public static Map<String, Object> parseArgs(final Collection<OptionReference> list, final String[] args) {
        return parseArgs(list.toArray(new OptionReference[list.size()]), args);
    }
    
    public static Map<String, Object> parseArgs(final OptionReference[] options, final String[] args) {
        final Map<String, Object> params = new HashMap<String, Object>();
        boolean skip;
        for (int index = 0; index < args.length; index += (skip ? 2 : 1)) {
            final String param = args[index].trim();
            String key = null;
            Object value = null;
            skip = false;
            for (final OptionReference option : options) {
                if (option.match(param)) {
                    key = option.name;
                    if (option.parameter) {
                        value = ((index + 1 < args.length) ? args[index + 1].trim() : "");
                        skip = validValue((String)value);
                    }
                    else {
                        value = Boolean.TRUE;
                        skip = false;
                    }
                }
            }
            if (key != null) {
                params.put(key, value);
            }
        }
        return params;
    }
    
    private static boolean validValue(final String val) {
        return val != null && !val.startsWith("--") && !val.isEmpty();
    }
    
    public static SampleParameters build(final Class<?> sampleClass, final Options options, final String[] args, final SystemParameters systemParameters) throws IllegalArgumentException {
        return new Parameters(sampleClass, options).parse(args, systemParameters);
    }
    
    @Override
    public Object inject(final Object pojo) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        final Map<String, Object> objects = new HashMap<String, Object>();
        this.checkClass(pojo);
        final Map<String, Method> setters = new HashMap<String, Method>();
        for (final SystemPropertyReference ref : this.options.systemProperties) {
            if (ref instanceof ComplexSystemPropertyReference) {
                final ComplexSystemPropertyReference cref = (ComplexSystemPropertyReference)ref;
                final String value = System.getProperty(cref.property, cref.defaultValue);
                if ("".equals(value)) {
                    continue;
                }
                Object object = objects.get(cref.field);
                if (object == null) {
                    final Class<?> concreteType = SampleRegistry.lookupType(cref.type);
                    object = concreteType.newInstance();
                    objects.put(cref.field, object);
                }
                cref.setter.invoke(object, value);
                setters.put(cref.field, cref.method);
            }
            else {
                final String value2 = System.getProperty(ref.property, ref.defaultValue);
                if (ref.required && "".equals(value2)) {
                    throw new MissingSystemPropertyException(ref.property, ref.description);
                }
                ref.method.invoke(pojo, value2);
            }
        }
        for (final OptionReference option : this.options.list) {
            if (option instanceof ComplexOptionReference) {
                final ComplexOptionReference copt = (ComplexOptionReference)option;
                if (!objects.containsKey(copt.property)) {
                    final Class concreteType2 = SampleRegistry.lookupType(copt.type);
                    objects.put(copt.property, concreteType2.newInstance());
                }
                final Object object2 = this.parameters.get(option.name);
                if (object2 != null) {
                    copt.setter.invoke(objects.get(copt.property), object2);
                }
                setters.put(copt.property, option.method);
            }
            else {
                final Object value3 = this.parameters.get(option.name);
                if (value3 == null) {
                    continue;
                }
                final Object valueObj = this.constructParameter(option.method, value3);
                if (valueObj == null) {
                    continue;
                }
                option.method.invoke(pojo, valueObj);
            }
        }
        for (final String name : objects.keySet()) {
            final Object object3 = objects.get(name);
            final Method method = setters.get(name);
            method.invoke(pojo, object3);
        }
        return pojo;
    }
    
    public Object constructParameter(final Method setter, final Object value) {
        Object valueObj = null;
        Class<?> valueClass = String.class;
        try {
            final Class<?>[] params = setter.getParameterTypes();
            if (params.length == 1) {
                valueClass = SampleRegistry.map(params[0]);
            }
            if (valueClass.equals(value.getClass())) {
                valueObj = value;
            }
            else if (valueClass.equals(Character.class)) {
                final char[] chars = value.toString().toCharArray();
                if (chars.length > 0) {
                    valueObj = chars[0];
                }
            }
            else if (valueClass.equals(Character[].class)) {
                valueObj = value.toString().toCharArray();
            }
            else {
                final Constructor<?> constructor = valueClass.getConstructor(value.getClass());
                valueObj = constructor.newInstance(value);
            }
        }
        catch (SecurityException e) {
            throw new ParametersInjectionException(e.getMessage(), e);
        }
        catch (NoSuchMethodException e2) {
            throw new ParametersInjectionException(String.format("The class %s used by %s.%s does not have a constructor that takes %s", valueClass.getName(), setter.getDeclaringClass().getName(), setter.getName(), value.getClass().getName()), e2);
        }
        catch (IllegalArgumentException e3) {
            throw new ParametersInjectionException(e3.getMessage(), e3);
        }
        catch (InstantiationException e4) {
            throw new ParametersInjectionException(e4.getMessage(), e4);
        }
        catch (IllegalAccessException e5) {
            throw new ParametersInjectionException(e5.getMessage(), e5);
        }
        catch (InvocationTargetException e6) {
            throw new ParametersInjectionException(e6.getMessage(), e6);
        }
        return valueObj;
    }
    
    private void checkClass(final Object pojo) throws ParameterInjectionException {
        final Class<?> sampleClass = this.getSampleClass();
        if (!pojo.getClass().equals(sampleClass)) {
            throw new ParameterInjectionException("Attempted to inject class " + pojo.getClass() + " when " + sampleClass.getCanonicalName() + " was expected.");
        }
    }
    
    class ParametersInjectionException extends RuntimeException
    {
        private static final long serialVersionUID = 1L;
        
        public ParametersInjectionException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}
