package org.example.gumball;

public class GumBallWinnerState implements State {
	@Override
	public void insertQuarter(GumBallMachine gumBallMachine) {
		System.out.println("Crank has been turned, preparing to dispense");
	}

	@Override
	public void ejectQuarter(GumBallMachine gumBallMachine) {
		System.out.println("Crank has been turned, preparing to dispense");
	}

	@Override
	public void turnCrank(GumBallMachine gumBallMachine) {
		System.out.println("Crank has been turned, preparing to dispense");
	}

	@Override
	public void dispenseGumBall(GumBallMachine gumBallMachine) {
		gumBallMachine.dispenseGumBalls(1);
		if (!gumBallMachine.checkIfOutOfGumballs()) {
			System.out.println("Congratulations lucky winner, you get 2 gumballs");
			gumBallMachine.dispenseGumBalls(1);
		}

		if (gumBallMachine.checkIfOutOfGumballs()) {
			gumBallMachine.setState(new OutOfGumballState());
		} else {
			gumBallMachine.setState(new NoQuarterState());
		}
	}

	@Override
	public void refill(GumBallMachine gumBallMachine, int quantity) {
		System.out.println("Gumballs present in the cannot refill");
	}
}
