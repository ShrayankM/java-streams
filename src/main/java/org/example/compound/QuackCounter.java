package org.example.compound;

public class QuackCounter implements Quackable {
	private static int quackCount = 0;
	private final Quackable quackable;

	public QuackCounter(Quackable quackable) {
		this.quackable = quackable;
	}

	@Override
	public void quack() {
		this.quackable.quack();
		quackCount++;
	}

	public static void getQuackCount() {
		System.out.println("Total quack counts = [" + quackCount + "]");
	}

	@Override
	public void registerObserver(Observer observer) {
		this.quackable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		this.quackable.notifyObservers();
	}
}
