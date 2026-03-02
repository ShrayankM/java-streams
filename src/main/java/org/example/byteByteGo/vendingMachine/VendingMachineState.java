package org.example.byteByteGo.vendingMachine;

import java.math.BigDecimal;

public interface VendingMachineState {
	void insertMoney(BigDecimal money, VendingMachine vendingMachine);
	void selectProduct(Product product, VendingMachine vendingMachine);
	Product dispenseProduct(VendingMachine vendingMachine);
	BigDecimal returnChange(VendingMachine vendingMachine);
}
