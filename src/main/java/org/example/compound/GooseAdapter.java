package org.example.compound;

public class GooseAdapter implements Quackable {
	private Goose goose;
	private Observable observable;

	public GooseAdapter(Goose goose) {
		this.goose = goose;
		this.observable = new Observable(this);
	}

	@Override
	public void quack() {
		this.goose.honk();
		this.observable.notifyObservers();
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
