package org.example.streamQuestions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringStreams {

//	From List<String>, return all strings that start with a vowel, sorted by length.
	public List<String> stringsThatStartWithVowel(List<String> strings) {
		Predicate<String> isStartingWithVowel = string -> {
			List<Character> vowelCharacters = List.of('a', 'e', 'i', 'o', 'u');
			string = string.toLowerCase();
			if (string.isBlank()) {
				return false;
			}

			return vowelCharacters.contains(string.charAt(0));
		};

		// descending sort by length
		Comparator<String> stringLengthComparator = (a, b) -> Integer.compare(b.length(), a.length());

		return strings.stream()
				.filter(isStartingWithVowel)
				.sorted(stringLengthComparator)
				.toList();
	}


//	Convert List<String> to Map<String, Integer> where value = string length.
	public Map<String, Integer> convertStringListToMap(List<String> strings) {
		return strings.stream()
				.collect(
						Collectors.toMap(s -> s, String::length)
				);
	}

//	Count frequency of each character in a string.
	public Map<Character, Long> getCharacterFrequencyMap(String string) {
//		List<Character> characterList = new ArrayList<>();
//		for (int i = 0; i < string.length(); i++) {
//			characterList.add(string.charAt(i));
//		}
//
//		return characterList.stream()
//				.collect(Collectors.groupingBy(character -> character, Collectors.counting()));

		return string.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(character -> character, Collectors.counting()));
	}

//	Find the first non-repeating character in a string.

//	Find the longest string
	public String getLongestStringFromString(List<String> strings) {
		return strings.stream()
				.max(Comparator.comparingInt(String::length))
				.orElse(null);  // or orElseThrow() if you want an exception
	}

	//	Given List<String>, return a map of word → occurrence count.
	public Map<String, Integer> wordFrequencyMap(List<String> strings) {
		return strings.stream()
				.collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
	}
}
