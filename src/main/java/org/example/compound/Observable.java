package org.example.compound;

import java.util.ArrayList;
import java.util.List;

public class Observable implements QuackObservable {
	private List<Observer> observerList;
	private Quackable quackable;

	public Observable(Quackable quackable) {
		this.observerList = new ArrayList<>();
		this.quackable = quackable;
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observerList.add(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : this.observerList) {
			observer.receiveEvent(quackable);
		}
	}
}
