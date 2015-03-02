package org.spring4.poc.repository;

import org.spring4.poc.domain.Account;

/**
 * Created by Said on 02/03/2015.
 */
public interface AccountRepository {

    Account findAccount(String accountId);

    Account createAccount(String accountId, double initialBalance);
}
