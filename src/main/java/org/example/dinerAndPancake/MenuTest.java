package org.example.dinerAndPancake;

import java.util.List;

public class MenuTest {
	public static void main(String [] args) {
		MenuComponent pankCakeHouseMenu = new PancakeHouseMenu("Breakfast Menu");
		MenuComponent dinerMenu = new DinerMenu("Diner Menu");
		MenuComponent cafeMenu = new CafeMenu("Cafe Menu");

		MenuComponent combinedMenus = new Menu("Menus", MenuType.COMBINED);
		combinedMenus.addMenuComponent(pankCakeHouseMenu);
		combinedMenus.addMenuComponent(dinerMenu);
		combinedMenus.addMenuComponent(cafeMenu);

		Waitress waitress = new Waitress(combinedMenus);
		waitress.displayAllMenus();
	}
}
