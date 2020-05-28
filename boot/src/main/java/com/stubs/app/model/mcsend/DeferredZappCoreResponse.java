package com.stubs.app.model.mcsend;

import java.util.ArrayList;
import java.util.Date;

public class DeferredZappCoreResponse {
    private Date creationDate;


    private CreditorConsumer creditorConsumer;

    private TransactionIdentification transactionIdentification;
    private Authorisation authorisation;
    private ArrayList<SettlementDetails> settlementDetails;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }



    public CreditorConsumer getCreditorConsumer() {
        return creditorConsumer;
    }

    public void setCreditorConsumer(CreditorConsumer creditorConsumer) {
        this.creditorConsumer = creditorConsumer;
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

    public ArrayList<SettlementDetails> getSettlementDetails() {
        return settlementDetails;
    }

    public void setSettlementDetails(ArrayList<SettlementDetails> settlementDetails) {
        this.settlementDetails = settlementDetails;
    }

    @Override
    public String toString() {
        return "DeferredZappCoreResponse{" +
                "creationDate=" + creationDate +

                ", creditorConsumer=" + creditorConsumer +
                ", transactionIdentification=" + transactionIdentification +
                ", authorisation=" + authorisation +
                ", settlementDetails=" + settlementDetails +
                '}';
    }
}
