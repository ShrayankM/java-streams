package org.example.compound;

public class QuackCountingDuckFactory extends AbstractDuckFactory {
	@Override
	Quackable createMallardDuck() {
		return new QuackCounter(new MallardDuck());
	}

	@Override
	Quackable createRedHeadDuck() {
		return new QuackCounter(new RedHeadDuck());
	}

	@Override
	Quackable createDuckCall() {
		return new QuackCounter(new DuckCall());
	}

	@Override
	Quackable createRubberDuck() {
		return new QuackCounter(new RubberDuck());
	}
}
