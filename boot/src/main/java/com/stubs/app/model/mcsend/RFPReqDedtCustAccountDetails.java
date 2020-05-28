package com.stubs.app.model.mcsend;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ReqDedtCustAccountDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-11T09:59:28.047Z[GMT]")
public class RFPReqDedtCustAccountDetails {
	@JsonProperty("accountType")
	@NotNull
	@NotBlank
	@Size(max = 35)
	private String accountType = null;

	@JsonProperty("accountReference")
	@NotNull
	@NotBlank
	@Size(max = 256)
	private String accountReference = null;

	@NotNull
	@NotBlank
	@Size(max = 2)
	@JsonProperty("accountHoldingCountry")
	private String accountHoldingCountry = null;

	@JsonProperty("proxyDirectory")
	@Valid
	private RFPReqProxyDirectory proxyDirectory = null;

	public RFPReqDedtCustAccountDetails accountType(String accountType) {
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

	/**
	 * @return the accountHoldingCountry
	 */
	public String getAccountHoldingCountry() {
		return accountHoldingCountry;
	}

	/**
	 * @param accountHoldingCountry the accountHoldingCountry to set
	 */
	public void setAccountHoldingCountry(String accountHoldingCountry) {
		this.accountHoldingCountry = accountHoldingCountry;
	}

	/**
	 * @return the proxyDirectory
	 */
	public RFPReqProxyDirectory getProxyDirectory() {
		return proxyDirectory;
	}

	/**
	 * @param proxyDirectory the proxyDirectory to set
	 */
	public void setProxyDirectory(RFPReqProxyDirectory proxyDirectory) {
		this.proxyDirectory = proxyDirectory;
	}

	public RFPReqDedtCustAccountDetails accountReference(String accountReference) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RFPReqDedtCustAccountDetails reqDedtCustAccountDetails = (RFPReqDedtCustAccountDetails) o;
		return Objects.equals(this.accountType, reqDedtCustAccountDetails.accountType)
				&& Objects.equals(this.accountReference, reqDedtCustAccountDetails.accountReference);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountType, accountReference);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReqDedtCustAccountDetails {\n");

		sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
		sb.append("    accountReference: ").append(toIndentedString(accountReference)).append("\n");
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
