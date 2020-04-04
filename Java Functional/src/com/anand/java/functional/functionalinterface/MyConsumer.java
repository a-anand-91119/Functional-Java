package com.anand.java.functional.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MyConsumer {

	public static void main(String[] args) {

		// normal java functions
		greetCustomer(new Customer("Maria", "123456"));
		greetCustomerV2(new Customer("Maria", "123456"), true);
		greetCustomerV2(new Customer("Maria", "123456"), false);
		
		// CONSUMER EXAMPLES
		// accepts one argument and returns nothing		
		greetCustomerConsumer.accept(new Customer("Anand", "987654"));
		
		// BI-CONSUMER EXAMPLES
		// accepts two input arguments and returns nothing
		greetCustomerConsumerV2.accept(new Customer("Anand", "123456"), true);
		greetCustomerConsumerV2.accept(new Customer("Anand", "123456"), false);
	}

	// Functional Interface
	static Consumer<Customer> greetCustomerConsumer = 
			customer -> System.out.println("Hello " + customer.customerName
			+ ". Thanks For Registering Your Phone Number: " + customer.customerPhoneNumber);
	// Functional Interface
	static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = 
			(customer, showPhoneNumber) -> System.out.println("Hello " + customer.customerName
					+ ". Thanks For Registering Your Phone Number: " 
					+ (showPhoneNumber ? customer.customerPhoneNumber : "*****"));
			
	// Normal Java Method
	static void greetCustomer(Customer customer) {
		System.out.println("Hello " + customer.customerName + ". Thanks For Registering Your Phone Number: "
				+ customer.customerPhoneNumber);
	}
	
	static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
		System.out.println("Hello " + customer.customerName + ". Thanks For Registering Your Phone Number: "
				+ (showPhoneNumber ? customer.customerPhoneNumber : "*****"));
	}

	static class Customer {
		private final String customerName;
		private final String customerPhoneNumber;

		public Customer(String customerName, String customerPhoneNumber) {
			super();
			this.customerName = customerName;
			this.customerPhoneNumber = customerPhoneNumber;
		}

		@Override
		public String toString() {
			return "Customer [customerName=" + customerName + ", customerPhoneNumber=" + customerPhoneNumber + "]";
		}

	}
}
