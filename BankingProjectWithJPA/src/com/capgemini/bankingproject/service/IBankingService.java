package com.capgemini.bankingproject.service;

import java.util.List;
import java.util.Map;

import com.capgemini.bankingproject.bean.Customer;
import com.capgemini.bankingproject.bean.Transcation;
import com.capgemini.bankingproject.exception.BankJpaException;

public interface IBankingService {
	public boolean custNameValidation(String name) throws BankJpaException;
	public boolean custMobValidation(String mobile) throws BankJpaException;
	public boolean custEmailValidation(String email)throws BankJpaException;
	public long addToCustomer(Customer customer) throws BankJpaException;
	public boolean validateDestinationAccount(int custId) throws BankJpaException;
	public int transferFunds(int sourceCustId,int destinationCustId,double amount) throws BankJpaException;
	public double showBalance(int custId) throws BankJpaException;
	public double depositBalance(int custId,double amount) throws BankJpaException;
	public double withdrawBalance(int custId, double amount)throws BankJpaException;
	public boolean validateCustId(int custId)throws BankJpaException;
	public List<Transcation> printTransactionDetails(int custId) throws BankJpaException;
	

}
