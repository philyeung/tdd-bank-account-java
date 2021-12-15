package org.xpdojo.bank.unit;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.*;
import static org.xpdojo.bank.Money.*;
import static org.xpdojo.bank.Transfer.transferFrom;

public class TransferTest {

    @Test
    public void canTransferFromSenderToReceiver() {
        var source = accountWithBalanceOf(amountOf(50));
        var destination = accountWithZeroBalance();

        transferFrom(source).anAmountOf(amountOf(20)).to(destination);

        assertThat(source.balance(), is(amountOf(30)));
        assertThat(destination.balance(), is(amountOf(20)));
    }
}
