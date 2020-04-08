package com.anand.java.functional.combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

	private boolean isValidEmail(String email) {
		return email.contains("@");
	}

	private boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.length() == 10;
	}

	private boolean isAdult(LocalDate dateOfBirth) {
		return Period.between(dateOfBirth, LocalDate.now()).getYears() > 21;
	}
	
	public boolean isCustomerValid(Customer customer) {
		return isValidEmail(customer.getEmailAddress()) && 
				isPhoneNumberValid(customer.getPhoneNumber()) && 
				isAdult(customer.getDateOfBirth());
	}
}
