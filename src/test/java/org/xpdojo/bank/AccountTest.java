package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void anAccountStartsWithAZeroBalance() {
       Account account = new Account();
       assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void depositingAnAmountChangesTheBalance() {
        Account account = new Account();
        account.deposit(10);
        assertThat(account.getBalance()).isEqualTo(10);
    }

    @Test
    public void balanceAccumulatesOnDeposit() {
        Account account = new Account();
        account.deposit(5);
        assertThat(account.getBalance()).isEqualTo(5);
        account.deposit(10);
        assertThat(account.getBalance()).isEqualTo(15);
    }

    @Test
    public void cannotDepositNegativeAmount() {
        Account account = new Account();
        assertThat(account.deposit(-5)).isEqualTo(false);
    }
}
