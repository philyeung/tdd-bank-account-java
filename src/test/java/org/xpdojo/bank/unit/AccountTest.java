package org.xpdojo.bank.unit;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.*;

public class AccountTest {

    @Test
    public void anAccountStartsWithAZeroBalance() {
       var account = accountWithZeroBalance();
       assertThat(account.balance(), is(0));
    }

    @Test
    public void anAccountCanBeOpenedWithANonZeroBalance() {
        var account = accountWithBalanceOf(50);
        assertThat(account.balance(), is(50));
    }

    @Test
    public void depositingAnAmountChangesTheBalance() {
        var account = accountWithZeroBalance();
        account.deposit(10);
        assertThat(account.balance(), is(10));
    }

    @Test
    public void balanceAccumulatesOnDeposit() {
        var account = accountWithZeroBalance();
        account.deposit(5);
        assertThat(account.balance(), is(5));

        account.deposit(10);
        assertThat(account.balance(), is(15));
    }

    @Test
    public void cannotDepositNegativeAmount() {
        var account = accountWithZeroBalance();

        assertThrows(IllegalStateException.class, () -> account.deposit(-5));
    }

    @Test
    public void canWithdrawAmount() {
        var account = accountWithBalanceOf(10);
        account.withdraw(5);
        assertThat(account.balance(), is(5));
    }

    @Test
    public void cannotWithdrawMoreThanAvailableFunds() {
        var account = accountWithBalanceOf(15);

        assertThrows(IllegalStateException.class, () -> account.withdraw(20));
        assertThat(account.balance(), is(15));
    }

}
