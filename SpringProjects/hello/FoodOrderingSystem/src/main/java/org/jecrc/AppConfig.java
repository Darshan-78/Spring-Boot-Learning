package org.jecrc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public Customer customer() {
        return new Customer(
                101,
                "Rahul Sharma",
                "Jaipur, Rajasthan"
        );
    }

    @Bean
    public FoodItem pizza() {
        return new FoodItem("Pizza", 250);
    }

    @Bean
    public FoodItem burger() {
        return new FoodItem("Burger", 120);
    }

    @Bean
    public FoodItem coldCoffee() {
        return new FoodItem("Cold Coffee", 80);
    }

    @Bean
    public Restaurant restaurant(
            @Qualifier("pizza") FoodItem pizza,
            @Qualifier("burger") FoodItem burger,
            @Qualifier("coldCoffee") FoodItem coldCoffee) {

        return new Restaurant(
                "Foodie's Hub",
                "Jaipur",
                List.of(pizza, burger, coldCoffee)
        );
    }

    @Bean
    public Order order(Customer customer) {
        return new Order(customer);
    }

    @Bean
    public Payment payment(Order order) {
        return new Payment(order);
    }

    @Bean
    public OrderService orderService(
            Restaurant restaurant,
            Order order,
            Payment payment) {

        return new OrderService(restaurant, order, payment);
    }
}