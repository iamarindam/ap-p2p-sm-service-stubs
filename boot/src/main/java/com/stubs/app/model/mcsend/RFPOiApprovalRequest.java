package com.stubs.app.model.mcsend;

import java.util.ArrayList;
import java.util.Date;

import com.stubs.app.model.mps.CreditorParticipant;
import com.stubs.app.model.mps.DebtorParticipant;

public class RFPOiApprovalRequest {
	private String initiatingPartyId;
    private String receivingPartyId;
    private Date creationDate;
    
    private DebtorParticipant debtorParticipant;
    private CreditorParticipant creditorParticipant;
    private RFPReqDebtorConsumer debtorConsumer;
    private RFPReqCreditorConsumer creditorConsumer;
	private String transactionAmount;
	private String transactionCurrency;

    private TransactionIdentification transactionIdentification;
    private ArrayList<SettlementDetails> settlementDetails;


    /**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the debtorParticipant
	 */
	public DebtorParticipant getDebtorParticipant() {
		return debtorParticipant;
	}

	/**
	 * @param debtorParticipant the debtorParticipant to set
	 */
	public void setDebtorParticipant(DebtorParticipant debtorParticipant) {
		this.debtorParticipant = debtorParticipant;
	}

	/**
	 * @return the creditorParticipant
	 */
	public CreditorParticipant getCreditorParticipant() {
		return creditorParticipant;
	}

	/**
	 * @param creditorParticipant the creditorParticipant to set
	 */
	public void setCreditorParticipant(CreditorParticipant creditorParticipant) {
		this.creditorParticipant = creditorParticipant;
	}


	/**
	 * @return the transactionAmount
	 */
	public String getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the transactionCurrency
	 */
	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	/**
	 * @param transactionCurrency the transactionCurrency to set
	 */
	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}


	/**
	 * @return the transactionIdentification
	 */
	public TransactionIdentification getTransactionIdentification() {
		return transactionIdentification;
	}

	/**
	 * @param transactionIdentification the transactionIdentification to set
	 */
	public void setTransactionIdentification(TransactionIdentification transactionIdentification) {
		this.transactionIdentification = transactionIdentification;
	}


	/**
	 * @return the settlementDetails
	 */
	public ArrayList<SettlementDetails> getSettlementDetails() {
		return settlementDetails;
	}

	/**
	 * @param settlementDetails the settlementDetails to set
	 */
	public void setSettlementDetails(ArrayList<SettlementDetails> settlementDetails) {
		this.settlementDetails = settlementDetails;
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

	/**
	 * @return the debtorConsumer
	 */
	public RFPReqDebtorConsumer getDebtorConsumer() {
		return debtorConsumer;
	}

	/**
	 * @param debtorConsumer the debtorConsumer to set
	 */
	public void setDebtorConsumer(RFPReqDebtorConsumer debtorConsumer) {
		this.debtorConsumer = debtorConsumer;
	}

	/**
	 * @return the creditorConsumer
	 */
	public RFPReqCreditorConsumer getCreditorConsumer() {
		return creditorConsumer;
	}

	/**
	 * @param creditorConsumer the creditorConsumer to set
	 */
	public void setCreditorConsumer(RFPReqCreditorConsumer creditorConsumer) {
		this.creditorConsumer = creditorConsumer;
	}
    
}

