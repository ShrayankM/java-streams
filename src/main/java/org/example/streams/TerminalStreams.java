package org.example.streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalStreams {
	public static void main(String [] args) {
		List<String> stringList = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

		long count = stringList.stream().filter(s -> s.length() == 3).count();
		System.out.println("count of size 3 elements = [" + count + "]");

		List<String> upperCaseStringList = stringList.stream()
				.filter(s -> s.length() == 3)
				.map(String::toUpperCase)
				.collect(Collectors.toCollection(ArrayList::new));

		upperCaseStringList.add("SEVEN");
		System.out.println("Uppercase string list = " + upperCaseStringList);

		Stream<Integer> integerStream = IntStream.range(0, 50).boxed();
		List<String> stringArrayList = integerStream.map(i -> Integer.toString(i))
				.collect(Collectors.toCollection(() -> new ArrayList<>(60)));

		System.out.println("String array list = " + stringArrayList);

		// immutable lists
		List<String> immutableStringList = stringList.stream()
				.filter(s -> s.length() == 3)
				.map(String::toUpperCase)
				.collect(Collectors.toUnmodifiableList());

		// not allowed
//		immutableStringList.add("EIGHT");

		Stream<String> strings = Stream.of("one", "four", "seven", "nine");
		Optional<String> longest = strings.max(Comparator.comparing(String::length));

		if (longest.isPresent()) {
			System.out.println("Longest str is = " + longest.orElseThrow());
		} else {
			System.out.println("No data computed");
		}

		Collection<String> numberStrings =
				List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

		Optional<String> first = numberStrings.stream()
//				.unordered()
				.parallel()
				.filter(s -> s.length() == 3)
				.findFirst();

		if (first.isPresent()) {
			System.out.println("First str is = " + first.orElseThrow());
		} else {
			System.out.println("No data computed");
		}

		// blank check predicate
		Predicate<String> isBlankCheck = string -> !string.isBlank();
		boolean noBlank = numberStrings.stream()
				.allMatch(isBlankCheck);

		// Length 3 check predicate
		Predicate<String> isLengthThree = string -> string.length() == 3;
		boolean lengthThress = numberStrings.stream()
				.anyMatch(isLengthThree);

		// Length 10 check predicate
		Predicate<String> isLengthGreaterThanTen = string -> string.length() > 10;
		boolean noneGreaterThanTen = numberStrings.stream()
				.noneMatch(isLengthGreaterThanTen);

		System.out.println("No blank = " + noBlank + ", Any have length 3 = " + lengthThress + ", No Greater than 10 = " + noneGreaterThanTen);
	}
}
