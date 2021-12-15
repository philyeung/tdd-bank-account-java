package org.xpdojo.bank.unit;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.xpdojo.bank.Account.*;
import static org.xpdojo.bank.Money.amountOf;

public class MoneyTest {

    @Test
    public void canMakeTheMoneys() {
        var money = amountOf(15);

        assertEquals(money, amountOf(15));
    }
}
