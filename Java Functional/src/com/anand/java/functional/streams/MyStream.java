package com.anand.java.functional.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyStream {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(new Person[] { 
						new Person("Anand", Gender.MALE), 
						new Person("Alice", Gender.FEMALE),
						new Person("Bob", Gender.MALE), 
						new Person("Bobby", Gender.PREFER_NOT_TO_SAY), 
						new Person("Alexa", Gender.FEMALE) 
				});
		
		System.out.println("Collected Output");

		Set<Gender> genders = people.stream()
			.map(person -> person.gender)
			.collect(Collectors.toSet());
		
		System.out.println(genders);

		System.out.println("For Each and ::"); 

		people.stream()
			.map(person -> person.gender)
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		System.out.println("For Each and Consumer Lamda");

		people.stream()
			.map(person -> person.gender)
			.collect(Collectors.toSet())
			.forEach(gender -> System.out.println(gender));
		
		Predicate<? super Person> femalesPredicate = 
				person -> Gender.FEMALE.equals(person.gender);
		
		boolean containsOnlyFemales = people.stream()
				.allMatch(femalesPredicate);
		
		boolean containsAnyFemales = people.stream()
				.anyMatch(femalesPredicate);
		
		Predicate<? super Person> preferNotToSayPredicate = 
				person -> Gender.PREFER_NOT_TO_SAY.equals(person.gender);
				
		boolean doNotContainPreferNotToSay = people.stream()
				.noneMatch(preferNotToSayPredicate );
		
		System.out.println("Contains Only Females: " + containsOnlyFemales);
		System.out.println("Contains Any Females: " + containsAnyFemales);
		System.out.println("Do Not Contain Prefer Not To Say: " + doNotContainPreferNotToSay);

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
		MALE, FEMALE, PREFER_NOT_TO_SAY;
	}
}
