package com.danielme.blog.validation.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Address {

    @NotNull(message = "address.line1.empty")
    @Size(min = 5, max = 50, message = "address.line1.size")
    private String line1;

    private String line2;

    @NotNull(message = "address.zipcode.empty")
    @Size(min = 2, max = 10, message = "address.zipcode.size")
    private String zipCode;

    @NotNull(message = "address.countrycode.empty")
    @Size(min = 2, max = 2, message = "address.countrycode.size")
    private String countryCode;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
