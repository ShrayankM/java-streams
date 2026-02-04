package org.example.practice.stratergy;

public class GameDemo {
	public static void main(String [] args) {
		PlayableCharacter queen = new Queen();
		queen.setWeaponBehaviour(new BowAndArrow());

		queen.fight();

		PlayableCharacter king = new King();
		king.setWeaponBehaviour(new AxeBehaviour());

		king.fight();
	}
}
