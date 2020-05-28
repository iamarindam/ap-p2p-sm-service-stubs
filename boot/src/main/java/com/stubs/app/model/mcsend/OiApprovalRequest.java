package com.stubs.app.model.mcsend;

public class OiApprovalRequest extends DeferredZappCoreResponse {
    private String initiatingPartyId;
    private String receivingPartyId;

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
}
