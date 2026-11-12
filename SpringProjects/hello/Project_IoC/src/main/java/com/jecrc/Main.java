package com.jecrc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        orderService orderService = context.getBean(orderService.class);

        orderService.placeOrder();

        context.close();
    }
}