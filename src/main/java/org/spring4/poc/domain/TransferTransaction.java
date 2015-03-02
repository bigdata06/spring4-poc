package org.spring4.poc.domain;

import java.util.Date;

/**
 * Created by Said on 02/03/2015.
 */
public class TransferTransaction implements
        BankingTransaction {

    // For Hibernate
    private int id = -1;

    private Account fromAccount;
    private Account toAccount;
    private double amount;
    private Date date;

    // For Hibernate

    TransferTransaction() {
    }

    public TransferTransaction(Account fromAccount, Account toAccount, double amount, Date date) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }
}
