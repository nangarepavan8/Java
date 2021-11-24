package com.Bank;

import static com.Bank.AccountValidationRule.validatebal;

import java.util.Date;

public class BankAccount {
	private int accNum;
	private String Custname;
	private AccountType AT;
	private double bal;
	private Date creationDate;
	private KYC coustmerInfo;

	public BankAccount(int accNum, String custname, AccountType aT, double bal, Date creationDate) {
		super();
		this.accNum = accNum;
		Custname = custname;
		AT = aT;
		this.bal = bal;
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", Custname=" + Custname + ", AT=" + AT + ", bal=" + bal
				+ ", creationDate=" + creationDate + "]";
	}

	public void withdraw(double amt) throws AccountHandlingException {
		if(coustmerInfo==null)
			throw new AccountHandlingException("KYC Not Linked:  No Txs..!!");
		validatebal(bal - amt);
		bal = bal - amt;
	}

	public void deposit(double amt) {
		bal = bal + amt;
	}

	public void transferFunds(BankAccount dest, double amt) throws AccountHandlingException {
		this.withdraw(amt);
		this.deposit(amt);
	}

	public void applyInterest(double rate) {
		bal = bal + ((bal * rate) / 100);
	}
	
	public void linkKYC(String email, String address, String phoneNo)
	{
		coustmerInfo= new KYC(email, address, phoneNo);
	}
	
	private class KYC {

		private String Email,Address,PhoneNo;

		public KYC(String email, String address, String phoneNo) {
			super();
			this.Email = email;
			this.Address = address;
			this.PhoneNo = phoneNo;
		}

		@Override
		public String toString() {
			return "KYC [Email=" + Email + ", Address=" + Address + ", PhoneNo=" + PhoneNo + "]";
		}
		
		
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String getCustname() {
		return Custname;
	}

	public void setCustname(String custname) {
		Custname = custname;
	}
	

	

}
