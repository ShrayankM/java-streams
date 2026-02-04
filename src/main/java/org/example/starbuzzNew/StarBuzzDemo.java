package org.example.starbuzzNew;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StarBuzzDemo {
	public static void main(String [] args) {

		Beverage coffee = new Coffee();
		coffee.prepareRecipe();

		Beverage tea = new Tea();
		tea.prepareRecipe();

		List<Integer> integerList = new ArrayList<>();
		integerList.add(10);
		integerList.add(20);
		integerList.add(30);

		integerList.sort((a, b) -> b - a);

		Integer [] sortedReverse = {10, 20, 30};
		Arrays.sort(sortedReverse, (Integer a, Integer b) -> Integer.compare(b, a));

//		for (int n : sortedReverse) {
//			System.out.print(n + " ");
//		}

		Duck [] ducksList = {
				new Duck("d1", 10, 12),
				new Duck("d2", 12, 34),
				new Duck("d3", 10, 14)
		};

		Arrays.sort(ducksList);
		for (Duck duck : ducksList) {
			System.out.println(duck);
		}
	}
}
