package org.example.gumball;

import java.util.Random;

public class HasQuarterState implements State {
	@Override
	public void insertQuarter(GumBallMachine gumBallMachine) {
		System.out.println("Quarter already inserted");
	}

	@Override
	public void ejectQuarter(GumBallMachine gumBallMachine) {
		System.out.println("Ejecting quarter, please collect");
		gumBallMachine.setState(new NoQuarterState());
	}

	@Override
	public void turnCrank(GumBallMachine gumBallMachine) {
		System.out.println("Turning crank to dispense gumball");

		int random = new Random().nextInt(10) + 1;

		if (random == 1) {
			gumBallMachine.setState(new GumBallWinnerState());
		} else {
			gumBallMachine.setState(new GumballSoldState());
		}
	}

	@Override
	public void dispenseGumBall(GumBallMachine gumBallMachine) {
		System.out.println("Please turn crank to dispense gumball");
	}

	@Override
	public void refill(GumBallMachine gumBallMachine, int quantity) {
		System.out.println("Gumballs present in the cannot refill");
	}
}
