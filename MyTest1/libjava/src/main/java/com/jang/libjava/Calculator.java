package com.jang.libjava;

public class Calculator {

    //method
    void powerOn() {
        System.out.println("POWER ON");
    }

    //plus /개의 정수를 입력 받아서 합을 리턴하는 메소드드
    int plus(int a,int b,int c) {
        int result = a+b+c;
        return result;
    }

    //divide 두정수를 입력받아서 더블형을 리턴하는 함수
    double divide(int a, int b) {
        double result = (double)a/b;
        return result;
    }
}
