package org.example.practice.stratergy;

public class Queen extends PlayableCharacter {
	@Override
	public void fight() {
		System.out.println("Queen is using here weapon");
		this.weaponBehaviour.useWeapon();
	}
}
