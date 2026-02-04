package org.example.questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DemoMain {
	public static void main(String [] args) {
		Map<String, List<Person>> designationPersonListMap = new HashMap<>();

		Person p1 = new Person("P1", "sde", "John");
		Person p2 = new Person("P2", "sde", "Mark");
		Person p3 = new Person("P3", "manager", "Rick");

		List<Person> personList = List.of(p1, p2, p3);

		// filter-function
		Predicate<Person> personDesignationFilter = person -> person.getDesgination().equals("sde");

		List<Person> sdePersonList = personList.stream()
				.filter(personDesignationFilter)
				.toList();

		Map<String, List<Person>> personDesignationmap = new HashMap<>();
		personDesignationmap.put("sde", sdePersonList);

		designationPersonListMap = personList.stream()
				.collect(Collectors.groupingBy(Person::getDesgination, Collectors.mapping(Function.identity(), Collectors
						.toList())));

	}
}
