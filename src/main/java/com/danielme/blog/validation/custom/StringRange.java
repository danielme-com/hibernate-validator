package com.danielme.blog.validation.custom;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.danielme.blog.validation.custom.impl.StringRangeValidator;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringRangeValidator.class)
public @interface StringRange {

    String[] values();

    String message() default "{com.danielme.blog.validation.custom.StringRange.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
