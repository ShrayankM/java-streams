package org.example.atm.entities;

public enum NoteType {
	NT_10(10), NT_20(20), NT_50(50), NT_100(100), NT_500(500);
	private int value;

	NoteType(int value) {
		this.value = value;
	}

	public int getValue() { return this.value; }
}
