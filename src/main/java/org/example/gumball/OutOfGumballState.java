package org.example.gumball;

public class OutOfGumballState implements State {
	@Override
	public void insertQuarter(GumBallMachine gumBallMachine) {
		System.out.println("No Gumballs present in system");
	}

	@Override
	public void ejectQuarter(GumBallMachine gumBallMachine) {
		System.out.println("No Gumballs present in system");
	}

	@Override
	public void turnCrank(GumBallMachine gumBallMachine) {
		System.out.println("No Gumballs present in system");
	}

	@Override
	public void dispenseGumBall(GumBallMachine gumBallMachine) {
		System.out.println("No Gumballs present in system");
	}

	@Override
	public void refill(GumBallMachine gumBallMachine, int quantity) {
		System.out.println("Refilling gumball machine");

		gumBallMachine.addGumBallsToMachine(quantity);
		gumBallMachine.setState(new NoQuarterState());
	}
}
