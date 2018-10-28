package com.danielme.blog.validation.custom;

import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.danielme.blog.validation.custom.impl.SameValueViaInterfaceValidator;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SameValueViaInterfaceValidator.class)
public @interface SameValueViaInterface {

    String message() default "{com.danielme.blog.validation.custom.SameValue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
