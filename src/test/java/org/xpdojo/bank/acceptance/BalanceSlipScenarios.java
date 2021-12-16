package org.xpdojo.bank.acceptance;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.xpdojo.bank.Account.*;


public class BalanceSlipScenarios {

    @Test
    public void canPrintBalanceSlipWithContainsDateTimeAndBalance() {
        var account = accountWithStartingBalanceAt(Money.valueOf(300));

        var actual = account.printBalanceSlip();
        var date = actual.split(",")[0].split(":")[1].trim();
        var time = actual.split(",")[1].split(": ")[1].trim();
        var balance = actual.split(",")[2].split(":")[1].trim();

        var expected = String.format("Date: %s, Time: %s, Balance: %s", date, time, balance);


        assertThat(actual, is(expected));
    }
}
