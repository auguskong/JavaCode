package com.atguigu.spring.beans;

/**
 * @Description:
 * @Date 3/16/19 16:05
 * @Type:
 * @Algorithm:
 */

public class Car {
    private String    brand;
    private String    city;
    private int       price;
    private double    maxSpeed;

    public Car() {
    }

    public Car(String brand, String city, int price) {
        this.brand = brand;
        this.city = city;
        this.price = price;
    }

    public Car(String brand, String city, double maxSpeed) {
        this.brand = brand;
        this.city = city;
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getCity() {
        return city;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
