package org.example.compound;

public class ObserverQuackologist implements Observer {

	@Override
	public void receiveEvent(Quackable quackable) {
		System.out.println("Real time quacking tracked for duck type = " + quackable.getClass().getName());
	}
}
