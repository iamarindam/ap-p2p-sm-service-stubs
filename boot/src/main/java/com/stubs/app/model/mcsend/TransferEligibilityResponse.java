package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stubs.app.model.mps.Errors;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferEligibilityResponse {

	private ReceivingEligibility receivingEligibility;
	private SendingEligibility sendingEligibility;
	private TransferEligibility transferEligibility;
	@JsonIgnore
	private String statusCode;

	@JsonProperty("Errors")
	private Errors errors;
	
	public ReceivingEligibility getReceivingEligibility() {
		return receivingEligibility;
	}
	public void setReceivingEligibility(ReceivingEligibility receivingEligibility) {
		this.receivingEligibility = receivingEligibility;
	}
	public SendingEligibility getSendingEligibility() {
		return sendingEligibility;
	}
	public void setSendingEligibility(SendingEligibility sendingEligibility) {
		this.sendingEligibility = sendingEligibility;
	}
	public TransferEligibility getTransferEligibility() {
		return transferEligibility;
	}
	public void setTransferEligibility(TransferEligibility transferEligibility) {
		this.transferEligibility = transferEligibility;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}
}
