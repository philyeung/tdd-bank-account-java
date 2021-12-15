package org.xpdojo.bank;

public class Account {

    private int balance;

    private Account() {
    }

    private Account(int balance) {
        this.balance = balance;
    }


    public static Account anAccountWithZeroBalance() {
        return new Account();
    }

    public static Account anAccountWithBalanceOf(int balance) {
        return new Account(50);

    }

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount < 0) {
            // Throw exception
        }
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (withdrawalMakesBalanceNegative(amount)) {
            // throw exception
        }
        this.balance -= amount;
    }

    private boolean withdrawalMakesBalanceNegative(int amount) {
        return balance - amount < 0;
    }

    public Transfer send(int i) {
        return new Transfer();
    }
}
