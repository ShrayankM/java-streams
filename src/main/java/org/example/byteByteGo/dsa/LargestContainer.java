package org.example.byteByteGo.dsa;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestContainer {
	public static void main(String [] args) {
		System.out.println(largest_container(new ArrayList<>(Arrays.asList(2, 7, 8, 3, 7, 6))));
	}

	public static int largest_container(ArrayList<Integer> heights) {
		// Write your code here

		if (heights.isEmpty()) return 0;

		int i = 0, j = heights.size() - 1;
		int largestContainer = (j - i) * Math.min(heights.get(i), heights.get(j));

		while (i < j) {
			if (heights.get(i) > heights.get(j)) j--;
			else i++;

			largestContainer = Math.max(largestContainer, (j - i) * Math.min(heights.get(i), heights.get(j)));
		}

		return largestContainer;
	}
}
