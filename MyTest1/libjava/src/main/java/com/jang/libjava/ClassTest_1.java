package com.jang.libjava;

public class ClassTest_1 {
    private String name;
    private int salary;
    public ClassTest_1() {

    }


    ClassTest_1(String n,int s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void getInformation() {
        System.out.println("이름 : " + name);
    }

    public void prn() {
        System.out.println("수퍼클래스");
    }
} // end classTest_1


