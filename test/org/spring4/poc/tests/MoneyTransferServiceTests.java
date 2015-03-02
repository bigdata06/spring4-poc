

/**
 * Created by Said on 23/02/2015.
 */


package org.spring4.poc.tests;

import org.junit.Before;
import org.junit.Test;
import org.spring4.poc.domain.Account;
import org.spring4.poc.domain.BankingTransaction;
import org.spring4.poc.domain.TransferTransaction;
import org.spring4.poc.repository.AccountRepository;
import org.spring4.poc.repository.BankingTransactionRepository;
import org.spring4.poc.service.MoneyTransferService;
import org.spring4.poc.service.MoneyTransferServiceImpl;

import java.util.Date;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class MoneyTransferServiceTests {

    private AccountRepository mockAccountRepository;
    private BankingTransactionRepository mockBankingTransactionRepository;
    private MoneyTransferService service;
    private Account mockFromAccount;
    private Account mockToAccount;
    private Account toAccount;
    private Account fromAccount;
    private BankingTransaction bankingTransaction;

    @Before
    public void create(){
        mockAccountRepository = mock(AccountRepository.class);
        mockBankingTransactionRepository =mock(BankingTransactionRepository.class);
        service = new MoneyTransferServiceImpl(
                (AccountRepository) mockAccountRepository ,(BankingTransactionRepository) mockBankingTransactionRepository);

        mockFromAccount = mock(Account.class);
        mockToAccount = mock(Account.class);
        fromAccount = mockFromAccount;
        toAccount = mockToAccount;
        bankingTransaction = new TransferTransaction(fromAccount, toAccount,
                1.0, new Date());
    }

    @Test
    public void testTransfer_normal() throws Exception {

        String fromAccountId = "from";
        String toAccountId = "to";
        double amount = 10.0;


        when (mockAccountRepository.findAccount(fromAccountId)).thenReturn(fromAccount);

        when (mockAccountRepository.findAccount(toAccountId)).thenReturn(toAccount);


        when (mockBankingTransactionRepository.createTransferTransaction(fromAccount, toAccount, amount)).
                thenReturn(bankingTransaction);


        BankingTransaction result = service.transfer(
                fromAccountId, toAccountId, amount);

        verify(mockFromAccount).debit(amount);
        verify(mockFromAccount,times(1)).debit(amount);

        verify(mockToAccount).credit(amount);
        verify(mockToAccount,times(1)).credit(amount);

        assertSame(bankingTransaction, result);

    }

//    public void testTransfer_overdrawn()
//            throws Exception {
//
//        String fromAccountId = "from";
//        String toAccountId = "to";
//        double amount = 10.0;
//
//        mockAccountRepository.expects(once()).method(
//                "findAccount").with(eq(fromAccountId))
//                .will(returnValue(fromAccount));
//
//        mockAccountRepository.expects(once()).method(
//                "findAccount").with(eq(toAccountId))
//                .will(returnValue(toAccount));
//
//        mockFromAccount
//                .expects(once())
//                .method("debit")
//                .with(eq(amount))
//                .will(
//                        throwException(new MoneyTransferException()));
//
//        try {
//            service.transfer(fromAccountId,
//                    toAccountId, amount);
//            fail("Exception expected");
//        } catch (MoneyTransferException e) {
//
//        }

  //  }
}
