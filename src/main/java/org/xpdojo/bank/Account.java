package org.xpdojo.bank;

public class Account {

    int balance;

    public void deposit(int amount) {
        this.balance = amount;
    }

    public int getBalance() {
        return balance;
    }
}
