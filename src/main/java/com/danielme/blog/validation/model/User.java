package com.danielme.blog.validation.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

public class User {

    @NotNull(message = "user.name.empty")
    @Size(min = 5, max = 50, message = "user.name.size")
    private String name;

    @NotNull(message = "user.email.empty")
    @Email(message = "user.email.mask")
    private String email;

    @Min(value = 600000000, message = "user.phoneNumber.min")
    @Max(value = 699999999, message = "user.phoneNumber.max")
    private Integer phoneNumber;

    @Pattern(regexp = "[6][0-9]{8}", message = "user.phoneNumberAsString.mask")
    private String phoneNumberAsString;

    @AssertTrue(message = "user.legalAge.false")
    private boolean legalAge;

    @URL(message = "user.personalBlog.url")
    private String personalBlog;

    @NotEmpty(message = "user.tags.empty")
    @Size(min = 3, max = 10, message = "user.tags.size")
    private List<String> tags;

    @Valid
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isLegalAge() {
        return legalAge;
    }

    public void setLegalAge(boolean legalAge) {
        this.legalAge = legalAge;
    }

    public String getPhoneNumberAsString() {
        return phoneNumberAsString;
    }

    public void setPhoneNumberAsString(String phoneNumberAsString) {
        this.phoneNumberAsString = phoneNumberAsString;
    }

    public String getPersonalBlog() {
        return personalBlog;
    }

    public void setPersonalBlog(String personalBlog) {
        this.personalBlog = personalBlog;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
