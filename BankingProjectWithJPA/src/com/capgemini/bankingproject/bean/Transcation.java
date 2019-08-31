package com.capgemini.bankingproject.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "TransactionJpa")
public class Transcation {
	@Id
	private int transId;
	private String transType;
	private Date transDate;
	private int custId;
	private long sourceAccNo;
	private long destinationAccNo;
	private double amount;
	public Transcation() {
		super();
		
	}
	public Transcation(int transId, String transType, Date transDate, int custId, long sourceAccNo,
			long destinationAccNo, double amount) {
		super();
		this.transId = transId;
		this.transType = transType;
		this.transDate = transDate;
		this.custId = custId;
		this.sourceAccNo = sourceAccNo;
		this.destinationAccNo = destinationAccNo;
		this.amount = amount;
	}
	
	public Transcation(int custId, long sourceAccNo,long destinationAccNo, double amount) {
		super();
		this.custId = custId;
		this.sourceAccNo = sourceAccNo;
		this.destinationAccNo = destinationAccNo;
		this.amount = amount;
	}
	public Transcation(int custId,double amount) {
		super();
		this.custId = custId;
		this.amount = amount;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public long getSourceAccNo() {
		return sourceAccNo;
	}
	public void setSourceAccNo(int sourceAccNo) {
		this.sourceAccNo = sourceAccNo;
	}
	public long getDestinationAccNo() {
		return destinationAccNo;
	}
	public void setDestinationAccNo(int destinationAccNo) {
		this.destinationAccNo = destinationAccNo;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return " transId " + transId + ", transType=" + transType + ", transDate=" + transDate + ", custId="
				+ custId + ", sourceAccNo=" + sourceAccNo + ", destinationAccNo=" + destinationAccNo + ", amount="
				+ amount + "";
	}
	
	
}
