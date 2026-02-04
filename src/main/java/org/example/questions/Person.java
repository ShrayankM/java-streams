package org.example.questions;

import lombok.Getter;

@Getter
public class Person {
	private String code;
	private String desgination;
	private String name;

	public Person(String code, String desgination, String name) {
		this.code = code;
		this.desgination = desgination;
		this.name = name;
	}
}
