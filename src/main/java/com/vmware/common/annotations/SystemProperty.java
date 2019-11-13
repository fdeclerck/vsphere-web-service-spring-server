// 
// Decompiled by Procyon v0.5.36
// 

package com.vmware.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemProperty {
    String property();
    
    String defaultValue() default "";
    
    boolean required() default false;
    
    String description() default "";
}
