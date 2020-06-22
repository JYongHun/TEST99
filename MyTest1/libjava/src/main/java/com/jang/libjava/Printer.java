package com.jang.libjava;

public class Printer {

    void println(int a) {
        System.out.println(a);
    }

    void println(float a) {
        System.out.println(a);
    }

    void println(String a) {
        System.out.println(a);
    }

    void println(boolean a) {
        if (a == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

//오버로딩 똑같은 함수이름으로 다른 파라미터를 사용
//오버라이딩 부모의 함수를 받아서 쓰되 내용을 변경해서 사용한다.
