package com.anand.java.functional.optional;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		Object value = Optional.ofNullable(null)
			.orElse("orElse");
		
		System.out.println(value);
		
		Optional.ofNullable("Anand")
			.ifPresent(val -> System.out.println(val + " is my name"));
		
		Optional.ofNullable(null)
			.ifPresent(val -> System.out.println(val + " is my name"));
		
		Object res = Optional.ofNullable(null)
			.orElseGet(() -> "orElseGet - null");
		System.out.println(res);
		
		Object res1 = Optional.ofNullable("val")
			.orElseGet(() -> "orElseGet - val");
		System.out.println(res1);
		res1 = Optional.ofNullable(null)
				.orElseGet(() -> "orElseGet - val");
		System.out.println(res1);
		
		try {
			Optional.ofNullable("Not Null")
				.orElseThrow(() -> new IllegalStateException());
			
			Optional.ofNullable(null)
				.orElseThrow(() -> new IllegalStateException("Null Provided"));
		}catch(IllegalStateException e) {
			System.out.println("Exception " + e.getMessage() + " Caught");
		}
		
		Optional<Integer> result = Optional.ofNullable("Anand")
			.map( val -> val.length());
		
		if(result.isPresent())
			System.out.println(result.get());
		else
			System.out.println("No Value Provided");
		
		Optional<Integer> result1 = Optional.ofNullable("")
				.map( val -> val.length());
			
		if(result1.isPresent())
			System.out.println(result1.get());
		else
			System.out.println("No Value Provided");
		
		Optional<Integer> result2 = Optional.ofNullable(null)
				.map( val -> ((String) val).length());
			
		if(result2.isPresent())
			System.out.println(result2.get());
		else
			System.out.println("No Value Provided");
	}
}
