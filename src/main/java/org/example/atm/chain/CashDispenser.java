package org.example.atm.chain;

import org.example.atm.entities.NoteType;

public class CashDispenser implements DispenseChain {
	private DispenseChain nextDispenseChain;
	private NoteType noteType;
	private int quantity;

	public CashDispenser(NoteType noteType, int quantity) {
		this.noteType = noteType;
		this.quantity = quantity;
	}

	@Override
	public void next(DispenseChain dispenseChain) {
		this.nextDispenseChain = dispenseChain;
	}

	@Override
	public boolean canDispenseAmount(int amount) {
		int notesRequired = amount / this.noteType.getValue();
		int pendingAmount = (amount - (notesRequired) * this.noteType.getValue());

		if (notesRequired <= this.quantity) {
			return true;
		} else {
			if (this.nextDispenseChain != null) {
				return this.nextDispenseChain.canDispenseAmount(pendingAmount);
			}
		}
		return false;
	}

	@Override
	public void dispenseAmount(int amount) {
		int notesRequired = amount / this.noteType.getValue();
		int pendingAmount = (amount - (notesRequired) * this.noteType.getValue());


		if (notesRequired >= this.quantity) {
			this.quantity = this.quantity - notesRequired;
		} else {
			if (this.nextDispenseChain != null) {
				this.nextDispenseChain.dispenseAmount(pendingAmount);
			}
		}
	}
}
