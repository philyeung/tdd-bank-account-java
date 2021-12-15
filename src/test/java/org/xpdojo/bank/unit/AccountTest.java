package org.xpdojo.bank.unit;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.*;
import static org.xpdojo.bank.Money.*;

public class AccountTest {

    @Test
    public void anAccountStartsWithAZeroBalance() {
       var account = accountWithZeroBalance();
       assertThat(account.balance(), is(amountOf(0)));
    }

    @Test
    public void anAccountCanBeOpenedWithANonZeroBalance() {
        var account = accountWithBalanceOf(amountOf(50));
        assertThat(account.balance(), is(amountOf(50)));
    }

    @Test
    public void depositingAnAmountChangesTheBalance() {
        var account = accountWithZeroBalance();
        account.deposit(amountOf(10));
        assertThat(account.balance(), is(amountOf(10)));
    }

    @Test
    public void balanceAccumulatesOnDeposit() {
        var account = accountWithZeroBalance();
        account.deposit(amountOf(5));
        assertThat(account.balance(), is(amountOf(5)));

        account.deposit(amountOf(10));
        assertThat(account.balance(), is(amountOf(15)));
    }

    @Test
    public void cannotDepositNegativeAmount() {
        var account = accountWithZeroBalance();

        assertThrows(IllegalStateException.class, () -> account.deposit(amountOf(-5)));
    }

    @Test
    public void canWithdrawAmount() {
        var account = accountWithBalanceOf(amountOf(10));
        account.withdraw(amountOf(5));
        assertThat(account.balance(), is(amountOf(5)));
    }

    @Test
    public void cannotWithdrawMoreThanAvailableFunds() {
        var account = accountWithBalanceOf(amountOf(15));

        assertThrows(IllegalStateException.class, () -> account.withdraw(amountOf(20)));
        assertThat(account.balance(), is(amountOf(15)));
    }

}
