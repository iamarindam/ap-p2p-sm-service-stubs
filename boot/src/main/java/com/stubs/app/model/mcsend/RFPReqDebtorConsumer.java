package com.stubs.app.model.mcsend;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ReqDebtorConsumer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-11T09:59:28.047Z[GMT]")
public class RFPReqDebtorConsumer   {
 
  @JsonProperty("accountDetails")
  @NotNull
  @Valid
  private RFPReqDedtCustAccountDetails accountDetails = null;

  /**
 * @return the accountDetails
 */
public RFPReqDedtCustAccountDetails getAccountDetails() {
	return accountDetails;
}

/**
 * @param accountDetails the accountDetails to set
 */
public void setAccountDetails(RFPReqDedtCustAccountDetails accountDetails) {
	this.accountDetails = accountDetails;
}

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RFPReqDebtorConsumer reqDebtorConsumer = (RFPReqDebtorConsumer) o;
    return 
        Objects.equals(this.accountDetails, reqDebtorConsumer.accountDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash( accountDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReqDebtorConsumer {\n");
    
   
    sb.append("    accountDetails: ").append(toIndentedString(accountDetails)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
