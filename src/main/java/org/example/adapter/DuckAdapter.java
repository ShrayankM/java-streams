package org.example.adapter;

public class DuckAdapter implements Turkey {
	private Duck duck;

	public DuckAdapter(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void gobble() {
		this.duck.quack();
	}

	@Override
	public void fly() {
		this.duck.fly();
	}
}
