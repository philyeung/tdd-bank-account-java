package org.xpdojo.bank;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.xpdojo.bank.Account.*;
import static org.xpdojo.bank.Transfer.transferFrom;

public class TransferTest {

    @Test
    public void canTransferMoneyBetweenAccounts() {
        var source = accountWithStartingBalanceAt(Money.valueOf(50));
        var destination = accountWithZeroBalance();
        var twentyShillings = Money.valueOf(20) ;

        transferFrom(source).anAmountOf(twentyShillings).to(destination);

        assertThat(source.balance(), is(Money.valueOf(30)));
        assertThat(destination.balance(), is(Money.valueOf(20)));
    }
}
