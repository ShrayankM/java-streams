package org.example.byteByteGo.vendingMachine;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Product {
	private String productCode;
	private BigDecimal price;
	private String name;

	public Product(String productCode, String name, BigDecimal price) {
		this.productCode = productCode;
		this.name = name;
		this.price = price;
	}
}
