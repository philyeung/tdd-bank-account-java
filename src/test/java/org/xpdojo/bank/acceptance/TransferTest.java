package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Account;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.anAccountWithBalanceOf;

public class TransferTest {

    @Test
    public void canTransferMoneyBetweenAccountsIfFundsAvailable() {
        var sender = anAccountWithBalanceOf(50);
        var receiver = anAccountWithBalanceOf(0);

        sender.send(25).to(receiver);

        assertThat(sender.balance(), is(25));
        assertThat(receiver.balance(), is(25));
    }

    @Test
    public void cannotTransferWithInsufficientFunds() {
        var sender = anAccountWithBalanceOf(50);
        var receiver = anAccountWithBalanceOf(0);

        Exception ex = assertThrows(IllegalStateException.class, () -> sender.send(60).to(receiver));

        assertThat(ex.getMessage(), is("Insufficient Funds"));

    }


}
