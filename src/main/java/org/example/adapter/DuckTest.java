package org.example.adapter;

public class DuckTest {
	public static void main(String [] args) {
		Duck mallardDuck = new MallardDuck();

		Turkey wildTurkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);

		testDuck(mallardDuck);
		testDuck(turkeyAdapter);

		Turkey duckAdapter = new DuckAdapter(mallardDuck);

		testTurkey(wildTurkey);
		testTurkey(duckAdapter);
	}

	private static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}

	public static void testTurkey(Turkey turkey) {
		turkey.gobble();
		turkey.fly();
	}
}
