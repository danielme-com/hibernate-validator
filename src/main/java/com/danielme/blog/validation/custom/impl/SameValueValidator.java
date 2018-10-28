package com.danielme.blog.validation.custom.impl;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.danielme.blog.validation.custom.SameValue;

public class SameValueValidator implements ConstraintValidator<SameValue, Object> {

    private String field1;
    private String field2;

    @Override
    public void initialize(SameValue constraintAnnotation) {
        field1 = constraintAnnotation.field1();
        field2 = constraintAnnotation.field2();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            Object value1 = getValue(object, field1);
            Object value2 = getValue(object, field2);

            return value1 == null || value2 == null || value1.equals(value2);
        } catch (Exception ex) {
            throw new IllegalArgumentException(
                    "Cannot read '" + field1 + "', '" + field2 + "' fields from Object " + object,
                    ex);
        }
    }

    private Object getValue(Object object, String fieldName) throws NoSuchFieldException,
            SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

}
