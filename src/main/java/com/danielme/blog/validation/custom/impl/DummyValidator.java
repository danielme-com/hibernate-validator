package com.danielme.blog.validation.custom.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.danielme.blog.validation.custom.Dummy;

public class DummyValidator implements ConstraintValidator<Dummy, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return "dummy".equals(value);
    }

}
