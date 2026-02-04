package org.example.dinerAndPancake;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {
	private String name;
	private MenuType menuType;
	private List<MenuComponent> menuComponentList;

	public Menu(String name, MenuType menuType) {
		this.name = name;
		this.menuType = menuType;
		this.menuComponentList = new ArrayList<>();
	}

	@Override
	public void addMenuComponent(MenuComponent menuComponent) {
		this.menuComponentList.add(menuComponent);
	}

	@Override
	public void removeMenuComponent(MenuComponent menuComponent) {
		this.menuComponentList.remove(menuComponent);
	}

	@Override
	public MenuComponent getChild(int index) {
		return this.menuComponentList.get(index);
	}

	@Override
	void print() {
		System.out.println("Menu-Name = [" + getName() + "]");
		for (MenuComponent menuComponent : menuComponentList) {
			menuComponent.print();
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public MenuType getType() {
		return this.menuType;
	}
}
