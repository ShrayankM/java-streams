package org.example.compound;

public class DuckSimulator {
	public static void main(String [] args) {
		DuckSimulator duckSimulator = new DuckSimulator();
		AbstractDuckFactory abstractDuckFactory = new QuackCountingDuckFactory();

		duckSimulator.simulate(abstractDuckFactory);
	}

	private void simulate(AbstractDuckFactory duckFactory) {
		ObserverQuackologist observerQuackologist = new ObserverQuackologist();
		Flock flockOfQuackers = new Flock();
		flockOfQuackers.addQuacker(duckFactory.createMallardDuck());
		flockOfQuackers.addQuacker(duckFactory.createRedHeadDuck());
		flockOfQuackers.addQuacker(duckFactory.createDuckCall());
		flockOfQuackers.addQuacker(duckFactory.createRubberDuck());
		flockOfQuackers.addQuacker(new QuackCounter(new GooseAdapter(new Goose())));

		flockOfQuackers.registerObserver(observerQuackologist);

		simulate(flockOfQuackers);
		QuackCounter.getQuackCount();
	}

	private void simulate(Flock flock) {
		flock.quack();
	}
}
