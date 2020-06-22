package com.jang.libjava;

public class Professor extends Person{
    private String[] subject;

    public void print_subject() {
        System.out.println(name + "s subjects");
        for(int i=0;i<subject.length;i++) {
            System.out.println("Subject : " + subject[i]);
        }
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }
}
