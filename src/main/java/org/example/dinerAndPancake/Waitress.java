package org.example.dinerAndPancake;

public class Waitress {
	private MenuComponent allMenus;

	public Waitress(MenuComponent menus) {
		this.allMenus = menus;
	}

	public void displayAllMenus() {
		allMenus.print();
	}

	// display all menus
//	public void printMenu() {
//		printMenuByType(MenuType.BREAKFAST);
//		printMenuByType(MenuType.DINNER);
//		printMenuByType(MenuType.CAFE);
//	}
//
//	public void printMenuByType(MenuType type) {
//		for (Menu menu : menus) {
//			if (menu.getType() == type) {
//				printMenu(menu.createIterator(), menu.getName());
//			}
//		}
//	}
//
//	public void printMenu(Iterator<MenuItem> iterator, String name) {
//		System.out.println(" ------ " + name + " ------ ");
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
//	}
//
//	// display vegetarian menu
//	public void printVegetarianMenu() {
//		for (Menu menu : this.menus) {
//			printVegetarianMenu(menu.createIterator(), menu.getName());
//		}
//	}
//
//	public void printVegetarianMenu(Iterator<MenuItem> iterator, String name) {
//		System.out.println(" ------ " + name + " ------ ");
//		while (iterator.hasNext()) {
//			MenuItem currentMenuItem = iterator.next();
//			if (currentMenuItem.getIsVegetarian()) {
//				System.out.println(currentMenuItem);
//			}
//		}
//	}
//
//	// is item vegetarian
//	public boolean isItemVegetarian(String name) {
//		boolean flag = false;
//
//		for (Menu menu : this.menus) {
//			flag = isItemVegetarian(menu.createIterator(), name);
//			if (flag)
//				return flag;
//		}
//		return flag;
//	}
//
//	private boolean isItemVegetarian(Iterator<MenuItem> iterator, String name) {
//		while (iterator.hasNext()) {
//			MenuItem currentMenuItem = iterator.next();
//			if (currentMenuItem.getIsVegetarian() && currentMenuItem.getName().equals(name)) {
//				return true;
//			}
//		}
//		return false;
//	}

}
