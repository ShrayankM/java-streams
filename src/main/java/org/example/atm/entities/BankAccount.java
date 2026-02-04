package org.example.atm.entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BankAccount {
	private String id;
	private User user;
	private Integer balance;
	private List<AtmCard> atmCardList;

	public BankAccount(String id, User user) {
		this.id = id;
		this.user = user;
		this.balance = 0;
		this.atmCardList = new ArrayList<>();
	}

	public boolean checkBalance(Integer amount) {
		if (this.balance >= amount) {
			return true;
		}
		return false;
	}

	public void withdrawnAmount(Integer amount) {
		if (this.balance >= amount) {
			this.balance = this.balance - amount;
		} else {
			System.out.println("Insufficient balance in account, cannot withdraw amount");
		}
	}

	public void depositAmount(Integer amount) {
		if (amount < 0) {
			System.out.println("Cannot deposit negative amount");
		}
		this.balance = this.balance + amount;
	}

	public void linkCard(AtmCard atmCard) {
		this.atmCardList.add(atmCard);
	}
}
