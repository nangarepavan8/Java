package com.Bank;

public enum AccountType {
	SAVING,CURRENT ,FD ,LOAN ,DMAT;
	@Override
	public String toString() {
		return"A/C Type:" + name().toString(); 
	}
}
