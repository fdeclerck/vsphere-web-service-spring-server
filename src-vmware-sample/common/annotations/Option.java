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
public @interface Option {
    String name();
    
    String systemProperty() default "";
    
    boolean required() default true;
    
    boolean parameter() default true;
    
    String description() default "";
    
    @Deprecated
    Class<?> type() default String.class;
}
