package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance = 0.00;
	private Double withdrawLimit;

	public void deposit(Double balance) {
		this.balance += balance;
	}

	public void withdraw(Double withdraw) {
		if (withdraw > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (withdraw > balance) {
			throw new DomainException(" Not enough balance");
		}
		balance -= withdraw;
	}

	public Account(Integer number, String holder, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

}
