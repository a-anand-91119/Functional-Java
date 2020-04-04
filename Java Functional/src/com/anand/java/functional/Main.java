package com.anand.java.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Person> people = Arrays
				.asList(new Person[] { 
						new Person("Anand", Gender.MALE), 
						new Person("Alice", Gender.FEMALE),
						new Person("Bob", Gender.MALE), 
						new Person("Alexa", Gender.FEMALE) 
				});
		
		System.out.println("Imperative Approach");
		
		List<Person> females = new ArrayList<>();
		
		for(Person person : people) {
			if(Gender.FEMALE.equals(person.gender))
				females.add(person);
		}
		
		for(Person female : females) {
			System.out.println(female);
		}
		
		System.out.println("Declarative Approach");
		
		people.stream().filter(person -> Gender.FEMALE.equals(person.gender)).forEach(System.out::println);
	}

	static class Person {
		private final String name; 
		private final Gender gender;

		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}

	}

	enum Gender {
		MALE, FEMALE;
	}
}
