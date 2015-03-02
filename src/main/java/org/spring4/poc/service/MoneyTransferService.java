package org.spring4.poc.service;

import org.spring4.poc.domain.BankingTransaction;
import org.spring4.poc.domain.MoneyTransferException;

/**
 * Created by Said on 02/03/2015.
 */
public interface MoneyTransferService {

    BankingTransaction transfer(String fromAccountId,
                                String toAccountId, double amount)
            throws MoneyTransferException;

}
