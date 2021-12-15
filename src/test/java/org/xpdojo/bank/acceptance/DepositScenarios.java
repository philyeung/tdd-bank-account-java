package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.xpdojo.bank.Account.accountWithZeroBalance;

public class DepositScenarios {

    @Test
    public void canDepositMoneyToAnAccount() {
        var account = accountWithZeroBalance();
        account.deposit(10);

        assertThat(account.balance(), is(10));

    }
}
