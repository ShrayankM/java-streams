package org.example.byteByteGo.vendingMachine;

import java.util.List;
import java.util.Map;

public class InventoryManager {
	private Map<String, Rack> racks;

	public InventoryManager(Map<String, Rack> racks)  {
		this.racks = racks;
	}

	// admin-only
	public void addProductToRack(String rackCode) {
		racks.get(rackCode).incrementProductCount();
	}

	// customer or admin
	public Product dispenseProductFromRack(String rackCode) {
		Rack rack = racks.get(rackCode);
		Product product = rack.getProduct();
		rack.decrementProductCount();;

		return product;
	}

	public Rack getRackFromRackCode(String rackCode) {
		return this.racks.get(rackCode);
	}

	public boolean isProductInStock(Product product) {
		List<Rack> racksList = racks.values().stream().toList();

		for (Rack rack : racksList) {
			Product rackProduct = rack.getProduct();
			if (rackProduct.getProductCode().equals(product.getProductCode()) && rack.getProductCount() > 0) return true;
		}
		return false;
	}

	public String getRackCodeForProduct(Product product) {
		List<Rack> racksList = racks.values().stream().toList();

		for (Rack rack : racksList) {
			Product rackProduct = rack.getProduct();
			if (rackProduct.getProductCode().equals(product.getProductCode()) && rack.getProductCount() > 0) {
				return rack.getRackCode();
			}
		}
		return null;
	}
}
