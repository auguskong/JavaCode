package com.atguigu.spring.beans;

/**
 * @Description:
 * @Date 3/16/19 14:30
 * @Type:
 * @Algorithm:
 */

public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello: " + name);
    }
}
