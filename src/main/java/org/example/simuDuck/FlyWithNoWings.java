package org.example.simuDuck;

public class FlyWithNoWings implements FlyBehaviour {

	@Override
	public void fly() {
		System.out.println("Duck cannot fly");
	}
}
