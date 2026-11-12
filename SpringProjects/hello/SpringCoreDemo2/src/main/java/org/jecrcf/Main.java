package org.jecrcf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService2 order = context.getBean(OrderService2.class);
        order.placeOrder();

        User user = context.getBean(User.class);
        System.out.println(user.getName());
        System.out.println(user.getAge());

        ((AnnotationConfigApplicationContext) context).close();
    }
}