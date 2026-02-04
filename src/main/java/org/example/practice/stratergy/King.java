package org.example.practice.stratergy;

public class King extends PlayableCharacter {
	@Override
	public void fight() {
		System.out.println("King is using his weapon");
		this.weaponBehaviour.useWeapon();
	}
}
