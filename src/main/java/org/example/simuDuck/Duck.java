package org.example.simuDuck;

public abstract class Duck {
	protected FlyBehaviour flyBehaviour;
	protected QuackBehaviour quackBehaviour;

	public void performQuack() {
		quackBehaviour.quack();
	}

	public void performFly() {
		flyBehaviour.fly();
	}

	public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
		this.flyBehaviour = flyBehaviour;
	}

	public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
		this.quackBehaviour = quackBehaviour;
	}
}
