package org.example.gumball;

public interface State {
	void insertQuarter(GumBallMachine gumBallMachine);
	void ejectQuarter(GumBallMachine gumBallMachine);
	void turnCrank(GumBallMachine gumBallMachine);
	void dispenseGumBall(GumBallMachine gumBallMachine);
	void refill(GumBallMachine gumBallMachine, int quantity);
}
