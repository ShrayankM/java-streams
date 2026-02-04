package org.example.streamQuestions;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberStreams {

	// Given List<Integer>, return the sum of even numbers.
	public Integer sumOfEvenNumbers(List<Integer> numbers) {
		return numbers.stream()
				.filter(i -> (i % 2 == 0))
				.mapToInt(i -> i)
				.sum();
	}

	// Given List<Integer>, return the sum of odd numbers.
	public Integer sumOfOddNumbers(List<Integer> numbers) {
		return numbers.stream()
				.filter(i -> (i % 2 == 1))
				.mapToInt(i -> i)
				.sum();
	}

//	Given List<Integer>, find the second-highest number.
	public Integer secondHighestNumber(List<Integer> numbers) {
		Optional<Integer> result = numbers.stream()
				.distinct()
				.sorted((a, b) -> Integer.compare(b, a))
				.skip(1)
				.findFirst();

		if (result.isPresent()) {
			return result.orElseThrow();
		} else {
			return null;
		}
	}

//	Convert List<List<Integer>> into a flat List<Integer>.
	public List<Integer> convertToFlatMap(List<List<Integer>> inputList) {
		return inputList.stream()
				.flatMap(integerList -> integerList.stream())
				.toList();
	}

//	Given List<Integer>, check if any number is divisible by 7.
	public boolean isDivisibleByNumber(List<Integer> numbers, int number) {
		return numbers.stream()
				.anyMatch(integer -> integer % number == 0);
	}

//	public List<Integer> findDuplicateIntegers(List<Integer> numbers) {
//		return numbers.stream()
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//				.entrySet().stream()
//				.filter(e -> e.getValue() > 1)
//				.map(Map.Entry::getKey)
//				.toList();
//	}

	//	Find duplicate elements in a list.
	public List<Integer> findDuplicateIntegers(List<Integer> numbers) {
		Set<Integer> seen = new HashSet<>();
		return numbers.stream()
				.filter(n -> !seen.add(n))  // add() returns false if already present
				.distinct()
				.toList();
	}

//	Partition a list of numbers into even and odd.
}
