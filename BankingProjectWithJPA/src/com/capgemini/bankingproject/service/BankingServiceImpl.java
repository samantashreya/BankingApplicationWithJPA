package com.capgemini.bankingproject.service;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.bankingproject.bean.Customer;
import com.capgemini.bankingproject.bean.Transcation;
import com.capgemini.bankingproject.dao.BankDaoImpl;
import com.capgemini.bankingproject.dao.IBankDao;
import com.capgemini.bankingproject.exception.BankJpaException;

public class BankingServiceImpl implements IBankingService {
	IBankDao dao = new BankDaoImpl();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = factory.createEntityManager();

	@Override
	public boolean custNameValidation(String name) throws BankJpaException {
		boolean resultNameFlag=false;
		String nameRegex="[a-z A-Z]{8,}$";
		if(!Pattern.matches(nameRegex, name)) {
			resultNameFlag = false;
			throw new BankJpaException("customer name should have 8 or more letters");
		}
		else {
			resultNameFlag = true;
		}
		return resultNameFlag;
	}

	@Override
	public boolean custMobValidation(String mobile) throws BankJpaException {
		boolean resultMobFlag= false;
		String mobRegex ="[6,7,8,9]{1}[0-9]{9}$";
		if(!Pattern.matches(mobRegex, mobile)) {
			throw new BankJpaException("Mobile no should start with 7,8,9 and should be 10 digit");
		}
		else {
			resultMobFlag= true;
		}
		return resultMobFlag;
	}

	@Override
	public boolean custEmailValidation(String email) throws BankJpaException {
		boolean resultEmailFlag= false;
		String emailRegex="^[a-z0-9]{3,}@[a-z]{3,}.com$";
		if(!Pattern.matches(emailRegex, email)){
			throw new BankJpaException("Email should be in small case end with '.com' ");
		}
		else {
			resultEmailFlag= true;
		}
		return resultEmailFlag;
	}

	@Override
	public long addToCustomer(Customer customer) throws BankJpaException {
		// TODO Auto-generated method stub
		return dao.addToCustomer(customer);
	}

	@Override
	public boolean validateDestinationAccount(int custId) throws BankJpaException {
		boolean flag = false;
		Customer customer = em.find(Customer.class, custId);
		if (customer != null) {
			flag = true;

		} else {
			flag = false;
			throw new BankJpaException("Entered customer id is invalid");
		}
		return flag;
	}

	@Override
	public int transferFunds( int sourceCustId, int destinationCustId,double amount) throws BankJpaException {
		// TODO Auto-generated method stub
		return dao.transferFunds(sourceCustId, destinationCustId,amount);
	}

	@Override
	public double showBalance(int custId) throws BankJpaException {
		// TODO Auto-generated method stub
		return dao.showBalance(custId);
	}

	@Override
	public double depositBalance(int custId, double amount) throws BankJpaException {
		
		return dao.depositBalance(custId, amount);
	}

	@Override
	public double withdrawBalance(int custId, double amount) throws BankJpaException {
		// TODO Auto-generated method stub
		return dao.withdrawBalance(custId, amount);
	}

	@Override
	public boolean validateCustId(int custId) throws BankJpaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Transcation> printTransactionDetails(int custId) throws BankJpaException {

		
		
		
		
		return dao.printTransactionDetails(custId);
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	