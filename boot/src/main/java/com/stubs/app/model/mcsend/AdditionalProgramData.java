package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdditionalProgramData {
	
	public CrossNetwork getCrossNetwork() {
		return crossNetwork;
	}

	public void setCrossNetwork(CrossNetwork crossNetwork) {
		this.crossNetwork = crossNetwork;
	}

	private CrossNetwork crossNetwork;
}
