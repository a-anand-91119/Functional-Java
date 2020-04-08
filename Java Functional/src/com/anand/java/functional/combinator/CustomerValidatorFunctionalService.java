package com.anand.java.functional.combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import com.anand.java.functional.combinator.CustomerValidatorFunctionalService.ValidationResult;

public interface CustomerValidatorFunctionalService extends Function<Customer, ValidationResult> {

	static CustomerValidatorFunctionalService isValidEmail() {
		return customer -> {
			System.out.println("Checking Valid Email");
			return customer.getEmailAddress().contains("@") 
				? ValidationResult.SUCCESS
				: ValidationResult.INVALID_EMAIL_ADDRESS;
		};
	}

	static CustomerValidatorFunctionalService isPhoneNumberValid() {
		return customer -> {
			System.out.println("Checking Phone Number");
			return customer.getPhoneNumber().length() == 10 
				? ValidationResult.SUCCESS
				: ValidationResult.INVALID_PHONE_NUMBER;
		};
	}

	static CustomerValidatorFunctionalService isAdult() {
		return customer -> {
			System.out.println("Checking Adult Or Not");
			return Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears() > 20
				? ValidationResult.SUCCESS
				: ValidationResult.NO_A_VALID_ADULT;
		};
	}
	
	default CustomerValidatorFunctionalService and(CustomerValidatorFunctionalService next) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.name().equals(ValidationResult.SUCCESS.name()) 
					? next.apply(customer) 
					: result; 
		};
	}
	
	default CustomerValidatorFunctionalService or(CustomerValidatorFunctionalService next) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return !result.name().equals(ValidationResult.SUCCESS.name())
					? next.apply(customer) 
					: result;
		};
	}

	enum ValidationResult {
		SUCCESS, INVALID_EMAIL_ADDRESS, INVALID_PHONE_NUMBER, NO_A_VALID_ADULT
	}
}
