package org.xpdojo.bank;

public class Account {

    private int balance;

    public boolean deposit(int amount) {
        if (amount < 0) {
           return false;
        }
        this.balance += amount;
        return true;
    }

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {
        this.balance -= amount;
        return true;
    }
}
