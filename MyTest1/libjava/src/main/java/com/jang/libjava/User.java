package com.jang.libjava;

public class User {
    private String email;
    private String passwd;
    public String nickname;

    User(String nn) {
        nickname = nn;
    }


    void setEmail(String a){
        if(a.contains("@")) {
            email = a;
        }
    }


    void setPasswd(String a, String b) {
        boolean qq = true;
        if(a == b && a.length() <=12 && a.length() >= 6) {
            passwd = a;
        } else {
            qq = false;
        }





    }

    void print() {
        System.out.println("email : " + email);
        System.out.println("password : " + passwd);
        System.out.println("nickname : " + nickname);
    }
}
