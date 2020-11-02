package com.danielme.blog.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import com.danielme.blog.validation.model.CustomValidators;

public class CustomValidatorsTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testDummyNoOk() {
        CustomValidators customValidators = new CustomValidators();
        Set<ConstraintViolation<CustomValidators>> violations = validator
                .validate(customValidators);
        assertEquals(1, violations.size());
        assertEquals("{com.danielme.blog.validation.custom.DummyValidator.message}",
                violations.iterator().next().getMessage());
    }

    @Test
    public void testDummyOk() {
        CustomValidators customValidators = new CustomValidators();
        customValidators.setDummy("dummy");
        
        Set<ConstraintViolation<CustomValidators>> violations = validator
                .validate(customValidators);
        
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testRangeOk() {
        CustomValidators customValidators = new CustomValidators();
        customValidators.setDummy("dummy");
        customValidators.setCountry("Spain");

        Set<ConstraintViolation<CustomValidators>> violations = validator
                .validate(customValidators);
        
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testRangeNoOk() {
        CustomValidators customValidators = new CustomValidators();
        customValidators.setCountry("Germany");
        customValidators.setDummy("dummy");

        Set<ConstraintViolation<CustomValidators>> violations = validator
                .validate(customValidators);

        assertEquals(1, violations.size());
        assertEquals("{com.danielme.blog.validation.custom.StringRange.message}",
                violations.iterator().next().getMessage());
    }
    
    @Test
    public void testSameValueNoOk() {
        CustomValidators customValidators = new CustomValidators();
        customValidators.setDummy("dummy");
        customValidators.setField1("value1");
        customValidators.setField2("value2");
        
        Set<ConstraintViolation<CustomValidators>> violations = validator
                .validate(customValidators);
        
        assertEquals(1, violations.size());
        assertEquals("{com.danielme.blog.validation.custom.SameValue.message}",
                violations.iterator().next().getMessage());
    }
    
    @Test
    public void testSameValueOk() {
        CustomValidators customValidators = new CustomValidators();
        customValidators.setDummy("dummy");
        customValidators.setField1("value");
        customValidators.setField2("value");
        
        Set<ConstraintViolation<CustomValidators>> violations = validator
                .validate(customValidators);
        
        assertTrue(violations.isEmpty());
    }

}
