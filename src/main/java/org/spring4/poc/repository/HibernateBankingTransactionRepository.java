


package org.spring4.poc.repository;

import org.spring4.poc.domain.Account;
import org.spring4.poc.domain.BankingTransaction;
import org.spring4.poc.domain.TransferTransaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.*;




public class HibernateBankingTransactionRepository implements
        BankingTransactionRepository {

    private HibernateTemplate hibernateTemplate;

    public HibernateBankingTransactionRepository(
            HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public BankingTransaction createTransferTransaction(Account fromAccount,
            Account toAccount, double amount) {
        TransferTransaction txn = new TransferTransaction(fromAccount,
                toAccount, amount, new Date());
        hibernateTemplate.save(txn);
        return txn;
    }

}
