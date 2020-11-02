package com.danielme.blog.validation.custom.impl;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.danielme.blog.validation.custom.StringRange;

public class StringRangeValidator implements ConstraintValidator<StringRange, String> {

    private String[] values;

    @Override
    public void initialize(StringRange constraintAnnotation) {
        values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(values).contains(value);
    }

}
