package com.stubs.app.model.mcsend;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Authorisation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-11T09:59:28.047Z[GMT]")
public class Authorisation {
  @JsonProperty("result")
  private String result = null;

  @JsonProperty("resultDetails")
  private String resultDetails = null;

  @JsonProperty("additionalResultInfo")
  private String additionalResultInfo = null;

  public Authorisation result(String result) {
    this.result = result;
    return this;
  }


  
    public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public Authorisation resultDetails(String resultDetails) {
    this.resultDetails = resultDetails;
    return this;
  }


  
    public String getResultDetails() {
    return resultDetails;
  }

  public void setResultDetails(String resultDetails) {
    this.resultDetails = resultDetails;
  }

  public Authorisation additionalResultInfo(String additionalResultInfo) {
    this.additionalResultInfo = additionalResultInfo;
    return this;
  }


  
    public String getAdditionalResultInfo() {
    return additionalResultInfo;
  }

  public void setAdditionalResultInfo(String additionalResultInfo) {
    this.additionalResultInfo = additionalResultInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Authorisation authorisation = (Authorisation) o;
    return Objects.equals(this.result, authorisation.result) &&
        Objects.equals(this.resultDetails, authorisation.resultDetails) &&
        Objects.equals(this.additionalResultInfo, authorisation.additionalResultInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, resultDetails, additionalResultInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Authorisation {\n");

    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    resultDetails: ").append(toIndentedString(resultDetails)).append("\n");
    sb.append("    additionalResultInfo: ").append(toIndentedString(additionalResultInfo)).append("\n");
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
