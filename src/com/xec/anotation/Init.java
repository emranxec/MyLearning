package com.xec.anotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

//create annotation (@interface)
//add @retention
//add @target

@Retention(RUNTIME)
@Target(METHOD)
public @interface Init {
    //We declared a public annotation with runtime visibility that we can apply to our classes' methods.
}
