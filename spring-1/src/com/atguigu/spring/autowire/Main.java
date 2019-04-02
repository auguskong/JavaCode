package com.atguigu.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Date 3/16/19 17:05
 * @Type:
 * @Algorithm:
 */

public class Main {
    public static void main (String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-autowire.xml");

        Person person = (Person) ctx.getBean("person");

        System.out.println(person);
    }
}
