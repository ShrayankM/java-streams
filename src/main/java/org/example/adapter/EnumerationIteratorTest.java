package org.example.adapter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class EnumerationIteratorTest {
	public static void main(String [] args) {
		Vector<String> names = new Vector<>();
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");

		Enumeration<String> enumeration = names.elements();
		Iterator<String> iterator = new EnumerationAdapter<>(enumeration);

		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());

		List<String> namesList = List.of("John", "Sam", "Max");
		Iterator<String> nameIterator = namesList.iterator();

		Enumeration<String> nameEnumeration = new IteratorAdapter<>(nameIterator);

		System.out.println(nameEnumeration.hasMoreElements());
		System.out.println(nameEnumeration.nextElement());

	}
}
