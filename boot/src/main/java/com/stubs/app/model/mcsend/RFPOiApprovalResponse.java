package com.stubs.app.model.mcsend;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RFPOiApprovalResponse {
	private Date creationDate;
    private String initiatingPartyId;
    private String receivingPartyId;
    private RFPRespDebtorConsumer debtorConsumer;
    private TransactionIdentification transactionIdentification;
    private Authorisation authorisation;
 
    private String statusCode;

    
    /**
	 * @return the debtorConsumer
	 */
	public RFPRespDebtorConsumer getDebtorConsumer() {
		return debtorConsumer;
	}

	/**
	 * @param debtorConsumer the debtorConsumer to set
	 */
	public void setDebtorConsumer(RFPRespDebtorConsumer debtorConsumer) {
		this.debtorConsumer = debtorConsumer;
	}

	public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getInitiatingPartyId() {
        return initiatingPartyId;
    }

    public void setInitiatingPartyId(String initiatingPartyId) {
        this.initiatingPartyId = initiatingPartyId;
    }

    public String getReceivingPartyId() {
        return receivingPartyId;
    }

    public void setReceivingPartyId(String receivingPartyId) {
        this.receivingPartyId = receivingPartyId;
    }

    public TransactionIdentification getTransactionIdentification() {
        return transactionIdentification;
    }

    public void setTransactionIdentification(TransactionIdentification transactionIdentification) {
        this.transactionIdentification = transactionIdentification;
    }

    public Authorisation getAuthorisation() {
        return authorisation;
    }

    public void setAuthorisation(Authorisation authorisation) {
        this.authorisation = authorisation;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
