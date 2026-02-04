package org.example.atm.state;

import org.example.atm.entities.AtmAction;
import org.example.atm.entities.AtmCard;
import org.example.atm.entities.AtmMachine;
import org.example.atm.entities.LinkStatus;

import java.util.Map;
import java.util.Objects;

public class IdleAtmState implements AtmState {
	@Override
	public void insertCard(AtmMachine atmMachine, AtmCard atmCard) {
		Map<String, AtmCard> atmCardMap = atmMachine.getBankManagementSystem().getAtmCardMap();
		String cardNumber = atmCard.getCardNumber();

		AtmCard atmCardInSystem = atmCardMap.get(cardNumber);
		if (Objects.nonNull(atmCardInSystem) && LinkStatus.ACTIVE.equals(atmCardInSystem.getLinkStatus())) {
			atmMachine.setCurrentCard(atmCard);
			atmMachine.setAtmState(new CardInsertedAtmState());
		} else {
			System.out.println("Card not present in the system or is inactive");
		}
	}

	@Override
	public void enterPin(AtmMachine atmMachine, String pin) {
		System.out.println("Please enter atm-card first");
	}

	@Override
	public void performAction(AtmMachine atmMachine, AtmAction atmAction, int amount) {
		System.out.println("Please insert atm-card first");
	}
}
