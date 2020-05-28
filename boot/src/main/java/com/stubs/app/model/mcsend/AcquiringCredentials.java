package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AcquiringCredentials {
	
	private String acquiringCountry;
	private String acquiringIca;
	private DualMessage dualMessage;
	private SingleMessage singleMessage;
	
	public String getAcquiringCountry() {
		return acquiringCountry;
	}
	public void setAcquiringCountry(String acquiringCountry) {
		this.acquiringCountry = acquiringCountry;
	}
	public String getAcquiringIca() {
		return acquiringIca;
	}
	public void setAcquiringIca(String acquiringIca) {
		this.acquiringIca = acquiringIca;
	}
	public DualMessage getDualMessage() {
		return dualMessage;
	}
	public void setDualMessage(DualMessage dualMessage) {
		this.dualMessage = dualMessage;
	}
	public SingleMessage getSingleMessage() {
		return singleMessage;
	}
	public void setSingleMessage(SingleMessage singleMessage) {
		this.singleMessage = singleMessage;
	}
	
	
}
