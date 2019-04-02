package com.atguigu.spring.autowire;

/**
 * @Description:
 * @Date 3/16/19 16:58
 * @Type:
 * @Algorithm:
 */

public class Person {

    private String name;
    private Address address;
    private Car car;

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Car getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", car=" + car +
                '}';
    }
}
