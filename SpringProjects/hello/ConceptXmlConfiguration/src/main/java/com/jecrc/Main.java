package com.jecrc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        // Dependency Injection by XML
        OrderService order =
                context.getBean("orderService", OrderService.class);

        order.placeOrder();

        context.close();
    }
}