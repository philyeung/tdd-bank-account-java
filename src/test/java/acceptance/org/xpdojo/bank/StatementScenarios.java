package acceptance.org.xpdojo.bank;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;
import org.xpdojo.bank.Statement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.xpdojo.bank.Account.accountWithStartingBalanceAt;
import static org.xpdojo.bank.Account.accountWithZeroBalance;
import static org.xpdojo.bank.Statement.*;


public class StatementScenarios {

    private final String newLine = System.getProperty("line.separator");

    @Test
    public void canPrintStatementOfAccountActivity() {
        var account = accountWithStartingBalanceAt(Money.valueOf(20));
        String newLine = System.getProperty("line.separator");

        account.deposit(Money.valueOf(30));
        account.deposit(Money.valueOf(50));
        account.withdraw(Money.valueOf(20));
        account.send(Money.valueOf(50)).to(accountWithZeroBalance());

        var statement = statementFor(account);
        var actual = statement.print();

        var expected = new StringBuilder()
                .append("Statement")
                .append(newLine)
                .append("Deposit of 30")
                .append(newLine)
                .append("Deposit of 30")
                .append(newLine)
                .append("Withdrawal of 30")
                .append(newLine)
                .append("Transfer of 50")
                .toString();

        assertThat(actual, is(expected));


    }

}
