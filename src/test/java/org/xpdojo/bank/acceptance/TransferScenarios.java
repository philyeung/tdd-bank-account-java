package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.accountWithBalanceOf;

public class TransferScenarios {

    @Test
    public void canTransferMoneyBetweenAccountsIfFundsAvailable() {
        var source = accountWithBalanceOf(50);
        var destination = accountWithBalanceOf(0);

        source.send(25).to(destination);

        assertThat(source.balance(), is(25));
        assertThat(destination.balance(), is(25));
    }

    @Test
    public void cannotTransferWithInsufficientFunds() {
        var source = accountWithBalanceOf(50);
        var destination = accountWithBalanceOf(0);

        Exception ex = assertThrows(IllegalStateException.class, () -> source.send(60).to(destination));

        assertThat(ex.getMessage(), is("Insufficient Funds"));

    }


}
