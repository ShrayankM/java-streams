package org.example.atm.entities;

import lombok.Getter;
import org.example.atm.chain.CashDispenser;
import org.example.atm.chain.DispenseChain;
import org.example.atm.state.AtmState;
import org.example.atm.state.IdleAtmState;

@Getter
public class AtmMachine {
	private BankManagementSystem bankManagementSystem;
	private AtmState atmState;
	private AtmCard currentCard;
	private DispenseChain dispenseChain;

	public AtmMachine(BankManagementSystem bankManagementSystem) {
		DispenseChain dispenseChain500 = new CashDispenser(NoteType.NT_500, 2);
		DispenseChain dispenseChain100 = new CashDispenser(NoteType.NT_100, 3);
		DispenseChain dispenseChain50 = new CashDispenser(NoteType.NT_50, 2);
		DispenseChain dispenseChain20 = new CashDispenser(NoteType.NT_20, 10);
		DispenseChain dispenseChain10 = new CashDispenser(NoteType.NT_10, 10);

		dispenseChain500.next(dispenseChain100);
		dispenseChain100.next(dispenseChain50);
		dispenseChain50.next(dispenseChain20);
		dispenseChain20.next(dispenseChain10);

		this.dispenseChain = dispenseChain500;

		this.atmState = new IdleAtmState();
		this.currentCard = null;
		this.bankManagementSystem = bankManagementSystem;
	}

	public void setCurrentCard(AtmCard atmCard) {
		this.currentCard = atmCard;
	}

	public void setAtmState(AtmState atmState) {
		this.atmState = atmState;
	}

	public void insertCard(AtmCard atmCard) {
		this.atmState.insertCard(this, atmCard);
	}

	public void enterPin(String pin) {
		this.atmState.enterPin(this, pin);
	}

	public void performAction(AtmAction atmAction, int amount) {
		this.atmState.performAction(this, atmAction, amount);
	}

	public BankAccount getBankAccountForCard(String cardNumber) {
		return this.bankManagementSystem.getBankAccountFromAtmCard(cardNumber);
	}

	public boolean canDispenseAmount(int amount) {
		return this.dispenseChain.canDispenseAmount(amount);
	}

	public void dispenseAmount(int amount) {
		this.dispenseChain.dispenseAmount(amount);
	}
}
