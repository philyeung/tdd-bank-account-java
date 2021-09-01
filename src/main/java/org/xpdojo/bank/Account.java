package org.xpdojo.bank;

public class Account {

    private int balance;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
