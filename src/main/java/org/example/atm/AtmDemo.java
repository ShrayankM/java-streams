package org.example.atm;

import org.example.atm.entities.AtmAction;
import org.example.atm.entities.AtmCard;
import org.example.atm.entities.AtmMachine;
import org.example.atm.entities.BankAccount;
import org.example.atm.entities.BankManagementSystem;
import org.example.atm.entities.User;

public class AtmDemo {
	public static void main(String [] args) {
		BankManagementSystem bankManagementSystem = BankManagementSystem.getInstance();

		User user = bankManagementSystem.registerUser("U1", "Shrayank");
		BankAccount bankAccount = bankManagementSystem.createBankAccountForUser("B1099", user);
		bankManagementSystem.depositAmount(bankAccount, 2000);
		AtmCard atmCard = bankManagementSystem.createCard("C-101-901-00", "0900");
		bankManagementSystem.linkAtmCardToUser(atmCard, "U1");

		AtmMachine atmMachine = new AtmMachine(bankManagementSystem);

		atmMachine.insertCard(atmCard);
		atmMachine.enterPin("0900");
		atmMachine.performAction(AtmAction.WITHDRAW, 500);

		atmMachine.insertCard(atmCard);
		atmMachine.enterPin("0900");
		atmMachine.performAction(AtmAction.INQUIRE, 500);
	}
}
