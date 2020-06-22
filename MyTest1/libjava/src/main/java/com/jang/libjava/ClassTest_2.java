package com.jang.libjava;

public class ClassTest_2 extends ClassTest_1 {
    String department;




    ClassTest_2(String name, int money, String dp) {
        super(name,money);
        this.department = dp;

    }

    int a = 12;

    @Override
    public void getInformation(){
        super.getInformation();
        System.out.println(" 부서:"+department);
        
    }
}
