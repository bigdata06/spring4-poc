package org.spring4.poc.service;

import org.spring4.poc.domain.Account;
import org.spring4.poc.domain.BankingTransaction;
import org.spring4.poc.domain.MoneyTransferException;
import org.spring4.poc.repository.AccountRepository;
import org.spring4.poc.repository.BankingTransactionRepository;

/**
 * Created by Said on 02/03/2015.
 */
public class MoneyTransferServiceImpl implements
        MoneyTransferService {

    private final AccountRepository accountRepository;

    private final BankingTransactionRepository bankingTransactionRepository;

    public MoneyTransferServiceImpl(
            AccountRepository accountRepository,
            BankingTransactionRepository bankingTransactionRepository) {
        this.accountRepository = accountRepository;
        this.bankingTransactionRepository = bankingTransactionRepository;
    }

    public BankingTransaction transfer(
            String fromAccountId, String toAccountId,
            double amount) throws MoneyTransferException {
        Account fromAccount = accountRepository
                .findAccount(fromAccountId);
        Account toAccount = accountRepository
                .findAccount(toAccountId);
        fromAccount.debit(amount);
        toAccount.credit(amount);
        return bankingTransactionRepository
                .createTransferTransaction(
                        fromAccount, toAccount, amount);
    }

}