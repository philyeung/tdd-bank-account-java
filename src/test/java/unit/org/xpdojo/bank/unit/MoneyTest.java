package unit.org.xpdojo.bank.unit;

import org.junit.jupiter.api.Test;
import org.xpdojo.bank.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTest {

    @Test
    public void canMakeMoneyMoneyMakeMoneyMoney() {
        var money = Money.valueOf(15);

        assertEquals(money, Money.valueOf(15));
    }

    @Test
    public void canAddMoneys() {
        var money = Money.valueOf(10);
        var moreMoneys = Money.valueOf(20);

        var allMyMoneys = money.add(moreMoneys);

        assertEquals(allMyMoneys, Money.valueOf(30));
    }

    @Test
    public void canTakePreciousMoneysAway() {
       var money = Money.valueOf(100);
       var moreMoneys = Money.valueOf(50);

       var allMyMoneys = money.minus(moreMoneys);

       assertEquals(allMyMoneys, Money.valueOf(50));
    }

    @Test
    public void canCompareMoney() {
        var smallerAmount = Money.valueOf(1);
        var largerAmount = Money.valueOf(10);
        var equalLargerAmount = Money.valueOf(10);

        assertTrue(smallerAmount.isLessThan(largerAmount));
        assertTrue(largerAmount.isMoreThan(smallerAmount));
        assertEquals(largerAmount, equalLargerAmount);
    }
}
