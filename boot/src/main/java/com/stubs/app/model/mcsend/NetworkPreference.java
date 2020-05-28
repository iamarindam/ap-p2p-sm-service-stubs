/**
 * 
 */
package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author arindam.seal
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkPreference {
	
	private String messageTypeIndicator;
	private String network;
	private String processingCode;
	public String getMessageTypeIndicator() {
		return messageTypeIndicator;
	}
	public void setMessageTypeIndicator(String messageTypeIndicator) {
		this.messageTypeIndicator = messageTypeIndicator;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getProcessingCode() {
		return processingCode;
	}
	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}
	
	
}
