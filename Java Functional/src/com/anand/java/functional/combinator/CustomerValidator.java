package com.anand.java.functional.combinator;

import java.time.LocalDate;

import com.anand.java.functional.combinator.CustomerValidatorFunctionalService.*;

public class CustomerValidator {

	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setName("Anand");
		customer.setEmailAddress("ASD@ASD.com");
		customer.setPhoneNumber("111111111");
		customer.setDateOfBirth(LocalDate.of(2015, 1, 1));
		
		boolean isCustomerValid = new CustomerValidatorService().isCustomerValid(customer);
		System.out.println(isCustomerValid);
		
		ValidationResult result = CustomerValidatorFunctionalService.isValidEmail()
			.and(CustomerValidatorFunctionalService.isPhoneNumberValid())
			.and(CustomerValidatorFunctionalService.isAdult())
			.apply(customer);
		
		System.out.println(result);

		result = CustomerValidatorFunctionalService.isValidEmail()
				.and(CustomerValidatorFunctionalService.isPhoneNumberValid())
				.or(CustomerValidatorFunctionalService.isAdult())
				.apply(customer);
		
		System.out.println(result);
	}
}
