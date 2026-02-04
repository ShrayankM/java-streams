package org.example.atm.state;

import org.example.atm.entities.AtmAction;
import org.example.atm.entities.AtmCard;
import org.example.atm.entities.AtmMachine;

public class CardInsertedAtmState implements AtmState {
	@Override
	public void insertCard(AtmMachine atmMachine, AtmCard atmCard) {
		System.out.println("Card is already inserted, please enter pin to verify yourself");
	}

	@Override
	public void enterPin(AtmMachine atmMachine, String pin) {
		AtmCard currentEnteredCard = atmMachine.getCurrentCard();

		if (currentEnteredCard == null) {
			System.out.println("Card not found, please re-insert card");
			atmMachine.setAtmState(new IdleAtmState());
			return;
		}

		if (currentEnteredCard.verifyPin(pin)) {
			System.out.println("Pin verified");
			atmMachine.setAtmState(new VerifiedAtmState());
		} else {
			System.out.println("Pin entered is incorrect, please retry");
		}

	}

	@Override
	public void performAction(AtmMachine atmMachine, AtmAction atmAction, int amount) {
		System.out.println("Cannot perform action until user is verified with pin");
	}
}
