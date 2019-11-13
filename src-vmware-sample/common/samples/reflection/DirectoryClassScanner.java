// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.samples.reflection;

import java.util.LinkedList;
import java.net.URISyntaxException;
import com.vmware.common.Main;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.net.URL;

public class DirectoryClassScanner implements ClassScanner
{
    private final String classFileSuffix;
    
    public DirectoryClassScanner(final String classFileSuffix) {
        this.classFileSuffix = classFileSuffix;
    }
    
    @Override
    public Collection<String> scan(final URL url) {
        final Set<String> classNames = new HashSet<String>();
        final Collection<String> fileNames = this.search(file(url), this.classFileSuffix);
        for (final String fileName : fileNames) {
            classNames.add(fileName);
        }
        return classNames;
    }
    
    public static File file(final URL url) {
        File root = null;
        try {
            root = new File(url.toURI());
        }
        catch (URISyntaxException e) {
            throw new Main.SampleIllegalArgumentException(e);
        }
        return root;
    }
    
    private Collection<String> search(final File root, final String suffix) {
        final LinkedList<String> names = new LinkedList<String>();
        final LinkedList<File> dirs = new LinkedList<File>();
        dirs.push(root);
        final String basePath = root.getAbsolutePath();
        final int trimBasePath = basePath.length() + 1;
        while (!dirs.isEmpty()) {
            final File dir = dirs.pop();
            for (final File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    dirs.push(file);
                }
                else {
                    final String name = file.getAbsolutePath().substring(trimBasePath);
                    if (name.endsWith(this.classFileSuffix)) {
                        names.push(name.substring(0, name.length() - this.classFileSuffix.length()).replace(File.separator, "."));
                    }
                }
            }
        }
        return names;
    }
}
