package org.xpdojo.bank.unit;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.xpdojo.bank.Account.*;
import static org.xpdojo.bank.Transfer.transferFrom;

public class TransferTest {

    @Test
    public void canTransferFromSenderToReceiver() {
        var source = accountWithStartingBalanceAt(Money.valueOf(50));
        var destination = accountWithZeroBalance();
        var twentyPounds = Money.valueOf(20) ;

        transferFrom(source).anAmountOf(twentyPounds).to(destination);

        assertThat(source.balance(), is(Money.valueOf(30)));
        assertThat(destination.balance(), is(Money.valueOf(20)));
    }
}
