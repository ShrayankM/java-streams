package org.example.dinerAndPancake;

public class PancakeHouseMenu extends Menu {

	public PancakeHouseMenu(String name) {
		super(name, MenuType.BREAKFAST);

		addItem("K&B's Pancake Breakfast",
				"Pancakes with scrambled eggs and toast", true,
				2.99);

		addItem("Regular Pancake Breakfast",
				"Pancakes with fried eggs, sausage", false,
				2.99);

		addItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries", true,
				3.49);

		addItem("Waffles",
				"Waffles with your choice of blueberries or strawberries", true,
				3.59);
	}

	private void addItem(String name, String description, Boolean isVegetarian, Double price) {
		this.addMenuComponent(new MenuItem(name, description, price, isVegetarian));
	}
}
