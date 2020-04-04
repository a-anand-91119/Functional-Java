package com.anand.java.functional.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MyFunction {

	public static void main(String[] args) {
		
		// Function Examples
		// takes one argument and produces one result
		
		System.out.println("FUNCTIONS EXAMPLES");
		
		int increment = incrementByOne(2);
		System.out.println(increment);
		
		int increment2 = incrementByOneFunction.apply(2);
		System.out.println(increment2);
		
		int multiply = mulitplyByTenFunction.apply(10);
		System.out.println(multiply);
		
		Function<Integer, Integer> incrementByOneAndThenMultiplyByTenFunction = 
				incrementByOneFunction.andThen(mulitplyByTenFunction);
		
		int incrementAndMultiply = incrementByOneAndThenMultiplyByTenFunction.apply(2);
		System.out.println(incrementAndMultiply);
		
		System.out.println(incrementByOneFunction
				.andThen(mulitplyByTenFunction)
				.andThen(incrementByOneFunction)
				.apply(1));
		
		// Bi-Functions Examples
		// takes two arguments and produces one result
		System.out.println("BI FUNCTIONS EXAMPLE");
		
		System.out.println(incrementByOneAndMultiply(9, 10));
		
		System.out.println(incrmentByOneAndMultiplyFunction.apply(9, 10));
		
	}
	
	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
	
	static Function<Integer, Integer> mulitplyByTenFunction = number -> number * 10;
	
	static BiFunction<Integer, Integer, Integer> incrmentByOneAndMultiplyFunction = 
			(increment, mulitplyBy) -> (increment + 1) * mulitplyBy;
	
	static int incrementByOne(int number) {
		return number + 1;
	}
	
	static int incrementByOneAndMultiply(int incrment, int multiplyBy) {
		return (incrment + 1) * multiplyBy;
	}
}
