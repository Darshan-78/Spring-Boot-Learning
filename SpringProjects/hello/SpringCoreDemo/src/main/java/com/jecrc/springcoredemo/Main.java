package com.jecrc.springcoredemo;

import com.jecrc.springcoredemo.payment.PaymentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            System.out.println("Hello Spring!");

            OrderService order = context.getBean(OrderService.class);
            order.placeOrder();

            System.out.println("--- User Details ---");
            User user = context.getBean(User.class);
            System.out.println(user.getName());
            System.out.println(user.getAge());

            System.out.println("--- Cart Service ---");
            CartService cart = context.getBean(CartService.class);
            cart.addToCart();

            System.out.println("--- UPI Payment ---");
            PaymentService upi =
                    context.getBean("upiPayment", PaymentService.class);
            upi.pay();
        }
    }
}