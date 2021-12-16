package org.xpdojo.bank;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.xpdojo.bank.Account.*;
import static org.xpdojo.bank.Statement.statementFor;

public class StatementTest {

    private final String newLine = System.getProperty("line.separator");

    @Test
    public void canPrintStatementWithDeposits() {
        var account = accountWithZeroBalance();
        account.deposit(Money.valueOf(30));
        account.deposit(Money.valueOf(20));

        var depositReport = statementFor(account);
        var actual = depositReport.print();

        var expected = new StringBuilder()
                .append("Statement")
                .append(newLine)
                .append("Deposit of 30")
                .append(newLine)
                .append("Deposit of 20")
                .toString();

        assertThat(actual, is(expected));
    }

    @Test
    public void canPrintStatementWithWithdrawels() {

    }

    @Test
    public void canPrintStatementWithTransactions() {

    }
}
