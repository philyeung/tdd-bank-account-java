package org.xpdojo.bank;

public class Account {

    private int balance;

    public int getBalance() {
        return balance;
    }

    public boolean deposit(int amount) {
        if (amount < 0) {
           return false;
        }
        this.balance += amount;
        return true;
    }

    public boolean withdraw(int amount) {
        if (withdrawalMakesBalanceNegative(amount)) {
            return false;
        }

        this.balance -= amount;
        return true;
    }

    private boolean withdrawalMakesBalanceNegative(int amount) {
        return balance - amount < 0;
    }
}
