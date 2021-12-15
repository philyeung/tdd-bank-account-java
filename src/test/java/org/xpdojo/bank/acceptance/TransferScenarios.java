package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.accountWithBalanceOf;
import static org.xpdojo.bank.Money.*;

public class TransferScenarios {

    @Test
    public void canTransferMoneyBetweenAccountsIfFundsAvailable() {
        var source = accountWithBalanceOf(amountOf(25));
        var destination = accountWithBalanceOf(amountOf(0));

        source.send(amountOf(25)).to(destination);

        assertThat(source.balance(), is(amountOf(0)));
        assertThat(destination.balance(), is(amountOf(25)));
    }

    @Test
    public void cannotTransferWithInsufficientFunds() {
        var source = accountWithBalanceOf(amountOf(50));
        var destination = accountWithBalanceOf(amountOf(0));

        Exception ex = assertThrows(IllegalStateException.class, () -> source.send(amountOf(60)).to(destination));

        assertThat(ex.getMessage(), is("Insufficient Funds"));

    }


}
