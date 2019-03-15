package com.webvidhi.stock.accounts.model;

import java.util.UUID;

public class Account {
	
	
	private String userId;
	
	private String name;
	
	private Long balance;
	
	private AccountType acType;
	
	private Currency currency;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String string) {
		this.userId = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public AccountType getAcType() {
		return acType;
	}

	public void setAcType(AccountType acType) {
		this.acType = acType;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
