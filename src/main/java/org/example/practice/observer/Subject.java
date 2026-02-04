package org.example.practice.observer;

public interface Subject {
	void registerObservers(ObserverDisplay observerDisplay);
	void removeObserver(ObserverDisplay observerDisplay);
	void notifyObservers();
}
