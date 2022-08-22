package com.freeit.lesson16.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface NotSecretPhone {

    boolean secret() default true;

}