package com.danielme.blog.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

import com.danielme.blog.validation.model.Address;
import com.danielme.blog.validation.model.AddressWithGroup;
import com.danielme.blog.validation.model.User;
import com.danielme.blog.validation.model.AddressWithGroup.NoCountry;

public class ValidatorTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testEmpty() {
        Set<ConstraintViolation<User>> violations = validator.validate(new User());
        assertEquals(4, violations.size());
        violations.stream().forEach(v -> System.out.println(
                v.getPropertyPath() + " : " + v.getMessageTemplate() + " = " + v.getMessage()));
    }

    @Test
    public void testNotNull() {
        Set<ConstraintViolation<User>> violations = validator.validate(buildValidUser());
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testAddress() {
        User user = buildValidUser();
        Address address = new Address();
        user.setAddress(address);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(3, violations.size());
        violations.stream()
                .forEach(v -> System.out.println(v.getPropertyPath() + " : " + v.getMessage()));
    }

    @Test
    public void testEmail() {
        User user = buildValidUser();
        user.setEmail("mail.com");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals("user.email.mask", violations.iterator().next().getMessage());
    }

    @Test
    public void testUrlError() {
        User user = buildValidUser();
        user.setPersonalBlog("www.danielme.com");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals("user.personalBlog.url", violations.iterator().next().getMessage());
    }

    @Test
    public void testUrlSucces() {
        User user = buildValidUser();
        user.setPersonalBlog("https://www.danielme.com");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testEmptyTags() {
        User user = buildValidUser();
        user.setTags(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals("user.tags.empty", violations.iterator().next().getMessage());
    }
    
    @Test
    public void testAddressWithGroupDefault() {
        AddressWithGroup address = new AddressWithGroup();
        Set<ConstraintViolation<AddressWithGroup>> violations = validator.validate(address);
        assertEquals(3, violations.size());
        violations.stream()
                .forEach(v -> System.out.println(v.getPropertyPath() + " : " + v.getMessage()));
    }
    
    @Test
    public void testAddressWithGroupNoCountry() {
        AddressWithGroup address = new AddressWithGroup();
        Set<ConstraintViolation<AddressWithGroup>> violations = validator.validate(address, NoCountry.class);
        assertEquals(2, violations.size());
        violations.stream()
                .forEach(v -> System.out.println(v.getPropertyPath() + " : " + v.getMessage()));
    }

    private User buildValidUser() {
        User user = new User();
        user.setName("Harris");
        user.setEmail("harris@gmail.com");
        user.setLegalAge(true);
        List<String> tags = new LinkedList<>();
        tags.add("Java");
        tags.add("Spring");
        tags.add("Android");
        user.setTags(tags);
        return user;
    }

}
