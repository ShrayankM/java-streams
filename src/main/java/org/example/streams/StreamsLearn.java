package org.example.streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsLearn {

	public static void main(String [] args) {
		List<String> strList = List.of("one", "two", "three", "four", "five");
		Map<Integer, List<String>> strCountListMap = strList.stream()
				.collect(Collectors.groupingBy(String::length,
						Collectors.mapping(Function.identity(), Collectors.toList())));
		strCountListMap.forEach((key, value) -> System.out.println(key + "::" + value));

		// find total sales in october
		List<Sale> salesList = List.of(
				new Sale("orange", LocalDate.of(2022, Month.JANUARY, 2), 4),
				new Sale("pumpkin", LocalDate.of(2022, Month.OCTOBER, 18), 12),
				new Sale("butternut", LocalDate.of(2022, Month.OCTOBER, 3), 6),
				new Sale("apple", LocalDate.of(2022, Month.AUGUST, 28), 3)
		);

		int salesInOctober = salesList.stream().filter(s -> s.date().getMonth().equals(Month.OCTOBER))
				.mapToInt(Sale::amount).sum();
		System.out.println("Sales in October = " + salesInOctober);


		// find sum of residents in cities with population more than 100_000
		List<City> cityList = List.of(
				new City("Pune", 100_100),
				new City("Mumbai", 200_000),
				new City("Nagpur", 50_000)
		);

		int residentsSum = cityList.stream()
				.filter(city -> city.population() > 100_000)
				.mapToInt(City::population).sum();

		System.out.println("Residents sum = " + residentsSum);

		List<String> numbersList = List.of("one", "two", "three", "four", "five");

		// mapping
		Function<String, Integer> lengthFunction = String::length;

		// filtering
		Predicate<String> lengthCondition = s -> s.length() > 3;

		List<Integer> numberLengthCountList = numbersList.stream()
				.filter(lengthCondition)
				.map(lengthFunction)
				.toList();

		numberLengthCountList.forEach(i -> System.out.print(i + ", "));
		System.out.println();

		// flat-map example
		City newYork= new City("New York", 8_258);
		City losAngeles = new City("Los Angeles", 3_821);
		Country usa = new Country("USA", List.of(newYork, losAngeles));

		City london = new City("London", 8_866);
		City manchester = new City("Manchester", 568);
		Country uk = new Country("United Kingdom", List.of(london, manchester));

		City paris = new City("Paris", 2_103);
		City marseille = new City("Marseille", 877);
		Country france = new Country("France", List.of(paris, marseille));

		List<Country> countries = List.of(usa, uk, france);

		int totalPopulation = countries.stream()
				.flatMap(country -> country.cities().stream())
				.mapToInt(City::population).sum();
		System.out.println("Total population = [" + totalPopulation + "]");

		// Map-multi map example
		List<String> mayBeNumbers = List.of("1", "oii", "2", "pp", "3", "44");

		// filter-function
		Predicate<String> checkIfNumber = string -> {
			try {
				Integer.parseInt(string);
				return true;
			} catch (Exception exp) {
				System.out.println("String in argument is not a number");
			}
			return false;
		};

		// map-function
		Function<String, Integer> convertToNumber = Integer::parseInt;

		// flat-map function
		Function<String, Stream<Integer>> convertToIntegerStream = string -> {
			try {
				return Stream.of(Integer.parseInt(string));
			} catch (NumberFormatException ignored) {
			}
			return Stream.empty();
		};

//		List<Integer> actualNumbers = mayBeNumbers.stream()
//				.filter(checkIfNumber)
//				.map(convertToNumber)
//				.toList();

		List<Integer> actualNumbers = mayBeNumbers.stream()
				.flatMap(convertToIntegerStream)
				.toList();

		actualNumbers.forEach(number -> System.out.print(number + " "));
		System.out.println();

		BiConsumer<String, Consumer<Integer>> convertToIntegerConsumer = (string, consumer) -> {
			try {
				consumer.accept(Integer.parseInt(string));
			} catch (NumberFormatException ignored) {}
		};

		// multi-map
		actualNumbers = mayBeNumbers.stream()
				.mapMulti(convertToIntegerConsumer)
				.toList();

		actualNumbers.forEach(number -> System.out.print(number + " "));
		System.out.println();

		// distinct
		List<Integer> ints = List.of(1, 4, 2, 1, 3, 3);

		List<Integer> distinctInts = ints.stream().distinct().toList();

		System.out.println("Distinct ints");
		distinctInts.forEach(i -> System.out.print(i + " "));
		System.out.println();

		List<Integer> reverseSortedInts = ints.stream()
				.sorted((i, j) -> Integer.compare(j, i)).toList();

		System.out.println("Reverse sorted ints");
		reverseSortedInts.forEach(i -> System.out.print(i + " "));

//		Function<Integer, Integer> iterateFunction = i -> i + 1;

		IntUnaryOperator iterateFunction = i -> i + 1;

		// limit & unbound streams
		int [] unboundInts = IntStream.iterate(0, iterateFunction)
				.map(i -> i / 3)
				.distinct()
				.limit(10)
				.toArray();

		System.out.println("Unbound ints");
		for (int unboundInt : unboundInts) {
			System.out.print(unboundInt + " ");
		}
		System.out.println();
	}
}
