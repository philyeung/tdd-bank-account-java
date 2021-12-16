package org.xpdojo.bank;

import static org.xpdojo.bank.Money.*;
import static org.xpdojo.bank.Transfer.*;

public class Account {

    private Money balance;

    private Account() {
        this.balance = amountOf(0);
    }

    private Account(Money balance) {
        this.balance = balance;
    }

    public static Account accountWithZeroBalance() {
        return new Account();
    }

    public static Account accountWithBalanceOf(Money balance) {
        return new Account(balance);
    }

    public Money balance() {
        return balance;
    }

    public void deposit(Money amount) {
        if (amount.isLessThan(amountOf(0))) {
            throw new IllegalStateException("Cannot deposit a negative amount");
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(Money amount) {
        if (withdrawalMakesBalanceNegative(amount)) {
            throw new IllegalStateException("Insufficient Funds");
        }

        this.balance = this.balance.minus(amount);
    }

    private boolean withdrawalMakesBalanceNegative(Money amount) {
        return this.balance.minus(amount).isLessThan(amountOf(0));
    }

    public Transfer send(Money amount) {
        if (withdrawalMakesBalanceNegative(amount)) {
            throw new IllegalStateException("Insufficient Funds");
        }
        var transfer = transferFrom(this);
        transfer.anAmountOf(amount);
        return transfer;
    }
}
