package org.example.compound;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {
	private List<Quackable> quackableList;
//	private Observable observable;


	public Flock() {
		this.quackableList = new ArrayList<>();
//		this.observable = new Observable(this);
	}

	public void addQuacker(Quackable quackable) {
		this.quackableList.add(quackable);
	}

	@Override
	public void quack() {
		for (Quackable quackable : this.quackableList) {
			quackable.quack();
		}
	}

	@Override
	public void registerObserver(Observer observer) {
		for (Quackable quackable : this.quackableList) {
			quackable.registerObserver(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for (Quackable quackable : this.quackableList) {
			quackable.notifyObservers();
		}
	}
}
