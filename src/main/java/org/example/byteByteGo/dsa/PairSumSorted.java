package org.example.byteByteGo.dsa;

import java.util.ArrayList;
import java.util.Arrays;

public class PairSumSorted {

	public static void main(String [] args) {
	}

	public static ArrayList<Integer> pair_sum_sorted(ArrayList<Integer> nums, int target) {
		int i = 0, j = nums.size() - 1;

		ArrayList<Integer> result = new ArrayList<>();

		while (i < j) {
			int currentSum = nums.get(i) + nums.get(j);

			if (currentSum == target) {
				result.add(i);
				result.add(j);
				return result;
			}

			if (currentSum > target) j--;
			else i++;
		}
		return result;
	}
}


/**
 * Pair Sum - Sorted
 * Easy
 * Given an array of integers sorted in ascending order and a target value, return the indexes of any pair of numbers in the array that sum to the target. The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.
 *
 * Example 1:
 * Input: nums = [-5, -2, 3, 4, 6], target = 7
 * Output: [2, 3]
 * Explanation: nums[2] + nums[3] = 3 + 4 = 7
 *
 * Example 2:
 * Input: nums = [1, 1, 1], target = 2
 * Output: [0, 1]
 * Explanation: other valid outputs could be [1, 0], [0, 2], [2, 0], [1, 2] or [2, 1].*/
