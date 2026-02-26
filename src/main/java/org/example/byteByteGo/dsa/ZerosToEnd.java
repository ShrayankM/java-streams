package org.example.byteByteGo.dsa;

import java.util.ArrayList;
import java.util.Arrays;

class ZerosToEnd {

	public static void main(String [] args) {
		shiftZerosToTheEnd(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 2, 3, 4, 5, 0, 0, 0, 6, 0, 7, 8, 0, 9)));
	}

	public static void shiftZerosToTheEnd(ArrayList<Integer> nums) {
		// Write your code here

		int i = 0, j = 0;
		while (j < nums.size()) {
			if (nums.get(j) != 0) {
				nums.set(i, nums.get(j));
				i++;
			}

			j++;
		}

		while (i < nums.size()) {
			nums.set(i, 0);
			i++;
		}
	}
}
