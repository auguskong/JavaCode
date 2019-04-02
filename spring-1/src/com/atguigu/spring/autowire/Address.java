package com.atguigu.spring.autowire;

/**
 * @Description:
 * @Date 3/16/19 16:59
 * @Type:
 * @Algorithm:
 */

public class Address {

    private String city;
    private String street;

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
