package com.jang.libjava;

public class MemberService {
    boolean login(String id, String pw){
        if(id.equals("hong") && pw.equals("12345")) {
            System.out.println("로그인 되었습니다.");
            return true;
        }
        return false;
    }

    void logout(String id) {
        System.out.println("로그아웃 되었습니다.");
    }
}
