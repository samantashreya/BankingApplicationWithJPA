package com.capgemini.bankingproject.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "CustomerJpa")
public class Customer {
	@Id
	private int custId;
	private String name;
	private String mobile;
	private String email;
	private String address;
	private long accountNo;
	private double balance;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int custId, String name, String mobile, String email, String address, long accountNo,
			double balance, List<Transcation> transaction) {
		super();
		this.custId = custId;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.accountNo = accountNo;
		this.balance = balance;
		
	}
	public Customer(int custId, String name, String mobile, String email, String address, long accountNo,
			double balance) {
		super();
		this.custId = custId;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.accountNo = accountNo;
		this.balance = balance;
	
	}
	public Customer(String name, String mobile, String email, String address) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", address=" + address + ", accountNo=" + accountNo + ", balance=" + balance + " ]";
	}
	
}
