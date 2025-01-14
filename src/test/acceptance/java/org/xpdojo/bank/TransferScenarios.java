package org.xpdojo.bank;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThrows;
import static org.xpdojo.bank.Account.accountWithStartingBalanceAt;
import static org.xpdojo.bank.ErrorMessages.INSUFFICIENT_FUNDS;

public class TransferScenarios {

    @Test
    public void canTransferMoneyBetweenAccountsIfFundsAvailable() {
        var source = accountWithStartingBalanceAt(Money.valueOf(25));
        var destination = accountWithStartingBalanceAt(Money.valueOf(0));

        source.send(Money.valueOf(25)).to(destination);

        assertThat(source.balance(), is(Money.valueOf(0)));
        assertThat(destination.balance(), is(Money.valueOf(25)));
    }

    @Test
    public void cannotTransferWithInsufficientFunds() {
        var source = accountWithStartingBalanceAt(Money.valueOf(50));
        var destination = accountWithStartingBalanceAt(Money.valueOf(0));

        Exception ex = assertThrows(IllegalStateException.class, () -> source.send(Money.valueOf(60)).to(destination));

        assertThat(ex.getMessage(), is(INSUFFICIENT_FUNDS));

    }


}
