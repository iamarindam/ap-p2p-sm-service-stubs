package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferEligibleRequest {

	private String acquirerCountry;
	private Integer amount;
	private String crossBorderEligible;
	private String currency;


	@JsonProperty("recipientAccountUri")
	private String recipientAccountUri;


	private String paymentType;

	private String transferAcceptorCountry;

	public String getAcquirerCountry() {
		return acquirerCountry;
	}

	public void setAcquirerCountry(String acquirerCountry) {
		this.acquirerCountry = acquirerCountry;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCrossBorderEligible() {
		return crossBorderEligible;
	}

	public void setCrossBorderEligible(String crossBorderEligible) {
		this.crossBorderEligible = crossBorderEligible;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getRecipientAccountUri() {
		return recipientAccountUri;
	}

	public void setRecipientAccountUri(String recipientAccountUri) {
		this.recipientAccountUri = recipientAccountUri;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getTransferAcceptorCountry() {
		return transferAcceptorCountry;
	}

	public void setTransferAcceptorCountry(String transferAcceptorCountry) {
		this.transferAcceptorCountry = transferAcceptorCountry;
	}
}
