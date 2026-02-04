package org.example.streamQuestions;

import java.util.List;
import java.util.Map;

public class EasyStreamQuestions {
	public static void main(String [] args) {
		NumberStreams numberStreams = new NumberStreams();
		StringStreams stringStreams = new StringStreams();
		ObjectStreams objectStreams = new ObjectStreams();

		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("Sum of even numbers = " + numberStreams.sumOfEvenNumbers(numbers));
		System.out.println("Sum of odd numbers = " + numberStreams.sumOfOddNumbers(numbers));

		List<String> strings = List.of("swim", "dance", "apple", "eye", "iron", "union", "test", "program");
		System.out.println("All strings starting with vowels = " + stringStreams.stringsThatStartWithVowel(strings));

		System.out.println("String (key), Length (value) map");
		Map<String, Integer> keyValueMap = stringStreams.convertStringListToMap(strings);
		keyValueMap.forEach((key, value) -> System.out.println(key + "::" + value));

		System.out.println("Second highest number = " + numberStreams.secondHighestNumber(numbers));

		System.out.println("Remove duplicates = " + objectStreams.removeDuplicates(List.of(1, 1, 2, 3, 4, 5, 5, 5)));

		System.out.println("Get character frequency map = " + stringStreams.getCharacterFrequencyMap("free-solo"));

		List<Employee> employees = DataConstants.employees;

		int salaryThreshold = 90_000;
		System.out.println("Employees with salary greater than {" + salaryThreshold + "} = "
				+ objectStreams.employeeNamesWithSalary(employees, salaryThreshold));

		List<List<Integer>> listOfLists = List.of(
				List.of(1, 2, 3),
				List.of(4, 5, 6),
				List.of(7, 8, 9)
		);

		System.out.println("Flat map = " + numberStreams.convertToFlatMap(listOfLists));

		int divisibleNumber = 7;
		List<Integer> divisibleNumbersCheck = List.of(8, 1, 7);
		System.out.println("Is any number divisible by [" + divisibleNumber + "], "
				+ numberStreams.isDivisibleByNumber(divisibleNumbersCheck, divisibleNumber));
	}
}
