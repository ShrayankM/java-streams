package org.example.oopDesign.dougDoors;

import lombok.Getter;

@Getter
public class Window {
	private boolean isOpen;

	public Window() {
		this.isOpen = false;
	}

	public void open() {
		this.isOpen = true;
		System.out.println("Opening window");
	}

	public void close() {
		this.isOpen = false;
		System.out.println("Closing window");
	}
}
