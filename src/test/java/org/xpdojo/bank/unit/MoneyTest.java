package org.xpdojo.bank.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.xpdojo.bank.Money.amountOf;

public class MoneyTest {

    @Test
    public void canMakeTheMoneys() {
        var money = amountOf(15);

        assertEquals(money, amountOf(15));
    }

    @Test
    public void canAddMoneys() {
        var money = amountOf(10);
        var moreMoneys = amountOf(20);

        var allMyMoneys = money.add(moreMoneys);

        assertEquals(allMyMoneys, amountOf(30));
    }

    @Test
    public void canTakePreciousMoneysAway() {
       var money = amountOf(100);
       var moreMoneys = amountOf(50);

       var allMyMoneys = money.minus(moreMoneys);

       assertEquals(allMyMoneys,amountOf(50));
    }

    @Test
    public void canCompareMoney() {
        var smallerAmount = amountOf(1);
        var largerAmount = amountOf(10);
        var equalLargerAmount = amountOf(10);

        assertTrue(smallerAmount.isLessThan(largerAmount));
        assertTrue(largerAmount.isMoreThan(smallerAmount));
        assertTrue(equalLargerAmount.equals(largerAmount));
    }
}
