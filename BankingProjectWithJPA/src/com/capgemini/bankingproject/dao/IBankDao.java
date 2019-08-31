package com.capgemini.bankingproject.dao;

import java.util.List;

import com.capgemini.bankingproject.bean.Customer;
import com.capgemini.bankingproject.bean.Transcation;
import com.capgemini.bankingproject.exception.BankJpaException;

public interface IBankDao {
	
	long addToCustomer(Customer customer)throws BankJpaException;
	double showBalance(int custId)throws BankJpaException;
	int transferFunds(int sourceCustId,int destinationCustId,double amount) throws BankJpaException;
	double depositBalance(int custId,double amount)throws BankJpaException;
	
	public List<Transcation> printTransactionDetails(int custId);
	public List<Customer> getcustomerList();
	double withdrawBalance(int custId, double amount) throws BankJpaException;

}
