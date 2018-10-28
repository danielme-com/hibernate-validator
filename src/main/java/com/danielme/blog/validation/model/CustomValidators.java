package com.danielme.blog.validation.model;

import com.danielme.blog.validation.custom.Dummy;
import com.danielme.blog.validation.custom.SameValue;
import com.danielme.blog.validation.custom.StringRange;

@SameValue(field1 = "field1", field2 = "field2")
public class CustomValidators {

    @Dummy
    private String dummy;

    @StringRange(values = { "Spain", "Mexico" })
    private String country;

    private String field1;

    private String field2;

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

}
