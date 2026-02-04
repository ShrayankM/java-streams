package org.example.simuDuck.types;

import org.example.simuDuck.Duck;
import org.example.simuDuck.FlyWithNoWings;
import org.example.simuDuck.Squeak;

public class RubberDuck extends Duck {
	public RubberDuck() {
		this.flyBehaviour = new FlyWithNoWings();
		this.quackBehaviour = new Squeak();
	}
}
