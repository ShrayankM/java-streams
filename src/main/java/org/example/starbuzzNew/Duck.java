package org.example.starbuzzNew;


public class Duck implements Comparable<Duck> {
	private int weight;
	private String name;
	private int height;

	public Duck(String name, int weight, int height) {
		this.name = name;
		this.weight = weight;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Duck name = {" + this.name + "}, Height = " + this.height + ", Weight = " + this.weight;
	}

	@Override
	public int compareTo(Duck o) {
		if (this.weight > o.weight) {
			return -1;
		} else if (this.weight < o.weight) {
			return 1;
		} else {
			return Integer.compare(o.height, this.height);
		}
	}
}
