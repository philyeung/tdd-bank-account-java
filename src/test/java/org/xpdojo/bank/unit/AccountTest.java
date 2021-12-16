package org.xpdojo.bank.unit;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.*;

public class AccountTest {

    @Test
    public void anAccountStartsWithAZeroBalance() {
       var account = accountWithZeroBalance();
       assertThat(account.balance(), is(Money.valueOf(0)));
    }

    @Test
    public void anAccountCanBeOpenedWithANonZeroBalance() {
        var account = accountWithStartingBalanceAt(Money.valueOf(50));
        assertThat(account.balance(), is(Money.valueOf(50)));
    }

    @Test
    public void depositingAnAmountChangesTheBalance() {
        var account = accountWithZeroBalance();
        account.deposit(Money.valueOf(10));
        assertThat(account.balance(), is(Money.valueOf(10)));
    }

    @Test
    public void balanceAccumulatesOnDeposit() {
        var account = accountWithZeroBalance();
        account.deposit(Money.valueOf(5));
        assertThat(account.balance(), is(Money.valueOf(5)));

        account.deposit(Money.valueOf(10));
        assertThat(account.balance(), is(Money.valueOf(15)));
    }

    @Test
    public void cannotDepositNegativeAmount() {
        var account = accountWithZeroBalance();

        assertThrows(IllegalStateException.class, () -> account.deposit(Money.valueOf(-5)));
    }

    @Test
    public void canWithdrawAmount() {
        var account = accountWithStartingBalanceAt(Money.valueOf(10));
        account.withdraw(Money.valueOf(5));
        assertThat(account.balance(), is(Money.valueOf(5)));
    }

    @Test
    public void cannotWithdrawMoreThanAvailableFunds() {
        var account = accountWithStartingBalanceAt(Money.valueOf(15));

        assertThrows(IllegalStateException.class, () -> account.withdraw(Money.valueOf(20)));
        assertThat(account.balance(), is(Money.valueOf(15)));
    }

}
