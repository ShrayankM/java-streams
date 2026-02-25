package org.example.byteByteGo.solid.isp;

public class HumanWorker implements Workable, Eatable {
	public void work() {
		System.out.println("Working");
	}

	public void eat() {
		System.out.println("Eating");
	}
}
