package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CredCustAccountDetails {

	@NotBlank
	@NotNull
	@NotEmpty(message = "Please enter AccountDetail AccountType")
	@Size(max=35)
	private String accountType;
	
	@NotBlank
	@NotNull
	@NotEmpty(message = "Please enter AccountDetail AccountReference")
	@Size(max=256)
	private String accountReference;
	
	@NotBlank
	@NotNull
	@NotEmpty(message = "Please enter AccountDetail AccountHoldingCountry")
	@Size(max=2)
	private String accountHoldingCountry;
	
	private String cardExpiry;
	
	private ReqProxyDirectory proxyDrictory;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountReference() {
		return accountReference;
	}

	public void setAccountReference(String accountReference) {
		this.accountReference = accountReference;
	}

	public String getAccountHoldingCountry() {
		return accountHoldingCountry;
	}

	public void setAccountHoldingCountry(String accountHoldingCountry) {
		this.accountHoldingCountry = accountHoldingCountry;
	}

	public ReqProxyDirectory getProxyDrictory() {
		return proxyDrictory;
	}

	public void setProxyDrictory(ReqProxyDirectory proxyDrictory) {
		this.proxyDrictory = proxyDrictory;
	}

	public String getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	
}
