
/**
 * Created by Said on 23/02/2015.
 */


package org.spring4.poc.tests;

import junit.framework.TestCase;
import org.spring4.poc.domain.Account;
import org.spring4.poc.domain.MoneyTransferException;


public class AccountTests extends TestCase {

    private Account account;

    public void setUp() {
        account = new Account("XXX", 10.0);
    }

    public void test_normal() throws MoneyTransferException {
        assertEquals(10.0, account.getBalance());
        account.debit(5);
        assertEquals(5.0, account.getBalance());
        account.credit(10);
        assertEquals(15.0, account.getBalance());
        account.debit(15);
    }

    public void test_overdrawn() {
        assertEquals(10.0, account.getBalance());
        try {
            account.debit(20);
            fail("exception expected");
        } catch (MoneyTransferException e) {

        }
    }
}
