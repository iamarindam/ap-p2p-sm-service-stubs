package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OiApprovalResponse {
    private Date creationDate;
    private String initiatingPartyId;
    private String receivingPartyId;
    private TransactionIdentification transactionIdentification;
    private Authorisation authorisation;

    private String statusCode;

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
