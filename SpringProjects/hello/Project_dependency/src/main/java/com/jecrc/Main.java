package com.jecrc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        orderService service = context.getBean(orderService.class);

        service.placeOrder();

        context.close();
    }
}