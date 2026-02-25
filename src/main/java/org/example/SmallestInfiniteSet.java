package org.example;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {
	private final PriorityQueue<Integer> minHeap;
	private final Set<Integer> set;

	public SmallestInfiniteSet() {
		minHeap = new PriorityQueue<>();
		set = new HashSet<>();

		int constantSize = 1000;
		for (int i = 1; i <= constantSize; i++) {
			minHeap.offer(i);
			set.add(i);
		}
	}

	public int popSmallest() {
		if (minHeap.isEmpty()) {
			return -1;
		}

		int value = minHeap.poll();
		set.remove(value);

		return value;
	}

	public void addBack(int num) {
		if (set.contains(num)) return;

		minHeap.offer(num);
		set.add(num);
	}
}
