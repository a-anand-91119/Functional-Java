package com.anand.java.functional.functionalinterface;

import java.util.function.Supplier;

public class MySupplier {

	public static void main(String[] args) {
		
		// Normal Java Method
		System.out.println("Normal Java Method");
		System.out.println(getDBConnectionURL());
		
		// Supplier Functional Interface
		System.out.println("Supplier Functional Interface");
		System.out.println(getDBConnectionURLSupplier.get());
	}
	
	//Supplier
	static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localhost:5432/users";
	
	static String getDBConnectionURL() {
		return "jdbc://localhost:5432/users";
	}
}
