package org.example.streams;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceStreams {
	public static void main(String [] args) {

		// sum
		Stream<Integer> sumInts = Stream.of(3, 6, 2, 1);
		int sum = sumInts.reduce(0, Integer::sum);
		System.out.println("Sum = [" + sum + "]");

		// product
		Stream<Integer> multiplyInts = Stream.of(3, 6, 2, 1);
		int product = multiplyInts.reduce(1, (a, b) -> a * b);
		System.out.println("Product = [" + product + "]");

		// min
		Stream<Integer> minInts = Stream.of(3, 6, 2, 1);
		Optional<Integer> min = minInts.reduce((i, j) -> i < j ? i : j);

		if (min.isPresent()) {
			System.out.println("Min = [" + min.orElseThrow() + "]");
		} else {
			System.out.println("no result computed");
		}

		// max
		Stream<Integer> maxInts = Stream.of(3, 6, 2, 1);
		Optional<Integer> max = maxInts.reduce((i, j) -> i > j ? i : j);

		if (max.isPresent()) {
			System.out.println("Max = [" + max.orElseThrow() + "]");
		} else {
			System.out.println("no result computed");
		}
	}
}
