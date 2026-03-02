package org.example.byteByteGo.vendingMachine;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class TransactionManager {
	private Product selectedProduct;
	private Rack rack;
	private BigDecimal totalAmount;

	public TransactionManager() {
		this.selectedProduct = null;
		this.rack = null;
		this.totalAmount = new BigDecimal("0.0");
	}
}
