package org.jecrcUniversity.sample;

import org.springframework.stereotype.Component;

@Component
public class B {

    private final A a;

    public B(A a) {
        this.a = a;
        System.out.println("B created");
    }
}
