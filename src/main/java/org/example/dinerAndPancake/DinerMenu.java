package org.example.dinerAndPancake;

public class DinerMenu extends Menu {

	public DinerMenu(String name) {
		super(name, MenuType.DINNER);
		addItem("Vegetarian BLT",
				"(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
	}

	private void addItem(String name, String description, Boolean isVegeterian, Double price) {
		this.addMenuComponent(new MenuItem(name, description, price, isVegeterian));
	}
}
