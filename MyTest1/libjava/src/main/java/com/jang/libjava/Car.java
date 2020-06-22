package com.jang.libjava;

public class Car {
    String company = "Benz";
    String model = "S350";
    String color = "black";
    int maxSpeed = 350;
    int speed;


    Car(int spd) {
        this.speed = spd;
    }
    Car(String company, String model, String color) {
        this.company = company;
        this.model = model;
        this.color = color;
    }

    void print() {
        System.out.println(this.model);
        System.out.println(this.company);
        System.out.println(this.color);
        System.out.println(this.maxSpeed);
        System.out.println(this.speed);
    }
}
