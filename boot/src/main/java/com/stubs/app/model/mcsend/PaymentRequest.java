package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequest {

	private AcquiringCredentials acquiringCredentials;
	private String additionalMessage;
	private AdditionalProgramData additionalProgramData;
	private String amount;
	private String currency;
	private String deviceType;
	private String fundingSource;
	private String merchantCategoryCode;
	private NetworkPreference networkPreference;
	private String participationId;
	private String routingTransitNumber;
	private String paymentReference;
	private String paymentType;
	private String qrData;
	private Recipient recipient;
	private Sender sender;
	private String transactionLocalDateTime;
	private String transactionPurpose;
	private TransferAcceptor transferAcceptor;
	private String uniqueTransactionReference;
	public AcquiringCredentials getAcquiringCredentials() {
		return acquiringCredentials;
	}
	public void setAcquiringCredentials(AcquiringCredentials acquiringCredentials) {
		this.acquiringCredentials = acquiringCredentials;
	}
	public String getAdditionalMessage() {
		return additionalMessage;
	}
	public void setAdditionalMessage(String additionalMessage) {
		this.additionalMessage = additionalMessage;
	}
	public AdditionalProgramData getAdditionalProgramData() {
		return additionalProgramData;
	}
	public void setAdditionalProgramData(AdditionalProgramData additionalProgramData) {
		this.additionalProgramData = additionalProgramData;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getFundingSource() {
		return fundingSource;
	}
	public void setFundingSource(String fundingSource) {
		this.fundingSource = fundingSource;
	}
	public String getMerchantCategoryCode() {
		return merchantCategoryCode;
	}
	public void setMerchantCategoryCode(String merchantCategoryCode) {
		this.merchantCategoryCode = merchantCategoryCode;
	}
	public NetworkPreference getNetworkPreference() {
		return networkPreference;
	}
	public void setNetworkPreference(NetworkPreference networkPreference) {
		this.networkPreference = networkPreference;
	}
	public String getParticipationId() {
		return participationId;
	}
	public void setParticipationId(String participationId) {
		this.participationId = participationId;
	}
	public String getRoutingTransitNumber() {
		return routingTransitNumber;
	}
	public void setRoutingTransitNumber(String routingTransitNumber) {
		this.routingTransitNumber = routingTransitNumber;
	}
	public String getPaymentReference() {
		return paymentReference;
	}
	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getQrData() {
		return qrData;
	}
	public void setQrData(String qrData) {
		this.qrData = qrData;
	}
	public Recipient getRecipient() {
		return recipient;
	}
	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}
	public Sender getSender() {
		return sender;
	}
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	public String getTransactionLocalDateTime() {
		return transactionLocalDateTime;
	}
	public void setTransactionLocalDateTime(String transactionLocalDateTime) {
		this.transactionLocalDateTime = transactionLocalDateTime;
	}
	public String getTransactionPurpose() {
		return transactionPurpose;
	}
	public void setTransactionPurpose(String transactionPurpose) {
		this.transactionPurpose = transactionPurpose;
	}
	public TransferAcceptor getTransferAcceptor() {
		return transferAcceptor;
	}
	public void setTransferAcceptor(TransferAcceptor transferAcceptor) {
		this.transferAcceptor = transferAcceptor;
	}
	public String getUniqueTransactionReference() {
		return uniqueTransactionReference;
	}
	public void setUniqueTransactionReference(String uniqueTransactionReference) {
		this.uniqueTransactionReference = uniqueTransactionReference;
	}
	
}
