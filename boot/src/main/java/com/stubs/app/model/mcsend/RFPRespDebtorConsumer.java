package com.stubs.app.model.mcsend;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RespCreditorConsumer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-14T11:31:16.648Z[GMT]")
public class RFPRespDebtorConsumer   {
	 
	  @JsonProperty("number")
	  private String number = null;

	  @JsonProperty("firstName")
	  private String firstName = null;

	  @JsonProperty("lastName")
	  private String lastName = null;

	  @JsonProperty("addressLines")
	  private List<Object> addressLines = new ArrayList<Object>();

	  @JsonProperty("birthDate")
	  @Pattern(regexp ="^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$" , message = "birthDate should be of proper yyyy-MM-dd type only.")
	  private String birthDate = null;

	  public RFPRespDebtorConsumer number(String number) {
	    this.number = number;
	    return this;
	  }

	  /**
	   * Debtor Consumer Number
	   * @return number
	  **/
   public String getNumber() {
	    return number;
	  }

	  public void setNumber(String number) {
	    this.number = number;
	  }

	  public RFPRespDebtorConsumer firstName(String firstName) {
	    this.firstName = firstName;
	    return this;
	  }

	  /**
	   * Debtor Consumer Name
	   * @return firstName
	  **/
	   public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public RFPRespDebtorConsumer lastName(String lastName) {
	    this.lastName = lastName;
	    return this;
	  }

	  /**
	   * Debtor Consumer Name
	   * @return lastName
	  **/
	  public String getLastName() {
	    return lastName;
	  }

	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }

	  public RFPRespDebtorConsumer addressLines(List<Object> addressLines) {
	    this.addressLines = addressLines;
	    return this;
	  }

	  public RFPRespDebtorConsumer addAddressLinesItem(Object addressLinesItem) {
	    this.addressLines.add(addressLinesItem);
	    return this;
	  }

	  /**
	   * Debtor Consumer Address Lines
	   * @return addressLines
	  **/

	    public List<Object> getAddressLines() {
	    return addressLines;
	  }

	  public void setAddressLines(List<Object> addressLines) {
	    this.addressLines = addressLines;
	  }
	 


	  /**
	   * Birth date
	   * @return birthDate
	  **/
	  public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}



	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    RFPRespDebtorConsumer reqDebtorConsumer = (RFPRespDebtorConsumer) o;
	    return Objects.equals(this.number, reqDebtorConsumer.number) &&
	        Objects.equals(this.firstName, reqDebtorConsumer.firstName) &&
	        Objects.equals(this.lastName, reqDebtorConsumer.lastName) &&
	        Objects.equals(this.addressLines, reqDebtorConsumer.addressLines) &&
	        Objects.equals(this.birthDate, reqDebtorConsumer.birthDate);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(number, firstName, lastName, addressLines, birthDate);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class RespDebtorConsumer {\n");
	    
	    sb.append("    number: ").append(toIndentedString(number)).append("\n");
	    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
	    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
	    sb.append("    addressLines: ").append(toIndentedString(addressLines)).append("\n");
	    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
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
