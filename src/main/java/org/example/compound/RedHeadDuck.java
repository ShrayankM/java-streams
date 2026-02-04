package org.example.compound;

public class RedHeadDuck implements Quackable {
	private Observable observable;

	public RedHeadDuck() {
		observable = new Observable(this);
	}

	@Override
	public void quack() {
		System.out.println("Quack");
		this.notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		this.observable.notifyObservers();
	}
}
