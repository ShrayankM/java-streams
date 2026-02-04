package org.example.dinerAndPancake;

import lombok.Getter;

@Getter
public class MenuItem extends MenuComponent {
	private String name;
	private String description;
	private Double price;
	private Boolean isVegetarian;

	public MenuItem(String name, String description, Double price, Boolean isVegetarian) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.isVegetarian = isVegetarian;
	}

	@Override
	void print() {
		System.out.println("Name = " + this.name + "\n" + "Description = " + this.description + "\n" +
				"Vegetarian = [" + this.isVegetarian + "], Price = [" + this.price + "]");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public boolean isVegetarian() {
		return this.isVegetarian;
	}
}
