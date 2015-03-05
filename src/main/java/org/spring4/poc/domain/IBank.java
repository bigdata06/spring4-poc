
package org.spring4.poc.domain;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

/**
 * The high-level IBank business interface.
 * <p>
 * This is basically a data access object. IBank doesn't have a dedicated
 * business facade.
 *

 */
public interface IBank {

	/**
	 * Retrieve all <code>Account</code>s from the data store.
	 *
	 *
	 */
	Collection<Account> getAccount() throws DataAccessException;

	//Collection<Owner> findOwners(String lastName) throws DataAccessException;

	Account loadAccount(int id) throws DataAccessException;


	void storeAccount(Account account) throws DataAccessException;


}
