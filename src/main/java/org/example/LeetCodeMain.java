package org.example;

public class LeetCodeMain {
	public static void main(String [] args) {
		System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int left = 1, right = 0;

		for (int pile : piles) right = Math.max(right, pile);
		int currentMinK = right;

		while (left <= right) {
			int k = (right + left) / 2;

			if (isKSpeedEnough(piles, k, h)) {
				currentMinK = Math.min(currentMinK, k);
				right = k - 1;
			} else {
				left = k + 1;
			}
		}
		return currentMinK;
	}

	private static boolean isKSpeedEnough(int [] piles, int k, int hoursAvailable) {
		long hours = 0;

		for (int pile : piles) {
			hours = hours + (pile / k);
			if (pile % k != 0) hours++;
		}

		return hours <= hoursAvailable;
	}
}

