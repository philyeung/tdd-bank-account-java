package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.accountWithBalanceOf;
import static org.xpdojo.bank.Account.accountWithZeroBalance;

public class WithdrawScenarios {

    @Test
    public void canWithDrawFromAnAccount() {
        var account = accountWithBalanceOf(50);
        account.withdraw(20);

        assertThat(account.balance(), is(30));
    }

    @Test
    public void withdrawingMoreThanAvailableBalanceThrowsException() {
        var account = accountWithZeroBalance();

        Exception e = assertThrows(IllegalStateException.class, () -> account.withdraw(10));

        assertThat(e.getMessage(), is("Insufficient Funds"));

    }
}
