package com.jang.libjava;

public class Parent extends GrandParent {

    protected String job;

    Parent(){
        System.out.println("Parent CLASS");
    }


    void printInfo(){
        System.out.println("naMe : " + name);
        System.out.println("AgE : " + age);
        System.out.println("job : " + job);
    }
}
