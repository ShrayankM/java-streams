package org.example.atm.entities;

import lombok.Getter;

@Getter
public class AtmCard {
	private String cardNumber;
	private String pin;
	private LinkStatus linkStatus;

	AtmCard(String cardNumber, String pin) {
		this.cardNumber = cardNumber;
		this.pin = pin;
		this.linkStatus = LinkStatus.INACTIVE;
	}

	public boolean verifyPin(String pin) {
		return this.pin.equals(pin);
	}

	public void updateLinkStatus(LinkStatus linkStatus) {
		this.linkStatus = linkStatus;
	}

}
