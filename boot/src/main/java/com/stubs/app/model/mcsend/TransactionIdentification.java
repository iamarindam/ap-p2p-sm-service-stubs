package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionIdentification {

	private String initiatorTxId;
	private String schmTxnId;
	private String reconciliationDate;

	private String endToEndId;
	
	private String remittanceReference;

	public String getInitiatorTxId() {
		return initiatorTxId;
	}

	public void setInitiatorTxId(String initiatorTxId) {
		this.initiatorTxId = initiatorTxId;
	}
	
	public String getSchmTxnId() {
		return schmTxnId;
	}

	public void setSchmTxnId(String schmTxnId) {
		this.schmTxnId = schmTxnId;
	}

	public String getReconciliationDate() {
		return reconciliationDate;
	}

	public void setReconciliationDate(String reconciliationDate) {
		this.reconciliationDate = reconciliationDate;
	}

	public String getEndToEndId() {
		return endToEndId;
	}

	public void setEndToEndId(String endToEndId) {
		this.endToEndId = endToEndId;
	}

	public String getRemittanceReference() {
		return remittanceReference;
	}

	public void setRemittanceReference(String remittanceReference) {
		this.remittanceReference = remittanceReference;
	}

}
