package com.jecrc;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Component
//public class CartService implements InitializingBean {
public class CartService implements BeanNameAware, ApplicationContextAware, DisposableBean {
    private final Map<Integer, String> mp;

    public CartService() {
        mp = new HashMap<>();
        System.out.println("Cart service constructed");
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Initializing Callback");
//        mp.putAll(Map.of(
//                1, "Soumil",
//                2, "Rahul")
//        );
//    }

    @PostConstruct
    public void start() {
        System.out.println("Now bean is ready");
        mp.putAll(Map.of(
                1, "Soumil",
                2, "Rahul")
        );
    }

    public void addToCart() {
        System.out.println("Added to Cart...");
    }

    // check whether the map returns a value or not
    public String getValue(int key) {
        return mp.get(key);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context name is: " + applicationContext.getClass().getSimpleName());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean is destroyed");
    }
}
