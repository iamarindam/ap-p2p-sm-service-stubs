package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sender {
	
	public String getAccountUri() {
		return accountUri;
	}
	public void setAccountUri(String accountUri) {
		this.accountUri = accountUri;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCountryOfBirth() {
		return countryOfBirth;
	}
	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDigitalAccountReferenceNumber() {
		return digitalAccountReferenceNumber;
	}
	public void setDigitalAccountReferenceNumber(String digitalAccountReferenceNumber) {
		this.digitalAccountReferenceNumber = digitalAccountReferenceNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getGovernmentIdUris() {
		return governmentIdUris;
	}
	public void setGovernmentIdUris(String[] governmentIdUris) {
		this.governmentIdUris = governmentIdUris;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String accountUri;
	private Address address;
	private String countryOfBirth;
	private String dateOfBirth;
	private String digitalAccountReferenceNumber;
	private String email;
	private String[] governmentIdUris;
	private String name;
	private String nationality;
	private String phone;
}
