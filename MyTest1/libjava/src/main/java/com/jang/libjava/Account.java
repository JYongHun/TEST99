package com.jang.libjava;

public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if ((this.balance + balance) >= 0 && (this.balance + balance) <=1000000) {
            this.balance += balance;
        } else {
            System.out.println("balance의 값은 0이상 1,000,000이하 여만합니다.");
        }
    }
}
