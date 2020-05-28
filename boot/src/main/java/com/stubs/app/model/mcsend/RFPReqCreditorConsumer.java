package com.stubs.app.model.mcsend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ReqCreditorConsumer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-11T09:59:28.047Z[GMT]")
public class RFPReqCreditorConsumer {

	@JsonProperty("number")
	@NotNull
	@NotBlank
	@Size(max = 35)
	private String number = null;
	
	@JsonProperty("firstName")
	@NotNull
	@NotBlank
	@Size(max = 70)
	private String firstName = null;

	@NotNull
	@NotBlank
	@Size(max = 70)
	@JsonProperty("lastName")
	private String lastName = null;

	@NotNull
	@Size(max = 70)
	@JsonProperty("addressLines")
	@Valid
	private List<Object> addressLines = null;

	@NotNull
	@JsonProperty("birthDate")
	@JsonFormat
	  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDate = null;

	@Valid
	@JsonProperty("accountDetails")
	private RFPReqCredCustAccountDetails accountDetails = null;

	public RFPReqCreditorConsumer firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Get firstName
	 * 
	 * @return firstName
	 **/

	@Size(max = 70)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public RFPReqCreditorConsumer lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Get lastName
	 * 
	 * @return lastName
	 **/

	@Size(max = 70)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RFPReqCreditorConsumer addressLines(List<Object> addressLines) {
		this.addressLines = addressLines;
		return this;
	}

	public RFPReqCreditorConsumer addAddressLinesItem(Object addressLinesItem) {
		if (this.addressLines == null) {
			this.addressLines = new ArrayList<Object>();
		}
		this.addressLines.add(addressLinesItem);
		return this;
	}

	/**
	 * Get addressLines
	 * 
	 * @return addressLines
	 **/

	public List<Object> getAddressLines() {
		return addressLines;
	}

	public void setAddressLines(List<Object> addressLines) {
		this.addressLines = addressLines;
	}

	public RFPReqCreditorConsumer accountDetails(RFPReqCredCustAccountDetails accountDetails) {
		this.accountDetails = accountDetails;
		return this;
	}

	/**
	 * Get birthDate
	 * 
	 * @return birthDate
	 **/

	@Valid
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Get accountDetails
	 * 
	 * @return accountDetails
	 **/
	@NotNull

	@Valid
	public RFPReqCredCustAccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(RFPReqCredCustAccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}
	
	
	@Valid
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RFPReqCreditorConsumer reqCreditorConsumer = (RFPReqCreditorConsumer) o;
		return Objects.equals(this.firstName, reqCreditorConsumer.firstName)
				&& Objects.equals(this.lastName, reqCreditorConsumer.lastName)
				&& Objects.equals(this.addressLines, reqCreditorConsumer.addressLines)
				&& Objects.equals(this.birthDate, reqCreditorConsumer.birthDate)
				&& Objects.equals(this.accountDetails, reqCreditorConsumer.accountDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, addressLines, birthDate, accountDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReqCreditorConsumer {\n");

		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    addressLines: ").append(toIndentedString(addressLines)).append("\n");
		sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
		sb.append("    accountDetails: ").append(toIndentedString(accountDetails)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
