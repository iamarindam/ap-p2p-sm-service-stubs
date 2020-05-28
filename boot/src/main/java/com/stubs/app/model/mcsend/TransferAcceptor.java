package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferAcceptor {
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getConvenienceAmount() {
		return convenienceAmount;
	}
	public void setConvenienceAmount(String convenienceAmount) {
		this.convenienceAmount = convenienceAmount;
	}
	public String getConvenienceIndicator() {
		return convenienceIndicator;
	}
	public void setConvenienceIndicator(String convenienceIndicator) {
		this.convenienceIndicator = convenienceIndicator;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMastercardAssignedMerchantId() {
		return mastercardAssignedMerchantId;
	}
	public void setMastercardAssignedMerchantId(String mastercardAssignedMerchantId) {
		this.mastercardAssignedMerchantId = mastercardAssignedMerchantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPaymentFacilitatorId() {
		return paymentFacilitatorId;
	}
	public void setPaymentFacilitatorId(String paymentFacilitatorId) {
		this.paymentFacilitatorId = paymentFacilitatorId;
	}
	public String getSubMerchantId() {
		return subMerchantId;
	}
	public void setSubMerchantId(String subMerchantId) {
		this.subMerchantId = subMerchantId;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	private Address address;
	private String convenienceAmount;
	private String convenienceIndicator;
	private String id;
	private String mastercardAssignedMerchantId;
	private String name;
	private String paymentFacilitatorId;
	private String subMerchantId;
	private String terminalId;


}
