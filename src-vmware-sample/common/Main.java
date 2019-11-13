// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common;

import java.lang.reflect.InvocationTargetException;
import com.vmware.common.samples.registry.SampleReference;
import java.util.Arrays;
import java.net.URI;
import java.net.URL;
import javax.xml.ws.soap.SOAPFaultException;
import com.vmware.common.samples.SampleException;
import com.vmware.common.samples.reflection.SampleReflectionException;
import com.vmware.common.samples.registry.SampleNotFoundException;
import com.vmware.common.samples.SampleRegistry;
import java.io.FilenameFilter;
import java.util.List;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.LinkedList;
import java.io.File;
import com.vmware.common.samples.registry.SampleExecutionRecord;
import java.util.Iterator;
import com.vmware.common.samples.reflection.UnregisteredSampleHandler;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import com.vmware.common.ssl.TrustAll;
import com.vmware.common.samples.SystemParameters;

public class Main
{
    static final String HELP = "--help";
    private static SystemParameters systemParameters;
    
    public static void trustAll() throws NoSuchAlgorithmException, KeyManagementException {
        TrustAll.trust();
    }
    
    public static void main(final String[] args) throws Throwable {
        Main.systemParameters = SystemParameters.parse(findConfigurationFiles());
        for (final String propName : Main.systemParameters.parameterNames()) {
            final String value = Main.systemParameters.get(propName);
            System.setProperty(propName, value);
        }
        trustAll();
        System.out.printf("%s%n", System.getProperty("sample.header", "-- VMware samples in Java --"));
        if (args.length > 0 && UnregisteredSampleHandler.isStandalone(args[0])) {
            final String[] subargs = new String[args.length - 1];
            if (args.length > 1) {
                System.arraycopy(args, 1, subargs, 0, subargs.length);
            }
            UnregisteredSampleHandler.handle(args[0], subargs);
        }
        else {
            final SampleExecutionRecord record = registeredSample(args);
            if (!record.isGood()) {
                System.out.println(System.getProperty("sample.footer", ""));
            }
        }
        System.out.println();
    }
    
