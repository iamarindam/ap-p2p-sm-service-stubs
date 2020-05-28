package com.stubs.app.model.mcsend;

public class PaymentSearchResponse {
	
	public String getPaymentReference() {
		return paymentReference;
	}
	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getTransactionStatusReason() {
		return transactionStatusReason;
	}
	public void setTransactionStatusReason(String transactionStatusReason) {
		this.transactionStatusReason = transactionStatusReason;
	}
	public String getOriginalTransactionstatus() {
		return originalTransactionstatus;
	}
	public void setOriginalTransactionstatus(String originalTransactionstatus) {
		this.originalTransactionstatus = originalTransactionstatus;
	}
	public String getTransmissionDateTime() {
		return transmissionDateTime;
	}
	public void setTransmissionDateTime(String transmissionDateTime) {
		this.transmissionDateTime = transmissionDateTime;
	}
	public String getNetworkResponseCode() {
		return networkResponseCode;
	}
	public void setNetworkResponseCode(String networkResponseCode) {
		this.networkResponseCode = networkResponseCode;
	}
	public String getSwitchSerialNumber() {
		return switchSerialNumber;
	}
	public void setSwitchSerialNumber(String switchSerialNumber) {
		this.switchSerialNumber = switchSerialNumber;
	}
	public String getSystemTraceAuditNumber() {
		return systemTraceAuditNumber;
	}
	public void setSystemTraceAuditNumber(String systemTraceAuditNumber) {
		this.systemTraceAuditNumber = systemTraceAuditNumber;
	}
	public String getRetrievalRequestNumber() {
		return retrievalRequestNumber;
	}
	public void setRetrievalRequestNumber(String retrievalRequestNumber) {
		this.retrievalRequestNumber = retrievalRequestNumber;
	}
	public String getAuthorizationCode() {
		return authorizationCode;
	}
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
	public String getFundsAvailability() {
		return fundsAvailability;
	}
	public void setFundsAvailability(String fundsAvailability) {
		this.fundsAvailability = fundsAvailability;
	}
	public String getTokenRequestorId() {
		return tokenRequestorId;
	}
	public void setTokenRequestorId(String tokenRequestorId) {
		this.tokenRequestorId = tokenRequestorId;
	}
	public String getUniqueTransactionReference() {
		return uniqueTransactionReference;
	}
	public void setUniqueTransactionReference(String uniqueTransactionReference) {
		this.uniqueTransactionReference = uniqueTransactionReference;
	}
	public int getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(int settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public String getSettlementCurrency() {
		return settlementCurrency;
	}
	public void setSettlementCurrency(String settlementCurrency) {
		this.settlementCurrency = settlementCurrency;
	}
	public String getPaymentAccountReference() {
		return paymentAccountReference;
	}
	public void setPaymentAccountReference(String paymentAccountReference) {
		this.paymentAccountReference = paymentAccountReference;
	}
	public String getTransactionLocalDateTime() {
		return transactionLocalDateTime;
	}
	public void setTransactionLocalDateTime(String transactionLocalDateTime) {
		this.transactionLocalDateTime = transactionLocalDateTime;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getMerchantCategoryCode() {
		return merchantCategoryCode;
	}
	public void setMerchantCategoryCode(String merchantCategoryCode) {
		this.merchantCategoryCode = merchantCategoryCode;
	}
	public TransferAcceptor getTransferAcceptor() {
		return transferAcceptor;
	}
	public void setTransferAcceptor(TransferAcceptor transferAcceptor) {
		this.transferAcceptor = transferAcceptor;
	}
	public AcquiringCredentials getAcquiringCredentials() {
		return acquiringCredentials;
	}
	public void setAcquiringCredentials(AcquiringCredentials acquiringCredentials) {
		this.acquiringCredentials = acquiringCredentials;
	}
	public Sender getSender() {
		return sender;
	}
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	public Recipient getRecipient() {
		return recipient;
	}
	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}
	public String getFundingSource() {
		return fundingSource;
	}
	public void setFundingSource(String fundingSource) {
		this.fundingSource = fundingSource;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAdditionalMessage() {
		return additionalMessage;
	}
	public void setAdditionalMessage(String additionalMessage) {
		this.additionalMessage = additionalMessage;
	}
	public String getQrData() {
		return qrData;
	}
	public void setQrData(String qrData) {
		this.qrData = qrData;
	}
	public String getParticipationId() {
		return participationId;
	}
	public void setParticipationId(String participationId) {
		this.participationId = participationId;
	}
	public String getTransactionPurpose() {
		return transactionPurpose;
	}
	public void setTransactionPurpose(String transactionPurpose) {
		this.transactionPurpose = transactionPurpose;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public AdditionalProgramData getAdditionalProgramData() {
		return additionalProgramData;
	}
	public void setAdditionalProgramData(AdditionalProgramData additionalProgramData) {
		this.additionalProgramData = additionalProgramData;
	}
	private String paymentReference;
	private String paymentId;
	private String transactionStatus;
	private String transactionStatusReason;
	private String originalTransactionstatus;
	private String transmissionDateTime;
	private String networkResponseCode;
	private String switchSerialNumber;
	private String systemTraceAuditNumber;
	private String retrievalRequestNumber;
	private String authorizationCode;
	private String fundsAvailability;
	private String tokenRequestorId; //To be changed to Number
	private String uniqueTransactionReference;
	private int settlementAmount;
	private String settlementCurrency;
	private String paymentAccountReference;
	private String transactionLocalDateTime;
	private String paymentType;
	private String merchantCategoryCode;
	private TransferAcceptor transferAcceptor;
	private AcquiringCredentials acquiringCredentials;
	private Sender sender;
	private Recipient recipient;
	private String fundingSource;
	private int amount;
	private String currency;
	private String additionalMessage;
	private String qrData;
	private String participationId;
	private String transactionPurpose;
	private String deviceType;
	private AdditionalProgramData additionalProgramData;
	
}
