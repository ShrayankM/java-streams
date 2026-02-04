package org.example.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreateStreams {
	public static void main(String [] args) {

		// iterator method to create streams
		Spliterator<Integer> integerSpliterator =
				Spliterators.spliterator(intIterator, 10, 0);

		Stream<Integer> integerStream = StreamSupport.stream(integerSpliterator, false);
		List<Integer> integerList = integerStream.toList();

		System.out.println("Integer list");
		integerList.forEach(i -> System.out.print(i + " "));
		System.out.println();

		// empty streams
		Stream<Integer> emptyIntegerStream = Stream.empty();

		// non-empty streams
		Stream<Integer> nonEmptyIntegerStream = Stream.of(1, 2, 3, 4);

		Stream<String> nonEmptyStringStream = Arrays.stream(new String[]{"john", "Mark", "Alice"});
		List<String> listOfStrings = nonEmptyStringStream.toList();

		listOfStrings.forEach(s -> System.out.print(s + " "));
		System.out.println();
	}

	public static Iterator<Integer> intIterator = new Iterator<>() {
		private int index = 0;
		@Override
		public boolean hasNext() {
			return index < 20;
		}

		@Override
		public Integer next() {
			return index = index + 2;
		}
	};
}
