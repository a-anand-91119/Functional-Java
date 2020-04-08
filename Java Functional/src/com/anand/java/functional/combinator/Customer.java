package com.anand.java.functional.combinator;

import java.time.LocalDate;

public class Customer {

	private String name;
	private String phoneNumber;
	private String emailAddress;
	private LocalDate dateOfBirth;

	public Customer() {
		super();
	}

	public Customer(String name, String phoneNumber, String emailAddress, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

}
