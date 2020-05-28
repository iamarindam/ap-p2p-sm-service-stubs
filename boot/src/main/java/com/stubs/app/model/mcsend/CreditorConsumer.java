package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditorConsumer {

	private String number;

	@Size(max=70)
	private String firstName;
	
	@Size(max=70)
	private String lastName;
	
	@Size(max=70)
	private List<Object> addressLines = null;
	
//	@JsonFormat
//	  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	
	@Valid
	@NotNull
	private CredCustAccountDetails accountDetails;

	
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Object> getAddressLines() {
		return addressLines;
	}

	public void setAddressLines(List<Object> addressLines) {
		this.addressLines = addressLines;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public CredCustAccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(CredCustAccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}

}
