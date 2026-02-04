package org.example.gumball;

import org.example.GumBallMachineMonitor;

public class GumballMachineDemo {
	public static void main(String [] args) {
		if (args.length < 2) {
			System.out.println("Gumball-machine <location> <inventory>");
			System.exit(1);
		}

		String location = args[0];
		int inventory = Integer.parseInt(args[1]);

		GumBallMachine gumBallMachine = new GumBallMachine(location, inventory);
		GumBallMachineMonitor gumBallMachineMonitor = new GumBallMachineMonitor(gumBallMachine);

		gumBallMachineMonitor.getReport();

		gumBallMachine.insertQuarter();
		gumBallMachine.turnCrank();

		gumBallMachine.insertQuarter();
		gumBallMachine.turnCrank();

		System.out.println(gumBallMachine.getCountOfGumballs());

		gumBallMachine.refillMachine(3);

		gumBallMachine.insertQuarter();
		gumBallMachine.turnCrank();

		System.out.println(gumBallMachine.getCountOfGumballs());
	}
}
