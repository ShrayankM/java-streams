package org.example.dinerAndPancake;

import java.util.Iterator;

public abstract class MenuComponent {


	// Menu-component level functions
	public void addMenuComponent(MenuComponent menuComponent) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public void removeMenuComponent(MenuComponent menuComponent) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public MenuComponent getChild(int index) {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public MenuType getType() {
		throw new UnsupportedOperationException("Operation not supported");
	}

	// Leaf level functions
	public String getName() {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public String getDescription() {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public Double getPrice() {
		throw new UnsupportedOperationException("Operation not supported");
	}

	public boolean isVegetarian() {
		throw new UnsupportedOperationException("Operation not supported");
	}

	// common
	abstract void print();
}
