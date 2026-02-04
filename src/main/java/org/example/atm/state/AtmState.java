package org.example.atm.state;

import org.example.atm.entities.AtmAction;
import org.example.atm.entities.AtmCard;
import org.example.atm.entities.AtmMachine;

public interface AtmState {
	void insertCard(AtmMachine atmMachine, AtmCard atmCard);
	void enterPin(AtmMachine atmMachine, String pin);
	void performAction(AtmMachine atmMachine, AtmAction atmAction, int amount);
}
