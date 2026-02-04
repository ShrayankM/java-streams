package org.example.simuDuck;

import org.example.simuDuck.types.RedHeadDuck;
import org.example.simuDuck.types.RubberDuck;

public class SimUDuck {
	public static void main(String [] args) {
		Duck redHeadDuck = new RedHeadDuck();
		redHeadDuck.performFly();
		redHeadDuck.performQuack();

		Duck rubberDuck = new RubberDuck();
		rubberDuck.performFly();
		rubberDuck.performQuack();

		rubberDuck.setFlyBehaviour(new FlyWithWings());
		rubberDuck.performFly();
	}
}
