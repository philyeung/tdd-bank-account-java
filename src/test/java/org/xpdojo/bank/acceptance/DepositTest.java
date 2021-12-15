package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Account;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.xpdojo.bank.Account.anAccountWithZeroBalance;

public class DepositTest {

    @Test
    public void canDepositMoneyToAnAccount() {
        var account = anAccountWithZeroBalance();
        account.deposit(10);

        assertThat(account.balance(), is(10));

    }
}
