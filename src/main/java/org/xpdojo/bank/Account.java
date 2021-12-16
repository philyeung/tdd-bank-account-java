package org.xpdojo.bank;

import static org.xpdojo.bank.ErrorMessages.*;
import static org.xpdojo.bank.Money.*;
import static org.xpdojo.bank.Transfer.*;

public class Account {

    private Money balance;

    private Account() {
        this.balance = valueOf(0);
    }

    private Account(Money balance) {
        this.balance = balance;
    }

    public static Account accountWithZeroBalance() {
        return new Account();
    }

    public static Account accountWithStartingBalanceAt(Money balance) {
        return new Account(balance);
    }

    public Money balance() {
        return balance;
    }

    public void deposit(Money amount) {
        if (amount.isLessThan(valueOf(0))) {
            throw new IllegalStateException(CANNOT_DEPOSIT_NEGATIVE_AMOUNT);
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(Money amount) {
        if (withdrawalMakesBalanceNegative(amount)) {
            throw new IllegalStateException(INSUFFICIENT_FUNDS);
        }

        this.balance = this.balance.minus(amount);
    }

    public Transfer send(Money amount) {
        if (withdrawalMakesBalanceNegative(amount)) {
            throw new IllegalStateException(INSUFFICIENT_FUNDS);
        }
        var transfer = transferFrom(this);
        transfer.anAmountOf(amount);
        return transfer;
    }

    private boolean withdrawalMakesBalanceNegative(Money amount) {
        return this.balance.minus(amount).isLessThan(valueOf(0));
    }
}
