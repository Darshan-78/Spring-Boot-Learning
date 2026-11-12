package com.SpringAppDemo.jecrc;

public class Alien {

    private Laptop laptop;

    public Alien(Laptop laptop) {
        this.laptop = laptop;
        System.out.println("Alien Object created");
    }

    public void code() {
        laptop.code1();
        System.out.println("Alien is coding");
    }
}
