package org.example.practice.stratergy;

public abstract class PlayableCharacter {
	protected WeaponBehaviour weaponBehaviour;

	public abstract void fight();

	public void setWeaponBehaviour(WeaponBehaviour weaponBehaviour) {
		this.weaponBehaviour = weaponBehaviour;
	}
}