    private static File[] findConfigurationFiles() {
        final List<File> files = new LinkedList<File>();
        for (final String fileName : propertyFileNames()) {
            try {
                final List<File> found = findPropertiesFile(fileName.replaceAll("(^\\s+|\\s+$)", ""));
                files.addAll(found);
            }
            catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return files.toArray(new File[files.size()]);
    }
    
    public static String[] propertyFileNames() {
        final String specified = System.getProperty("sample.properties.files");
        return (specified != null && !"".equals(specified)) ? specified.split("\\s*,\\s*") : scanForPropertyFiles();
    }
    
    public static String[] scanForPropertyFiles() {
        final File[] files = new File(".").listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File file, final String s) {
                return s.endsWith(".properties");
            }
        });
        final String[] names = new String[files.length];
        for (int i = 0; i < names.length; ++i) {
            names[i] = files[i].getName();
        }
        return names;
    }
    
    private static SampleExecutionRecord registeredSample(final String[] args) {
        SampleExecutionRecord record = SampleExecutionRecord.NULL_RECORD;
        final SampleRegistry registry = new SampleRegistry(Main.systemParameters, "--help").init();
        final String name = (args.length > 0) ? registry.getSampleName(args[0]) : "help";
        try {
            record = sampleSwitching(registry, name, args);
            if (record.hasFault()) {
                final Throwable fault = record.getFault();
                printError(fault.getMessage(), fault);
                if (showStackTrace()) {
                    fault.printStackTrace(System.out);
                }
            }
        }
        catch (SampleNotFoundException snfe) {
            System.out.println();
            System.out.println("\tERROR: " + snfe.getMessage());
            System.out.println();
            registry.usage(System.out);
        }
        catch (SampleReflectionException sre) {
            printError(sre.getCause().getMessage(), sre.getCause());
        }
        catch (SampleException se) {
            printError(se.getMessage(), se.getCause());
            registry.help(name, System.out);
        }
        catch (SOAPFaultException sfe) {
            System.out.println("SOAP Fault -");
            if (sfe.getFault().hasDetail()) {
                System.out.println(sfe.getFault().getDetail().getFirstChild().getLocalName());
            }
            if (sfe.getFault().getFaultString() != null) {
                System.out.println("\n Message: " + sfe.getFault().getFaultString());
            }
        }
        return record;
    }
    
    public static boolean showStackTrace() {
        return Boolean.valueOf(System.getProperty("samples.show.stack.trace", Defaults.SAMPLES_SHOW_STACK_TRACE));
    }
    
    private static void printError(final String message, final Throwable cause) {
        System.out.println();
        System.out.println("\tERROR: " + message);
        System.out.println();
        if (cause != null) {
            cause.printStackTrace();
        }
    }
    
    public static List<File> findPropertiesFile(final String fileName) throws URISyntaxException {
        if (null == fileName || fileName.length() == 0) {
            return new LinkedList<File>();
        }
        final List<File> files = new LinkedList<File>();
        final URL resourceUrl = Main.class.getResource(fileName);
        if (resourceUrl != null) {
            final URI resourceUri = resourceUrl.toURI();
            files.add(new File(resourceUri));
        }
        final File workingDir = new File(".");
        checkForProperties(workingDir, fileName, files);
        final File homeDir = new File(System.getProperty("user.home"));
        checkForProperties(homeDir, fileName, files);
        return files;
    }
    
    private static void checkForProperties(final File dir, final String fileName, final List<File> files) {
        final File file = new File(dir, fileName);
        if (file.exists() && file.canRead()) {
            files.add(file);
        }
    }
    
    private static SampleExecutionRecord sampleSwitching(final SampleRegistry registry, final String name, final String[] args) throws SampleNotFoundException {
        if (contains(args, "--help") || "--help".equals(name) || "--help".contains(name)) {
            registry.help(name, System.out);
            return SampleExecutionRecord.NULL_RECORD;
        }
        String[] subargs = args;
        if (args.length > 0) {
            subargs = Arrays.copyOfRange(args, 1, args.length);
        }
        return run(registry.describe(name), subargs);
    }
    
    private static boolean contains(final String[] args, final String string) {
        boolean found = false;
        for (final String arg : args) {
            found |= arg.equalsIgnoreCase(string);
        }
        return found;
    }
    
    private static SampleExecutionRecord run(final SampleReference ref, final String[] params) {
        SampleExecutionRecord record = null;
        try {
            record = ref.run(params);
        }
        catch (InvocationTargetException e) {
            throw new SampleReflectionException(e);
        }
        catch (InstantiationException e2) {
            throw new SampleReflectionException(e2);
        }
        catch (IllegalAccessException e3) {
            throw new SampleReflectionException(e3);
        }
        return record;
    }
    
    public static class SampleMissingConfigurationsException extends SampleIllegalArgumentException
    {
        private static final long serialVersionUID = 1L;
        
        private static String configurationErrorMessage() {
            String message = "Missing configuration files! Requires one of these configuration files to be present ";
            for (final String fileName : Main.propertyFileNames()) {
                message = message + " '" + fileName + "' ";
            }
            message += " in ";
            message = message + System.getProperty("user.home") + " or ";
            message += new File(".").getAbsolutePath();
            return message;
        }
        
        public SampleMissingConfigurationsException() {
            super(configurationErrorMessage());
        }
    }
    
    public static class SampleIllegalArgumentException extends SampleException
    {
        private static final long serialVersionUID = -6434091576608075485L;
        
        public SampleIllegalArgumentException(final String message) {
            super(message);
        }
        
        public SampleIllegalArgumentException(final Throwable throwable) {
            super(throwable);
        }
    }
    
    public static class SampleInputValidationException extends SampleIllegalArgumentException
    {
        private static final long serialVersionUID = -2181593283163266846L;
        
        public SampleInputValidationException(final String message) {
            super(message);
        }
    }
    
    public static class Properties
    {
        public static final String SAMPLE_PROPERTIES_FILES = "sample.properties.files";
        public static final String TRUST_ALL = "ssl.trustAll.enabled";
        public static final String TRUST_ALL_MESSAGE = "ssl.trustAll.message";
        public static final String SAMPLE_HEADER = "sample.header";
        public static final String SAMPLE_FOOTER = "sample.footer";
        public static final String SAMPLE_HELP_FOOTER = "sample.help.footer";
        public static final String SAMPLE_PACKAGE_NAME = "sample.package.name";
        public static final String SAMPLES_SHOW_STACK_TRACE = "samples.show.stack.trace";
        public static final String SAMPLES_USE_NAME = "samples.use.name";
    }
    
    public static class Defaults
    {
        public static final String TRUST_ALL;
        public static final String TRUST_ALL_MESSAGE = "WARNING: Java is now set to trust all SSL certificates.";
        public static final String SAMPLE_HEADER = "-- VMware samples in Java --";
        public static final String SAMPLE_FOOTER = "";
        public static final String SAMPLE_HELP_FOOTER = "to invoke a command, type its class name. For help type --help at the end of any command.";
        public static final String SAMPLE_PACKAGE_NAME = "com.vmware";
        public static final String SAMPLES_SHOW_STACK_TRACE;
        public static final String SAMPLES_USE_NAME;
        
        static {
            TRUST_ALL = Boolean.FALSE.toString();
            SAMPLES_SHOW_STACK_TRACE = Boolean.TRUE.toString();
            SAMPLES_USE_NAME = Boolean.FALSE.toString();
        }
    }
}
