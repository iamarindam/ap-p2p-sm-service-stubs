package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SingleMessage {
	
	public String getAcquiringIdentificationCode() {
		return acquiringIdentificationCode;
	}
	public void setAcquiringIdentificationCode(String acquiringIdentificationCode) {
		this.acquiringIdentificationCode = acquiringIdentificationCode;
	}
	public String getProcessorId() {
		return processorId;
	}
	public void setProcessorId(String processorId) {
		this.processorId = processorId;
	}
	private String acquiringIdentificationCode;
	private String processorId;
}
