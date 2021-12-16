package org.xpdojo.bank;

public class Transfer {

    private final Account source;
    private Money amount;

    private Transfer(Account source) {
        this.source = source;
    }

    public static Transfer transferFrom(Account source) {
        return new Transfer(source);
    }

    // bah....a setter...
    public Transfer anAmountOf(Money amount) {
        this.amount = amount;
        return this;
    }

    public void to(Account receiver) {
        this.source.withdraw(this.amount);
        receiver.deposit(this.amount);
    }
}
