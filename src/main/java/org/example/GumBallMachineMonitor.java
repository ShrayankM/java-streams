package org.example;

import org.example.gumball.GumBallMachine;

public class GumBallMachineMonitor {
	public GumBallMachine gumBallMachine;

	public GumBallMachineMonitor(GumBallMachine gumBallMachine) {
		this.gumBallMachine = gumBallMachine;
	}

	public void getReport() {
		System.out.println("Gumball machine state updated = {" + this.gumBallMachine.getGumballMachineState() + "}");
		System.out.println("Gumball machine ball count = [" + this.gumBallMachine.getCountOfGumballs() + "]");
		System.out.println("Gumball machine location = (" + this.gumBallMachine.getLocation() + ")");
	}
}
