// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples;

import com.vmware.common.annotations.After;
import com.vmware.common.annotations.Action;
import com.vmware.common.annotations.Before;
import java.lang.reflect.Constructor;
import com.vmware.common.samples.registry.ActionReference;
import java.lang.reflect.Method;
import com.vmware.common.annotations.SystemProperty;
import com.vmware.common.annotations.Option;
import com.vmware.common.samples.parameters.Options;
import java.util.Iterator;
import com.vmware.common.samples.parameters.OptionReference;
import java.io.PrintStream;
import com.vmware.common.samples.registry.SampleNotFoundException;
import java.util.Collection;
import java.util.Arrays;
import com.vmware.common.samples.reflection.ClassFinder;
import com.vmware.common.samples.reflection.SmartClassFinder;
import java.net.URLClassLoader;
import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import com.vmware.common.annotations.Sample;
import com.vmware.common.Main;
import java.util.LinkedHashMap;
import java.util.HashMap;
import com.vmware.common.samples.registry.SampleReference;
import java.util.Map;
import com.vmware.common.samples.reflection.MethodFinder;

public class SampleRegistry
{
    public static final int COL_SIZE = 13;
    MethodFinder methodFinder;
    private Map<Class<?>, String> lookup;
    private Map<String, SampleReference> registry;
    final String format;
    final String help;
    final SystemParameters systemParameters;
    final Boolean useSampleName;
    
    public SampleRegistry(final SystemParameters systemParameters) {
        this(systemParameters, "%1", "--help");
    }
    
    public SampleRegistry(final SystemParameters systemParameters, final String help) {
        this(systemParameters, format(13), help);
    }
    
    public SampleRegistry(final SystemParameters systemParameters, final String format, final String help) {
        this.methodFinder = new MethodFinder();
        this.lookup = new HashMap<Class<?>, String>();
        this.systemParameters = systemParameters;
        this.format = format;
        this.help = help;
        this.lookup = new HashMap<Class<?>, String>();
        this.registry = new LinkedHashMap<String, SampleReference>();
        this.useSampleName = Boolean.valueOf(System.getProperty("samples.use.name", Main.Defaults.SAMPLES_USE_NAME));
    }
    
    public static String format(final int size) {
        return "%1$-" + size + "s";
    }
    
    public int size() {
        return this.registry.size();
    }
    
    @PostConstruct
    public SampleRegistry init() {
        final Class<?>[] classes = classList((Class<? extends Annotation>)Sample.class);
        this.registry = this.buildRegistry(classes);
        return this;
    }
    
    public static Class<?>[] classList(final Class<? extends Annotation> annotation) {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final String rootPackage = System.getProperty("sample.package.name", "com.vmware");
        final ClassFinder classFinder = new SmartClassFinder((URLClassLoader)classLoader, rootPackage);
        return classFinder.find(classFinder.getClassNames(), annotation);
    }
    
    public boolean isSample(final String sampleName) {
        return this.registry.containsKey(sampleName.toLowerCase()) || this.registry.containsKey(this.trimSampleName(sampleName));
    }
    
    public String trimSampleName(final String sampleNameLong) {
        if (sampleNameLong.endsWith(".")) {
            return "";
        }
        return sampleNameLong.substring(sampleNameLong.lastIndexOf(".") + 1, sampleNameLong.length());
    }
    
    public boolean isSample(final Class<?> clazz) {
        return this.lookup.containsKey(clazz);
    }
    
    public String[] listSamples() {
        final Collection<SampleReference> samples = this.registry.values();
        SampleReference[] refs = new SampleReference[samples.size()];
        refs = samples.toArray(refs);
        Arrays.sort(refs);
        final String[] names = new String[refs.length];
        for (int ii = 0; ii < refs.length; ++ii) {
            names[ii] = refs[ii].getName();
        }
        return names;
    }
    
    public SampleReference describe(final String sampleName) throws SampleNotFoundException {
        if (!this.registry.containsKey(sampleName)) {
            throw new SampleNotFoundException(sampleName);
        }
        return this.registry.get(sampleName);
    }
    
    public SampleReference describe(final Class<?> clazz) {
        return this.describe(this.lookup.get(clazz));
    }
    
    public void usage(final PrintStream out) {
        final String format = format(26);
        out.print("====  " + this.registry.size() + " available samples ====");
        final String[] samples = this.listSamples();
        String lastGroup = null;
        int col = 0;
        for (final String sampleName : samples) {
            if (!this.group(sampleName).equals(lastGroup)) {
                out.println();
                out.println();
                lastGroup = this.group(sampleName);
                out.println(lastGroup);
                out.print("  ");
                col = 0;
            }
            final String string = String.format(format, sampleName + "  ");
            out.print(string);
            col += string.length();
            if (col > 52) {
                col = 0;
                out.print("\n  ");
            }
        }
        out.println();
        out.println();
        out.println(System.getProperty("sample.help.footer", "to invoke a command, type its class name. For help type --help at the end of any command."));
    }
    
