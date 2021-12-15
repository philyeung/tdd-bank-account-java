package org.xpdojo.bank;

public class Transfer {

    private int amount;
    private Account source;

    private Transfer(Account source) {
        this.source = source;
    }

    public static Transfer transferFrom(Account source) {
        return new Transfer(source);
    }

    // bah....a setter...
    public Transfer anAmountOf(int amount) {
        this.amount = amount;
        return this;
    }

    public void to(Account receiver) {
        this.source.withdraw(this.amount);
        receiver.deposit(this.amount);
    }
}
