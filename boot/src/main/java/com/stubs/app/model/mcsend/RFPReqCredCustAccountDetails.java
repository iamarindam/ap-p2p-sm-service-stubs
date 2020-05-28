package com.stubs.app.model.mcsend;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ReqCredCustAccountDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-11T09:59:28.047Z[GMT]")
public class RFPReqCredCustAccountDetails {

	@NotNull
	@NotBlank
	@Size(max = 35)
	@JsonProperty("accountType")
	private String accountType = null;

	@JsonProperty("accountReference")
	@NotNull
	@NotBlank
	@Size(max = 256)
	private String accountReference = null;

	/*@NotNull
	@NotBlank
	@Size(max = 2)
	@JsonProperty("accountHoldingCountry")
	private String accountHoldingCountry = null;*/
	
	@JsonProperty("cardExpiry")
	@DateTimeFormat(pattern = "MM-yyyy")
	private String cardExpiry;
	
	/*
	 * @JsonProperty("proxyDirectory")
	 * 
	 * @Valid private ReqProxyDirectory proxyDirectory = null;
	 */

	public RFPReqCredCustAccountDetails accountType(String accountType) {
		this.accountType = accountType;
		return this;
	}

	/**
	 * Get accountType
	 * 
	 * @return accountType
	 **/
	@NotNull

	@Size(max = 35)
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public RFPReqCredCustAccountDetails accountReference(String accountReference) {
		this.accountReference = accountReference;
		return this;
	}

	/**
	 * Get accountReference
	 * 
	 * @return accountReference
	 **/
	@NotNull

	@Size(max = 256)
	public String getAccountReference() {
		return accountReference;
	}

	public void setAccountReference(String accountReference) {
		this.accountReference = accountReference;
	}

	/*
	 * public RFPReqCredCustAccountDetails accountHoldingCountry(String
	 * accountHoldingCountry) { this.accountHoldingCountry = accountHoldingCountry;
	 * return this; }
	 */

	/**
	 * Get accountHoldingCountry
	 * 
	 * @return accountHoldingCountry
	 **/

	/*
	 * public RFPReqCredCustAccountDetails proxyDirectory(ReqProxyDirectory
	 * proxyDirectory) { this.proxyDirectory = proxyDirectory; return this; }
	 */

	
	
	


	/**
	 * Get accountHoldingCountry
	 * 
	 * @return accountHoldingCountry
	 **/

	/*
	 * public RFPReqCredCustAccountDetails proxyDirectory(ReqProxyDirectory
	 * proxyDirectory) { this.proxyDirectory = proxyDirectory; return this; }
	 */

	
	
	

	public String getCardExpiry() {
		return cardExpiry;
	}

	/**
	 * @param cardExpiry the cardExpiry to set
	 */
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RFPReqCredCustAccountDetails reqCredCustAccountDetails = (RFPReqCredCustAccountDetails) o;
		return Objects.equals(this.accountType, reqCredCustAccountDetails.accountType)
				&& Objects.equals(this.accountReference, reqCredCustAccountDetails.accountReference)
				&& Objects.equals(this.cardExpiry, reqCredCustAccountDetails.cardExpiry);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountType, accountReference, cardExpiry);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReqCredCustAccountDetails {\n");

		sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
		sb.append("    accountReference: ").append(toIndentedString(accountReference)).append("\n");
		sb.append("    cardExpiry: ").append(toIndentedString(cardExpiry)).append("\n");
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
