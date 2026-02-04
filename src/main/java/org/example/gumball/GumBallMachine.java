package org.example.gumball;

public class GumBallMachine {
	private State gumballMachineState;
	private int countOfGumballs = 0;
	private String location;

	public GumBallMachine(String location, int gumballQuantity) {
		this.gumballMachineState = new OutOfGumballState();
		if (gumballQuantity > 0) {
			this.gumballMachineState = new NoQuarterState();
			this.countOfGumballs = gumballQuantity;
		}
		this.location = location;
	}

	public void setState(State state) {
		this.gumballMachineState = state;
	}

	public void addGumBallsToMachine(int countOfGumballs) {
		this.countOfGumballs = countOfGumballs;
		this.gumballMachineState = new NoQuarterState();
	}

	public void dispenseGumBalls(int quantity) {
		System.out.println("Dispensing [" + quantity + "] gumballs");
		this.countOfGumballs = this.countOfGumballs - quantity;
	}

	public int getCountOfGumballs() { return this.countOfGumballs; }
	public String getLocation() { return this.location; }
	public State getGumballMachineState() { return this.gumballMachineState; }


	// transition function
	public void insertQuarter() {
		this.gumballMachineState.insertQuarter(this);
	}

	public void ejectQuarter() {
		this.gumballMachineState.ejectQuarter(this);
	}

	public void turnCrank() {
		this.gumballMachineState.turnCrank(this);
		dispenseGumball();
	}

	public void dispenseGumball() {
		this.gumballMachineState.dispenseGumBall(this);
	}

	public void refillMachine(int quantity) {
		this.gumballMachineState.refill(this, quantity);
	}

	public boolean checkIfOutOfGumballs() {
		return getCountOfGumballs() < 1;
	}
}
