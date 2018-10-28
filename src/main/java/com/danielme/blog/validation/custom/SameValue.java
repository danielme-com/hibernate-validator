package com.danielme.blog.validation.custom;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.danielme.blog.validation.custom.impl.SameValueValidator;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SameValueValidator.class)
public @interface SameValue {

    String field1();

    String field2();

    String message() default "{com.danielme.blog.validation.custom.SameValue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