    public String group(final String sample) {
        return this.describe(sample).getPackage();
    }
    
    public void help(final SampleReference reference, final PrintStream out) {
        out.println();
        out.println(reference.getName());
        if (!reference.getDescription().equals("")) {
            out.println(this.columnFormat("\n  ", 5, reference.getDescription().replaceAll("\\s+", " ")));
        }
        for (final OptionReference option : reference.listOptions()) {
            out.print("  ");
            out.print(String.format(this.format, option.toString()));
            out.print("  ");
            out.print(String.format(this.format, option.parameter ? ("<" + option.name + ">") : " "));
            out.print("  ");
            out.print(String.format(this.format, option.required ? "[required]" : " optional "));
            out.print("  ");
            if (option.description != null) {
                final String desc = (option.description.length() > 26) ? this.columnFormat("\n\t\t\t\t", 3, option.description.replaceAll("\\s+|\\n+|\\t+", " ").replaceFirst("^\\s+", "")) : option.description;
                out.print(desc);
            }
            out.println();
        }
    }
    
    private String columnFormat(final String delimit, final int cols, final String description) {
        final StringBuffer out = new StringBuffer();
        out.append(delimit);
        int position = 0;
        int col = 0;
        while (position < description.length()) {
            final char ch = description.charAt(position);
            if (this.near(col, 13 * cols, 12) && ch == ' ') {
                out.append(delimit);
                col = 0;
            }
            else {
                ++col;
                out.append(ch);
            }
            ++position;
        }
        out.append("\n");
        return out.toString();
    }
    
    boolean near(final int num, final int max, final int range) {
        return num >= max - range || max <= num;
    }
    
    public void help(final String sampleName, final PrintStream out) throws SampleNotFoundException {
        if (sampleName.contains("help")) {
            this.usage(out);
        }
        else {
            this.help(this.describe(sampleName), out);
        }
    }
    
