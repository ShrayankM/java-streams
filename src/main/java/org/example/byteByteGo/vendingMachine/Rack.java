package org.example.byteByteGo.vendingMachine;

public class Rack {
	private String rackCode;
	private Product product;
	private Integer productCount;

	public Rack(String rackCode, Product product) {
		this.rackCode = rackCode;
		this.product = product;
		this.productCount = 0;
	}

	public void incrementProductCount() { this.productCount++; }
	public void decrementProductCount() { this.productCount--; }

	public Product getProduct() { return this.product; }
	public Integer getProductCount() { return this.productCount; }
	public String getRackCode() { return this.rackCode; }
}
