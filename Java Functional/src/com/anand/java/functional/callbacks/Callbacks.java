package com.anand.java.functional.callbacks;

import java.util.function.Consumer;

public class Callbacks {

	public static void main(String[] args) {

		callbackTest("Anand", "A", null);
		callbackTest("Anand", "A", value -> System.out.println("no last name provided for " + value));
		callbackTest("Anand", null, value -> System.out.println("no last name provided for " + value));
		callbackTestRunnable("Anand", null, () -> System.out.println("no last name provided"));
	}

	static void callbackTest(String firstName, String lastName, Consumer<String> callback) {
		System.out.print(firstName + " ");
		
		if (lastName != null) {
			System.out.println(lastName);
		} else {
			System.out.println();
			callback.accept(firstName);
		}
	}
	
	static void callbackTestRunnable(String firstName, String lastName, Runnable callback) {
		System.out.print(firstName + " ");
		
		if (lastName != null) {
			System.out.println(lastName);
		} else {
			System.out.println();
			callback.run();
		}
	}
}
