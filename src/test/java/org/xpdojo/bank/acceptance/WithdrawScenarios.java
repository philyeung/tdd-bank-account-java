package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.accountWithBalanceOf;
import static org.xpdojo.bank.Account.accountWithZeroBalance;
import static org.xpdojo.bank.ErrorMessages.INSUFFICIENT_FUNDS;
import static org.xpdojo.bank.Money.*;

public class WithdrawScenarios {

    @Test
    public void canWithDrawFromAnAccount() {
        var account = accountWithBalanceOf(amountOf(50));
        account.withdraw(amountOf(20));

        assertThat(account.balance(), is(amountOf(30)));
    }

    @Test
    public void withdrawingMoreThanAvailableBalanceThrowsException() {
        var account = accountWithZeroBalance();

        Exception e = assertThrows(IllegalStateException.class, () -> account.withdraw(amountOf(10)));

        assertThat(e.getMessage(), is(INSUFFICIENT_FUNDS));

    }
}
