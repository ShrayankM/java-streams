package org.example.simuDuck.types;

import org.example.simuDuck.Duck;
import org.example.simuDuck.FlyWithWings;
import org.example.simuDuck.Quack;

public class RedHeadDuck extends Duck {
	public RedHeadDuck() {
		this.flyBehaviour = new FlyWithWings();
		this.quackBehaviour = new Quack();
	}
}
