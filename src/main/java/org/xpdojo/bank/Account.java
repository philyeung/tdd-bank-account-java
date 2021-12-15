package org.xpdojo.bank;

import static org.xpdojo.bank.Transfer.*;

public class Account {

    private int balance;

    private Account() {
    }

    private Account(int balance) {
        this.balance = balance;
    }

    public static Account accountWithZeroBalance() {
        return new Account();
    }

    public static Account accountWithBalanceOf(int balance) {
        return new Account(balance);
    }

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount < 0) {
            throw new IllegalStateException("Cannot deposit negative amount");
        }
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (withdrawalMakesBalanceNegative(amount)) {
            throw new IllegalStateException("Insufficient Funds");
        }
        this.balance -= amount;
    }

    private boolean withdrawalMakesBalanceNegative(int amount) {
        return balance - amount < 0;
    }

    public Transfer send(int amount) {
        var transfer = transferFrom(this);
        transfer.anAmountOf(amount);
        return transfer;
    }
}
