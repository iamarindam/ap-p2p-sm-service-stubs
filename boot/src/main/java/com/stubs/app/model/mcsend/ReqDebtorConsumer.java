package com.stubs.app.model.mcsend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.validation.annotation.Validated;

/**
 * ReqDebtorConsumer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-11T09:59:28.047Z[GMT]")
public class ReqDebtorConsumer {
	private String number = null;

	private String firstName = null;

	private String lastName = null;

	private List<Object> addressLines = new ArrayList<Object>();

	private Date birthDate = null;

	private ReqDedtCustAccountDetails accountDetails = null;

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the addressLines
	 */
	public List<Object> getAddressLines() {
		return addressLines;
	}

	/**
	 * @param addressLines the addressLines to set
	 */
	public void setAddressLines(List<Object> addressLines) {
		this.addressLines = addressLines;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the accountDetails
	 */
	public ReqDedtCustAccountDetails getAccountDetails() {
		return accountDetails;
	}

	/**
	 * @param accountDetails the accountDetails to set
	 */
	public void setAccountDetails(ReqDedtCustAccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}

}
