
package org.spring4.poc.hibernate.tests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring4.poc.domain.Account;
import org.spring4.poc.domain.IBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public abstract class AbstractPojosTests extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	protected IBank bank;


	//@Test
	public void getAccounts() {
		Collection<Account> accounts = this.bank.getAccount();
		// Use the inherited countRowsInTable() convenience method (from
		// AbstractTransactionalJUnit4SpringContextTests) to verify the results.
/*		assertEquals("JDBC query must show the same number of vets", super.countRowsInTable("VETS"), vets.size());
		Vet v1 = EntityUtils.getById(vets, Vet.class, 2);
		assertEquals("Leary", v1.getLastName());
		assertEquals(1, v1.getNrOfSpecialties());
		assertEquals("radiology", (v1.getSpecialties().get(0)).getName());
		Vet v2 = EntityUtils.getById(vets, Vet.class, 3);
		assertEquals("Douglas", v2.getLastName());
		assertEquals(2, v2.getNrOfSpecialties());
		assertEquals("dentistry", (v2.getSpecialties().get(0)).getName());
		assertEquals("surgery", (v2.getSpecialties().get(1)).getName());*/
	}


	//@Test
	public void loadAccount() {
	//	Account o1 = this.bank.loadAccount(1);
	/*	assertTrue(o1.getLastName().startsWith("Franklin"));
		Owner o10 = this.clinic.loadOwner(10);
		assertEquals("Carlos", o10.getFirstName());*/

		// XXX: Add programmatic support for ending transactions with the
		// TestContext Framework.

		// Check lazy loading, by ending the transaction:
		// endTransaction();

		// Now Owners are "disconnected" from the data store.
		// We might need to touch this collection if we switched to lazy loading
		// in mapping files, but this test would pick this up.
	//	o1.getPets();


	}



	@Test
	public void insertAccount() {
	//	Account o6 = this.bank.loadAccount(6);
		/*int found = o6.getPets().size();
		Pet pet = new Pet();
		pet.setName("bowser");
		Collection<PetType> types = this.clinic.getPetTypes();
		pet.setType(EntityUtils.getById(types, PetType.class, 2));
		pet.setBirthDate(new Date());
		o6.addPet(pet);
		assertEquals(found + 1, o6.getPets().size());
		// both storePet and storeOwner are necessary to cover all ORM tools
		this.clinic.storePet(pet);
		this.clinic.storeOwner(o6);
		// assertTrue(!pet.isNew()); -- NOT TRUE FOR TOPLINK (before commit)
		o6 = this.clinic.loadOwner(6);
		assertEquals(found + 1, o6.getPets().size());*/


		String accountId = "A." + System.currentTimeMillis();
		Account account = new Account(accountId, 1.0);

		this.bank.storeAccount(account);
	}
}
