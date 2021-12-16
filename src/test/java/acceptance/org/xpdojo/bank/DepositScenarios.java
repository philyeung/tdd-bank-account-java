package acceptance.org.xpdojo.bank;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.xpdojo.bank.Account.accountWithZeroBalance;

public class DepositScenarios {

    @Test
    public void canDepositMoneyToAnAccount() {
        var account = accountWithZeroBalance();
        account.deposit(Money.valueOf(10));

        assertThat(account.balance(), is(Money.valueOf(10)));
    }

    @Test
    public void canDepositMoneyToAnAccountAndBalanceAccumalates() {
        var account = accountWithZeroBalance();
        account.deposit(Money.valueOf(10));
        account.deposit(Money.valueOf(20));

        assertThat(account.balance(), is(Money.valueOf(30)));
    }
}
