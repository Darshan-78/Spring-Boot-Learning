package com.jecrc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello...");

        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // initialization starts in main.
        CartService cart = context.getBean(CartService.class);
        // cart.addToCart();
        // System.out.println(cart.getValue(1));
        // System.out.println(cart.getValue(2));

        cart.addToCart();
        System.out.println(cart.getValue(1));
        System.out.println(cart.getValue(2));

        context.close();
    }
}