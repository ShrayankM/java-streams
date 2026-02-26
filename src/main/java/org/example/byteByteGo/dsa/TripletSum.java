package org.example.byteByteGo.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletSum {
	public static void main(String [] args) {
		triplet_sum(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
	}

	public static ArrayList<ArrayList<Integer>> triplet_sum(ArrayList<Integer> nums) {
		nums.sort(Integer::compareTo);

		Set<ArrayList<Integer>> resultSet = new HashSet<>();

		for (int i = 0; (i < nums.size() && nums.get(i) <= 0); i++) {
			int a = nums.get(i);

			if (i > 0 && nums.get(i).equals(nums.get(i - 1))) {
				continue;
			}

			int j = i + 1, k = nums.size() - 1;
			int target = a * -1;

			while (j < k) {
				if (j > i + 1 && nums.get(j).equals(nums.get(j - 1))) j++;

				int currentSum = nums.get(j) + nums.get(k);
				if (currentSum == target) {
					resultSet.add(new ArrayList<>(Arrays.asList(a, nums.get(j), nums.get(k))));
				}

				if (currentSum > target) k--;
				else j++;
			}
		}
		return new ArrayList<>(resultSet);
	}
}


/**
 * Triplet Sum
 * Medium
 * Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0 . The solution must not contain duplicate triplets (e.g., [1, 2, 3] and [2, 3, 1] are considered duplicates). If no such triplets are found, return an empty array.
 *
 * Each triplet can be arranged in any order, and the output can be returned in any order.
 *
 * Example:
 * Input: nums = [0, -1, 2, -3, 1]
 * Output: [[-3, 1, 2], [-1, 0, 1]] */
