package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DualMessage {
	
	public String getAcquiringBin() {
		return acquiringBin;
	}

	public void setAcquiringBin(String acquiringBin) {
		this.acquiringBin = acquiringBin;
	}

	private String acquiringBin;
}
