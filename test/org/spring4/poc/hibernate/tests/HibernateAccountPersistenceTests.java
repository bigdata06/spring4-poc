/*


package org.spring4.poc.hibernate.tests;


import org.spring4.poc.domain.Account;
import org.spring4.poc.util.BankingDomainHibernateConstants;
import org.spring4.poc.util.HibernatePersistenceTestsWithResetDatabase;

public class HibernateAccountPersistenceTests extends
		HibernatePersistenceTestsWithResetDatabase {

	@Override
	protected String[] getConfigLocations() {
		return BankingDomainHibernateConstants.BANK_DOMAIN_TEST_CONTEXT;
	}

	public void testSimple() {
		String accountId = "A." + System.currentTimeMillis();
		Account account = new Account(accountId, 1.0);
		getHibernateTemplate().save(account);
	}

}
*/
