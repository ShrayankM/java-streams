package org.example.compound;

public interface QuackObservable {
	void registerObserver(Observer observer);
	void notifyObservers();
}
