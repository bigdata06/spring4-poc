package org.spring4.poc.repository;

import org.spring4.poc.domain.Account;
import org.spring4.poc.domain.BankingTransaction;

/**
 * Created by Said on 02/03/2015.
 */
public interface BankingTransactionRepository {

    BankingTransaction createTransferTransaction(
            Account fromAccount, Account toAccount,
            double amount);

}
