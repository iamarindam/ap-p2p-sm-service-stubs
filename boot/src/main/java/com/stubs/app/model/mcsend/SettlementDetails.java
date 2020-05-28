package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * SettlementDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-11T09:59:28.047Z[GMT]")
public class SettlementDetails {
  @JsonProperty("settlementMethod")
  private String settlementMethod = null;

  @JsonProperty("clearingSystem")
  private String clearingSystem = null;

  public SettlementDetails settlementMethod(String settlementMethod) {
    this.settlementMethod = settlementMethod;
    return this;
  }


  
    public String getSettlementMethod() {
    return settlementMethod;
  }

  public void setSettlementMethod(String settlementMethod) {
    this.settlementMethod = settlementMethod;
  }

  public SettlementDetails clearingSystem(String clearingSystem) {
    this.clearingSystem = clearingSystem;
    return this;
  }


  
    public String getClearingSystem() {
    return clearingSystem;
  }

  public void setClearingSystem(String clearingSystem) {
    this.clearingSystem = clearingSystem;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettlementDetails settlementDetails = (SettlementDetails) o;
    return Objects.equals(this.settlementMethod, settlementDetails.settlementMethod) &&
        Objects.equals(this.clearingSystem, settlementDetails.clearingSystem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(settlementMethod, clearingSystem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettlementDetails {\n");

    sb.append("    settlementMethod: ").append(toIndentedString(settlementMethod)).append("\n");
    sb.append("    clearingSystem: ").append(toIndentedString(clearingSystem)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
