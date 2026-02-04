package org.example.gumball;

public class NoQuarterState implements State {
	@Override
	public void insertQuarter(GumBallMachine gumBallMachine) {
		System.out.println("Quarter inserted");
		gumBallMachine.setState(new HasQuarterState());
	}

	@Override
	public void ejectQuarter(GumBallMachine gumBallMachine) {
		System.out.println("Cannot eject quarter, please enter quarter first");
	}

	@Override
	public void turnCrank(GumBallMachine gumBallMachine) {
		System.out.println("Cannot turn crank, please enter quarter first");
	}

	@Override
	public void dispenseGumBall(GumBallMachine gumBallMachine) {
		System.out.println("Cannot dispense gumball, please enter quarter first");
	}

	@Override
	public void refill(GumBallMachine gumBallMachine, int quantity) {
		System.out.println("Gumballs present in the cannot refill");
	}
}
