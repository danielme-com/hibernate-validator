package com.danielme.blog.validation.custom.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.danielme.blog.validation.custom.SameValueFields;
import com.danielme.blog.validation.custom.SameValueViaInterface;

public class SameValueViaInterfaceValidator
        implements ConstraintValidator<SameValueViaInterface, SameValueFields> {

    @Override
    public boolean isValid(SameValueFields object, ConstraintValidatorContext context) {

        return object.getField1() == null || object.getField2() == null
                || object.getField1().equals(object.getField2());
    }

}
