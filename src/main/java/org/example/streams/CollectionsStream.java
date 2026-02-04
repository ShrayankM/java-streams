package org.example.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsStream {
	public static void main(String [] args) {

		// list
		List<Integer> numbers = IntStream.range(0, 10)
						.boxed()
						.toList();
		System.out.println("numbers = " + numbers);

		// set
		Set<Integer> evenNumber = IntStream.range(0, 20)
				.filter(i -> (i % 2 == 0))
				.boxed()
				.collect(Collectors.toSet());
		System.out.println("even numbers = " + evenNumber);


		// counting
		Collection<String> strings = List.of("one", "two", "three");

		long count = strings.stream().count();
		long countCollector = strings.stream().collect(Collectors.counting());

		String joined = IntStream.range(0, 20)
				.filter(i -> (i % 2 == 0))
				.mapToObj(Integer::toString)
				.collect(Collectors.joining("-", "[", "]"));

		System.out.println("Joined string = " + joined);

		Collection<String> numberStrings =
				List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
						"ten", "eleven", "twelve");

		// partitioningBy
		Map<Boolean, List<String>> booleanStringListMap = numberStrings.stream()
				.collect(Collectors.partitioningBy(s -> s.length() > 4));

		booleanStringListMap.forEach((key, value) -> System.out.println("Key {" + key + "}, value = " + value));

		// grouping by
		Function<String, Integer> lengthFunctionForString = String::length;
		Map<Integer, List<String>> lengthStringListMap = numberStrings.stream()
				.collect(Collectors.groupingBy(lengthFunctionForString));

		lengthStringListMap.forEach((key, value) -> System.out.println("Key {" + key + "}, value = " + value));

		Map<Integer, String> lengthCombinedStringMap = numberStrings.stream()
				.collect(Collectors.groupingBy(lengthFunctionForString, Collectors.joining(",")));
		lengthCombinedStringMap.forEach((key, value) -> System.out.println("Key {" + key + "}, value = " + value));

		List<User> users = List.of(
				new User("U1", "John"),
				new User("U2", "Rick"),
				new User("U3", "Alice")
		);

		Function<User, String> keyMapper = User::id;
		Function<User, User> valueMapper = user -> user;

		Map<String, User> userIdMap = users.stream()
				.collect(Collectors.toMap(keyMapper, valueMapper));

		userIdMap.forEach((key, value) -> System.out.println("Key {" + key + "}, value = " + value));

		Collection<String> numberStringsReturns =
				List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
						"ten", "eleven", "twelve");

		Function<String, Integer> keyLengthMapper = String::length;
		BinaryOperator<String> combineMapper = (a, b) -> a + ", " + b;
		Map<Integer, String> strLenListMap = numberStringsReturns.stream()
				.collect(Collectors.toMap(keyLengthMapper, str -> str, combineMapper));

		strLenListMap.forEach((key, value) -> System.out.println("Key {" + key + "}, value = " + value));
	}
}
