package org.spring4.poc.domain;

/**
 * Created by Said on 02/03/2015.
 */
public interface OverdraftPolicy {

    void beforeDebitCheck(Account account,
                          double originalBalance, double newBalance) throws MoneyTransferException;

    void afterDebitCheck(Account account, double originalBalance, double newBalance);

}
