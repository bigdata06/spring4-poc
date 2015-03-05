


package org.spring4.poc.repository;

import java.sql.*;


import org.hibernate.*;
import org.spring4.poc.domain.Account;
import org.springframework.orm.hibernate3.*;

public class HibernateAccountRepository implements AccountRepository {

    private HibernateTemplate hibernateTemplate;

    public HibernateAccountRepository(HibernateTemplate template) {
        assert template != null;
        hibernateTemplate = template;
    }

    public Account createAccount(String accountId, double initialBalance) {
        Account account = new Account(accountId, initialBalance);
        hibernateTemplate.save(account);
        return account;
    }

    public Account findAccount(final String accountId) {
        return (Account) hibernateTemplate.execute(new HibernateCallback() {

            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                Query query = session
                        .getNamedQuery("Account.findAccountByAccountId");
                query.setParameter("accountId", accountId);
                return query.uniqueResult();
            }
        });
    }


}
