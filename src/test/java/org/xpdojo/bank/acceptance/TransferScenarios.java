package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.accountWithStartingBalanceOf;
import static org.xpdojo.bank.ErrorMessages.INSUFFICIENT_FUNDS;

public class TransferScenarios {

    @Test
    public void canTransferMoneyBetweenAccountsIfFundsAvailable() {
        var source = accountWithStartingBalanceOf(Money.valueOf(25));
        var destination = accountWithStartingBalanceOf(Money.valueOf(0));

        source.send(Money.valueOf(25)).to(destination);

        assertThat(source.balance(), is(Money.valueOf(0)));
        assertThat(destination.balance(), is(Money.valueOf(25)));
    }

    @Test
    public void cannotTransferWithInsufficientFunds() {
        var source = accountWithStartingBalanceOf(Money.valueOf(50));
        var destination = accountWithStartingBalanceOf(Money.valueOf(0));

        Exception ex = assertThrows(IllegalStateException.class, () -> source.send(Money.valueOf(60)).to(destination));

        assertThat(ex.getMessage(), is(INSUFFICIENT_FUNDS));

    }


}
