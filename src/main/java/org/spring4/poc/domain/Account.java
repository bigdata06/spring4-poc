package org.spring4.poc.domain;

/**
 * Created by said on 02/03/2015.
 */
public class Account {

    // For Hibernate
    private int id;

    private double balance;

    private OverdraftPolicy overdraftPolicy;

    private String accountId;

    // For Hibernate
    Account() {
        // for mocking
    }

    public Account(String accountId,
                   double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.overdraftPolicy = new NoOverdraftAllowed();
    }

    public void debit(double amount)
            throws MoneyTransferException {
        assert amount > 0;
        double originalBalance = balance;
        double newBalance = balance - amount;
        overdraftPolicy.beforeDebitCheck(this,
                originalBalance, newBalance);
        balance = newBalance;
        overdraftPolicy.afterDebitCheck(this,
                originalBalance, newBalance);
    }

    public void credit(double amount) {
        assert amount > 0;
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }
}

