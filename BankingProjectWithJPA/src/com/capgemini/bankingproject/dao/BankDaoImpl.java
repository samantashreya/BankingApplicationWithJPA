package com.capgemini.bankingproject.dao;

import java.util.List;
/***
 * @author shreyasi samanta
 * version 1.0
 * 
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.bankingproject.bean.Customer;
import com.capgemini.bankingproject.bean.Transcation;
import com.capgemini.bankingproject.exception.BankJpaException;

public class BankDaoImpl implements IBankDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = factory.createEntityManager();

	/***
	 * Method Name: addToCustomer purpose: adding details of customer to bank
	 * database parameter: Customer object containing the information of customer
	 * return: randomly generated customer Id
	 */

	@Override
	public long addToCustomer(Customer customer) throws BankJpaException {
		int custId = (int) (Math.random() * 10000);
		long accountNo = (long) (Math.random() * 1000000L);
		customer.setCustId(custId);
		customer.setAccountNo(accountNo);

		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		System.out.println("Succesfully registered!! Your AccountNo is " + accountNo);
		return custId;
	}

	/***
	 * Method Name: showBalance purpose: showing available balance of customer of
	 * given id parameter: customer id return: available balance of customer
	 */
	@Override
	public double showBalance(int custId) throws BankJpaException {
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, custId);
		em.getTransaction().commit();
		return customer.getBalance();

	}

	/***
	 * Method Name: transferFunds purpose: transferring the funds to other account
	 * parameter: Payee Customer Id, recipient customer Id, amount to transfer
	 * return: transaction Id
	 */

	@Override
	public int transferFunds(int sourceCustId, int destinationCustId, double amount) throws BankJpaException {

		double updatedAmountofPayee = 0.0;
		double updatedAmountofRecepient = 0.0;
		int transId = (int) (Math.random() * 10000);
		em.getTransaction().begin();
		Customer payeeCustomer = em.find(Customer.class, sourceCustId);
		Customer recepientCustomer = em.find(Customer.class, destinationCustId);
		double availableBalance = payeeCustomer.getBalance();
		if (payeeCustomer != null && recepientCustomer != null && payeeCustomer.getBalance() > amount) {

			updatedAmountofPayee = payeeCustomer.getBalance() - amount;
			payeeCustomer.setBalance(updatedAmountofPayee);
			updatedAmountofRecepient = recepientCustomer.getBalance() + amount;
			recepientCustomer.setBalance(updatedAmountofRecepient);

			Transcation transaction = new Transcation();

			java.util.Date transDate = new java.util.Date();
			transaction.setTransId(transId);
			if (updatedAmountofPayee > availableBalance) {
				transaction.setTransType("Debit");
			} else {
				transaction.setTransType("Credit");
			}

			transaction.setTransDate(transDate);
			transaction.setCustId(sourceCustId);
			transaction.setAmount(amount);
			transaction.setSourceAccNo(sourceCustId);
			transaction.setDestinationAccNo(destinationCustId);
			em.persist(transaction);

			em.getTransaction().commit();
		} else {
			System.err.println("Low account balance! transaction failed");
		}

		return transId;
	}

	/***
	 * Method Name: depositBalance purpose: depositing money in account with given
	 * id parameter: customer Id, amount to transfer return: updated available
	 * balance in account
	 */
	@Override
	public double depositBalance(int custId, double amount) throws BankJpaException {
		double updatedAmount = 0.0;
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, custId);
		if (customer != null) {
			updatedAmount = customer.getBalance() + amount;
			customer.setBalance(updatedAmount);

			Transcation transaction = new Transcation();
			int transId = (int) (Math.random() * 10000);
			java.util.Date transDate = new java.util.Date();
			transaction.setTransId(transId);
			transaction.setTransType("Credit");
			transaction.setTransDate(transDate);
			transaction.setCustId(custId);
			transaction.setAmount(amount);
			transaction.setSourceAccNo(custId);
			transaction.setDestinationAccNo(custId);
			em.persist(transaction);

			em.getTransaction().commit();
		}
		return updatedAmount;

	}

	/***
	 * Method Name: withdrawBalance purpose: withdrawing money from account
	 * parameter: Customer Id, amount to transfer return: available updated balance
	 */

	@Override
	public double withdrawBalance(int custId, double amount) throws BankJpaException {
		double updatedAmount = 0.0;
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, custId);
		if (customer != null && customer.getBalance() > amount) {
			updatedAmount = customer.getBalance() - amount;
			customer.setBalance(updatedAmount);

			Transcation transaction = new Transcation();
			int transId = (int) (Math.random() * 10000);
			java.util.Date transDate = new java.util.Date();
			transaction.setTransId(transId);
			transaction.setTransType("Debit");
			transaction.setTransDate(transDate);
			transaction.setCustId(custId);
			transaction.setAmount(amount);
			transaction.setSourceAccNo(custId);
			transaction.setDestinationAccNo(custId);
			em.persist(transaction);
			em.getTransaction().commit();
		} else {
			System.err.println("Low Account balance! your availble balance is " + customer.getBalance()
					+ " Transaction not possible!!");
		}
		return updatedAmount;

	}

	/***
	 * Method Name: printTransactionDetails
	 * purpose: adding details of transaction made by customer
	 *  		with given customer id to list of transaction 
	 * parameter: CustomerId
	 * return: List of transaction
	 */

	@Override
	public List<Transcation> printTransactionDetails(int custId) {

		TypedQuery<Transcation> query = em.createQuery("from Transcation where custId=:custIdNumber",
				Transcation.class);
		query.setParameter("custIdNumber", custId);
		List<Transcation> transactionList = query.getResultList();
		return transactionList;
	}

	@Override
	public List<Customer> getcustomerList() {
		// TODO Auto-generated method stub
		return null;
	}
}
