package org.xpdojo.bank;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThrows;
import static org.xpdojo.bank.Account.accountWithStartingBalanceAt;
import static org.xpdojo.bank.Account.accountWithZeroBalance;
import static org.xpdojo.bank.ErrorMessages.INSUFFICIENT_FUNDS;

public class WithdrawScenarios {

    @Test
    public void canWithDrawFromAnAccount() {
        var account = accountWithStartingBalanceAt(Money.valueOf(50));
        account.withdraw(Money.valueOf(20));

        assertThat(account.balance(), is(Money.valueOf(30)));
    }

    @Test
    public void withdrawingMoreThanAvailableBalanceThrowsException() {
        var account = accountWithZeroBalance();

        Exception e = assertThrows(IllegalStateException.class, () -> account.withdraw(Money.valueOf(10)));

        assertThat(e.getMessage(), is(INSUFFICIENT_FUNDS));

    }
}
