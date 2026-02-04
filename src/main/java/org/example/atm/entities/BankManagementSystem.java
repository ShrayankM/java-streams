package org.example.atm.entities;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class BankManagementSystem {
	private static BankManagementSystem bankManagementSystem;
	private Map<String, User> userMap = new ConcurrentHashMap<>();
	private Map<String, BankAccount> userBankAccountMap = new ConcurrentHashMap<>();
	private Map<String, AtmCard> atmCardMap = new ConcurrentHashMap<>();
	private Map<String, BankAccount> atmCardBankAccountMap = new ConcurrentHashMap<>();

	private BankManagementSystem() {};

	public static synchronized BankManagementSystem getInstance() {
		if (bankManagementSystem == null) {
			bankManagementSystem = new BankManagementSystem();
		}
		return bankManagementSystem;
	}

	public User registerUser(String id, String name) {
		if (!userMap.containsKey(id)) {
			User user = new User(id, name);
			userMap.put(id, user);
		} else {
			System.out.println("User already exists");
		}
		return userMap.get(id);
	}

	public BankAccount createBankAccountForUser(String bankAccountId, User user) {
		String userId = user.getId();
		if (!userBankAccountMap.containsKey(userId)) {
			BankAccount bankAccount = new BankAccount(bankAccountId, user);
			userBankAccountMap.put(userId, bankAccount);
		} else {
			System.out.println("User already has a bank-account");
		}
		return userBankAccountMap.get(userId);
	}

	public void depositAmount(BankAccount bankAccount, int amount) {
		bankAccount.depositAmount(amount);
	}

	public AtmCard createCard(String cardNumber, String pin) {
		AtmCard atmCard = new AtmCard(cardNumber, pin);
		atmCardMap.put(cardNumber, atmCard);
		return atmCard;
	}

	public void linkAtmCardToUser(AtmCard atmCard, String userId) {
		BankAccount bankAccount = userBankAccountMap.get(userId);
		if (Objects.isNull(bankAccount)) {
			System.out.println("User does not have an account, cannot link atm-card");
			return;
		}
		atmCard.updateLinkStatus(LinkStatus.ACTIVE);
		bankAccount.linkCard(atmCard);
		this.atmCardBankAccountMap.put(atmCard.getCardNumber(), bankAccount);
	}

	public BankAccount getBankAccountFromAtmCard(String cardNumber) {
		return this.atmCardBankAccountMap.get(cardNumber);
	}

	public Map<String, AtmCard> getAtmCardMap() { return this.atmCardMap; }
}
