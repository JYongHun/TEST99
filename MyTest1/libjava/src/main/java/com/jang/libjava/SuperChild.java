package com.jang.libjava;

public class SuperChild extends SuperParent{
    private int a = 20;

    @Override
    public void print() {
        System.out.println("Super Child print()");
        System.out.println("a = " + a);
        System.out.println();
    }

    void superCall(){
        System.out.println("SUper.a = " + super.a);
        super.print();
    }
}

//super
