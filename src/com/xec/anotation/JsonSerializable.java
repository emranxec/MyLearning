package com.xec.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JsonSerializable {
    //annotation has runtime visibility, and we can apply it to types (classes).
    //it has no methods, and thus serves as a simple marker to mark classes that can be serialized into JSON.
}

