package org.jecrcf;

import org.jecrcf.payment.cardPayment;
import org.jecrcf.payment.paymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.jecrcf")
public class AppConfig {

    @Bean
    public User createUser() {
        return new User("Raj", 22);
    }

    @Bean
    public paymentService createPayment() {
        return new cardPayment();
    }

    @Bean
    public OrderService2 createOrderService(paymentService service) {
        OrderService2 order = new OrderService2();
        order.setService(service);
        return order;
    }
}