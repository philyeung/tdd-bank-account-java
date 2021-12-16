package org.xpdojo.bank;

import java.util.Objects;

public class Money {
    private final double amount;

    private Money(double amount) {
//        if (amount < 0) {
//            throw new IllegalStateException("Operation results in a negative amount of money");
//        }
        this.amount = amount;
    }

    public static Money amountOf(double amount) {
        return new Money(amount);
    }

    public Money add(Money money) {
        return new Money(amount + money.amount);
    }

    public Money minus(Money money) {
        return new Money(amount - money.amount);
    }

    public boolean isLessThan(Money other) {
        return this.amount < other.amount;
    }

    public boolean isMoreThan(Money other) {
        return this.amount > other.amount;
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
