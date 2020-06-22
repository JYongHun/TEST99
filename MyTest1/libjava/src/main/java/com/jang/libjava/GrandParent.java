package com.jang.libjava;

public class GrandParent {
    protected String name;
    protected int age;


    ///생성자 GrandParent class
    void printInfo() {
        System.out.println("name : " + name);
        System.out.println("age : " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