    Map<String, SampleReference> buildRegistry(final Class<?>[] classes) {
        for (final Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent((Class<? extends Annotation>)Sample.class)) {
                final SampleReference ref = this.reference(clazz);
                this.register(ref);
            }
        }
        return this.registry;
    }
    
    public void register(final Class<?> sampleClass) throws ClassNotFoundException {
        this.register(this.reference(sampleClass));
    }
    
    public void register(final SampleReference ref) {
        if (this.registry.containsKey(ref.getName())) {
            throw new RegistryException("The name: '" + ref.getName() + "' specified by class: " + ref.getClass().getCanonicalName() + " is already in use!");
        }
        this.registry.put(ref.getName(), ref);
        this.lookup.put(ref.getClass(), ref.getName());
    }
    
    public SampleReference reference(final Class<?> clazz) {
        final Sample sample = clazz.getAnnotation(Sample.class);
        final String name = this.name(clazz, sample);
        return this.reference(name, sample.description(), clazz);
    }
    
    String name(final Class<?> clazz, final Sample sample) {
        return (this.useSampleName && !"".equals(sample.name())) ? sample.name() : clazz.getSimpleName();
    }
    
    SampleReference reference(final String name, final String description, final Class<?> sample) {
        final Options options = new Options(sample);
        final Class<? extends Annotation> optionAnnotationClass = (Class<? extends Annotation>)Option.class;
        final Method[] arr$;
        final Method[] methods = arr$ = this.methodFinder.find(sample, optionAnnotationClass);
        for (final Method method : arr$) {
            final Option opt = method.getAnnotation(Option.class);
            final Class<?> type = this.determineType(method);
            if (this.isSimpleType(type)) {
                if (opt.systemProperty().length() == 0) {
                    options.option(opt.name(), opt.required(), opt.parameter(), opt.description(), method);
                }
                else {
                    options.option(opt.name(), opt.systemProperty(), opt.required(), opt.parameter(), opt.description(), method);
                }
            }
            else {
                final Method[] arr$2;
                final Method[] setters = arr$2 = this.methodFinder.find(type, optionAnnotationClass);
                for (final Method setter : arr$2) {
                    final Option subopt = setter.getAnnotation(Option.class);
                    options.complex(subopt.name(), opt.name(), type, subopt.systemProperty(), subopt.required(), subopt.parameter(), subopt.description(), method, setter);
                }
                final Method[] arr$3;
                final Method[] propertySetters = arr$3 = this.methodFinder.find(type, (Class<? extends Annotation>)SystemProperty.class);
                for (final Method setter2 : arr$3) {
                    final SystemProperty systemProperty = setter2.getAnnotation(SystemProperty.class);
                    options.complexSystemProperties(opt.name(), systemProperty.property(), systemProperty.defaultValue(), systemProperty.required(), systemProperty.description(), method, setter2, lookupType(type));
                }
            }
        }
        this.systemProperties(sample, options);
        final ActionReference actionRef = this.findActionMethods(sample, this.methodFinder);
        return new SampleReference(this.systemParameters, name, description, sample, actionRef, options);
    }
    
    public void systemProperties(final Class<?> sample, final Options options) {
        final Class<? extends Annotation> systemPropertyAnnotationClass = (Class<? extends Annotation>)SystemProperty.class;
        final Method[] arr$;
        final Method[] propertyMethods = arr$ = this.methodFinder.find(sample, systemPropertyAnnotationClass);
        for (final Method propertyMethod : arr$) {
            final SystemProperty systemProperty = propertyMethod.getAnnotation(SystemProperty.class);
            options.systemProperty(systemProperty.property(), systemProperty.defaultValue(), systemProperty.required(), systemProperty.description(), propertyMethod);
        }
    }
    
    public boolean isSimpleType(final Class<?> type) {
        boolean simple = type.equals(String.class) || type.equals(Character.TYPE) || type.equals(Character.class);
        if (!simple) {
            try {
                final Constructor<?> constructor = type.getConstructor(String.class);
                simple = (constructor != null);
            }
            catch (SecurityException e) {
                simple = false;
            }
            catch (NoSuchMethodException e2) {
                simple = false;
            }
        }
        return simple;
    }
    
    public Class<?> determineType(final Method method) {
        final Class<?>[] params = method.getParameterTypes();
        if (params.length != 1) {
            throw new RegistryException(String.format("The setter method %s.%s takes %d arguments! Setters may only specify 1 and only 1 argument.", method.getDeclaringClass().getName(), method.getName(), params.length));
        }
        final Class<?> found = map(params[0]);
        return found;
    }
    
    public static Class<?> map(final Class<?> type) {
        Class<?> mapped = type;
        final Class<?>[] source = (Class<?>[])new Class[] { Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.TYPE, Character.TYPE };
        final Class<?>[] output = (Class<?>[])new Class[] { Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Boolean.class, Character.class };
        for (int i = 0; i < source.length; ++i) {
            if (source[i].equals(type)) {
                mapped = output[i];
            }
        }
        return mapped;
    }
    
    public static Class<?> lookupType(final Class<?> type) {
        final String typeName = System.getProperty(type.getCanonicalName(), type.getCanonicalName());
        try {
            return Class.forName(typeName);
        }
        catch (ClassNotFoundException e) {
            throw new IllegalStateException(String.format("The class %s could not be found.", type.getCanonicalName()), e);
        }
    }
    
    ActionReference findActionMethods(final Class<?> sample, final MethodFinder methodFinder) {
        final Class[] actions = { Before.class, Action.class, After.class };
        final Method[] actionRef = new Method[actions.length];
        for (int ii = 0; ii < actions.length; ++ii) {
            final Method[] actionMethods = methodFinder.find(sample, actions[ii]);
            if (actionMethods.length > 0) {
                actionRef[ii] = actionMethods[0];
            }
        }
        return new ActionReference(actionRef[0], actionRef[1], actionRef[2]);
    }
    
    public boolean isBareSample(final String name) {
        return this.isSample(name) && this.noRequiredParams(name);
    }
    
    public boolean noRequiredParams(final String name) {
        if (this.noParams(name)) {
            return true;
        }
        boolean required = false;
        for (final OptionReference option : this.describe(name).listOptions()) {
            required |= option.required;
        }
        return !required;
    }
    
    private boolean noParams(final String name) {
        return this.describe(name).listOptions().size() == 0;
    }
    
    public String getSampleName(final String className) {
        try {
            final Class<?> clazz = Class.forName(className, false, Thread.currentThread().getContextClassLoader());
            if (clazz.isAnnotationPresent((Class<? extends Annotation>)Sample.class)) {
                final Sample sample = clazz.getAnnotation(Sample.class);
                return this.name(clazz, sample);
            }
            return this.help;
        }
        catch (ClassNotFoundException e) {
            return className;
        }
    }
    
    public class RegistryException extends IllegalStateException
    {
        private static final long serialVersionUID = 4790527743238997636L;
        
        public RegistryException(final String message) {
            super(message);
        }
    }
}
