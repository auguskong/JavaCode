package com.atguigu.spring.beans;

import com.atguigu.spring.beans.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Date 3/16/19 14:32
 * @Type:
 * @Algorithm:
 */

public class Main {

    public static void main(String[] args) {

//        // 创建HelloWorld 的一个对象
//        HelloWorld helloWorld = new HelloWorld();
//        // 为 name 属性赋值
//        helloWorld.setName("kong");
//        // 调用hello 方法
//        helloWorld.hello();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");

        helloWorld.hello();

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        Car car2 = (Car) ctx.getBean("car2");
        System.out.println(car2);
    }
}
