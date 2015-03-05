
 


package org.spring4.poc.facade;


import org.spring4.poc.domain.Account;
import org.spring4.poc.domain.BankingTransaction;
import org.spring4.poc.domain.MoneyTransferException;
import org.spring4.poc.repository.AccountRepository;
import org.spring4.poc.service.MoneyTransferService;

public class TransferFacadeImpl implements TransferFacade {

    private MoneyTransferService transferService;
    private AccountRepository accountRepository;
    
    public TransferFacadeImpl(AccountRepository repository, MoneyTransferService service) {
        this.accountRepository = repository;
        this.transferService = service;
    }

    public Account createAccount(String accountId, double initialBalance) {
        return accountRepository.createAccount(accountId, initialBalance);
    }

    public double getBalance(String accountId) {
        Account account = accountRepository.findAccount(accountId);
        return account.getBalance();
    }

    public BankingTransaction transfer(String fromAccountId,
            String toAccountId, double amount) throws MoneyTransferException {
        return transferService.transfer(fromAccountId, toAccountId, amount);
    }


}
