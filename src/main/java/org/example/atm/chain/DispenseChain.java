package org.example.atm.chain;

public interface DispenseChain {
	void next(DispenseChain dispenseChain);
	boolean canDispenseAmount(int amount);
	void dispenseAmount(int amount);
}
