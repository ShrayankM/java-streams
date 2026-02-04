package org.example.atm.state;

import org.example.atm.entities.AtmAction;
import org.example.atm.entities.AtmCard;
import org.example.atm.entities.AtmMachine;
import org.example.atm.entities.BankAccount;

public class VerifiedAtmState implements AtmState {
	@Override
	public void insertCard(AtmMachine atmMachine, AtmCard atmCard) {
		System.out.println("Card is already inserted & verified please choose action to perform");
	}

	@Override
	public void enterPin(AtmMachine atmMachine, String pin) {
		System.out.println("Pin is already verified please choose action to perform");
	}

	@Override
	public void performAction(AtmMachine atmMachine, AtmAction atmAction, int amount) {
		switch (atmAction) {
			case WITHDRAW -> {
				AtmCard atmCard = atmMachine.getCurrentCard();
				BankAccount bankAccount = atmMachine.getBankAccountForCard(atmCard.getCardNumber());

				if (!bankAccount.checkBalance(amount)) {
					System.out.println("Bank account has insufficient balance, please re-enter amount");
					return;
				}

				if (!atmMachine.canDispenseAmount(amount)) {
					System.out.println("Cannot dispense this amount, insufficient funds in the system");
					return;
				}

				bankAccount.withdrawnAmount(amount);
				atmMachine.dispenseAmount(amount);
				System.out.println("Dispensing amount = " + amount);
			}

			case DEPOSIT -> {

			}

			case INQUIRE -> {
				AtmCard atmCard = atmMachine.getCurrentCard();
				BankAccount bankAccount = atmMachine.getBankAccountForCard(atmCard.getCardNumber());

				System.out.println("Current account balance is = " + bankAccount.getBalance());
			}
		}
		atmMachine.setAtmState(new IdleAtmState());
	}
}
