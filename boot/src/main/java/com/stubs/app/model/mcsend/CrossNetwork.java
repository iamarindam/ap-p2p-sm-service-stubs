package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrossNetwork {
	
	public String getWalletProviderSignature() {
		return walletProviderSignature;
	}

	public void setWalletProviderSignature(String walletProviderSignature) {
		this.walletProviderSignature = walletProviderSignature;
	}

	private String walletProviderSignature;
}
