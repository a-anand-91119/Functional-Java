package com.anand.java.functional.functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MyPredicate {

	public static void main(String[] args) {
		
		//Normal Java Methods
		System.out.println("Normal Java Methods");
		System.out.println(isPhoneNumberValid("12003654789"));
		System.out.println(isPhoneNumberValid("1200365479"));
		System.out.println(isPhoneNumberValid("13003654479"));
		System.out.println(isPhoneNumberValid("1300365479"));
	
		// Java Predicate Function Interface Example
		System.out.println("Predicates Example");
		System.out.println(isPhoneNumberValidPredicate.test("12003654789"));
		System.out.println(isPhoneNumberValidPredicate.test("1200365479"));
		System.out.println(isPhoneNumberValidPredicate.test("13003654479"));
		System.out.println(isPhoneNumberValidPredicate.test("1300365479"));
	
		// Combining Predicates with AND and OR
		System.out.println("Combining Predicate");
		System.out.println("Phone Number Is Valid AND Contains 3");
		System.out.println(isPhoneNumberValidPredicate.and(containsNumberThreePredicate).test("12003654789"));
		System.out.println(isPhoneNumberValidPredicate.and(containsNumberThreePredicate).test("123654789"));
		System.out.println(isPhoneNumberValidPredicate.and(containsNumberThreePredicate).test("12005654789"));
	
		System.out.println("Phone Number Is Valid OR Contains 3");
		System.out.println(isPhoneNumberValidPredicate.or(containsNumberThreePredicate).test("12003654789"));
		System.out.println(isPhoneNumberValidPredicate.or(containsNumberThreePredicate).test("12004654789"));
	
		// Bi-Predicates
		System.out.println("Bi-Predicates Example");
		System.out.println(isPhoneNumberValidAndContainsNumberBiPredicate.test("12004654789", "9"));
		System.out.println(isPhoneNumberValidAndContainsNumberBiPredicate.test("12004654788", "9"));
	}
	
	
	// Predicate Functional Interface
	static Predicate<String> isPhoneNumberValidPredicate = 
			phoneNumber -> phoneNumber.length() == 11 && phoneNumber.startsWith("12");
	
	static Predicate<String> containsNumberThreePredicate = phoneNumber -> phoneNumber.contains("3");
	
	// Bi-Predicate
	static BiPredicate<String, String> isPhoneNumberValidAndContainsNumberBiPredicate = 
			(phoneNumber, numberToContain) -> 
					phoneNumber.length() == 11 && 
					phoneNumber.startsWith("12") && 
					phoneNumber.contains(numberToContain);
	
	// Normal Java Method
	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.length() == 11 && phoneNumber.startsWith("12");
	}
}
