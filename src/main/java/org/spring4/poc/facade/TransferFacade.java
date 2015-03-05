
package org.spring4.poc.facade;


import org.spring4.poc.domain.Account;
import org.spring4.poc.domain.BankingTransaction;
import org.spring4.poc.domain.MoneyTransferException;

public interface TransferFacade {

    public Account createAccount(String accountId, double initialBalance);
    
    public double getBalance(String accountId);

    public BankingTransaction transfer(
            String fromAccountId, String toAccountId,
            double amount)
            throws MoneyTransferException;

}
