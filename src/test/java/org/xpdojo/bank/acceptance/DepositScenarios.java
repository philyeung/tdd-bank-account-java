package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.xpdojo.bank.Account.accountWithZeroBalance;
import static org.xpdojo.bank.Money.*;

public class DepositScenarios {

    @Test
    public void canDepositMoneyToAnAccount() {
        var account = accountWithZeroBalance();
        account.deposit(amountOf(10));

        assertThat(account.balance(), is(amountOf(10)));

    }
}
