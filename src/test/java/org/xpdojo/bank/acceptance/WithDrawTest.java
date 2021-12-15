package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Account;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.anAccountWithBalanceOf;
import static org.xpdojo.bank.Account.anAccountWithZeroBalance;

public class WithDrawTest {

    @Test
    public void canWithDrawFromAnAccount() {
        var account = anAccountWithBalanceOf(50);
        account.withdraw(20);

        assertThat(account.balance(), is(30));
    }

    @Test
    public void withdrawingMoreThanAvailableBalanceThrowsException() {
        var account = anAccountWithZeroBalance();

        Exception e = assertThrows(IllegalStateException.class, () -> account.withdraw(10));

        assertThat(e.getMessage(), is("Insufficient Funds"));

    }
}
