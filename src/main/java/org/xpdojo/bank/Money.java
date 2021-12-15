package org.xpdojo.bank;

import java.util.Objects;

public class Money {
    private final double amount;

    private Money(double amount) {
        this.amount = amount;
    }

    public static Money amountOf(double amount) {
        return new Money(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money = : " + amount;
    }
}
