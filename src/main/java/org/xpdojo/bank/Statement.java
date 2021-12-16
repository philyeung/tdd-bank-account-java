package org.xpdojo.bank;

public class Statement {

    public static Statement statementFor(Account account) {
        return new Statement();
    }

    public String print() {
        return "Hi";
    }
}
