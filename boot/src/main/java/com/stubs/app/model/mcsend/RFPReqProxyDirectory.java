package com.stubs.app.model.mcsend;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * ReqProxyDirectory
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-02-11T09:59:28.047Z[GMT]")
public class RFPReqProxyDirectory   {
  @JsonProperty("directoryName")
  @NotNull
  @NotBlank
  @Size(max=35)
  private String directoryName = null;

  @JsonProperty("participantReference")
  @NotNull
  @NotBlank
  @Size(max=256)
  private String participantReference = null;

  public RFPReqProxyDirectory directoryName(String directoryName) {
    this.directoryName = directoryName;
    return this;
  }

  /**
   * Get directoryName
   * @return directoryName
  **/
      @NotNull

    public String getDirectoryName() {
    return directoryName;
  }

  public void setDirectoryName(String directoryName) {
    this.directoryName = directoryName;
  }

  public RFPReqProxyDirectory participantReference(String participantReference) {
    this.participantReference = participantReference;
    return this;
  }



  /**
   * Get participantReference
   * @return participantReference
  **/
  
    public String getParticipantReference() {
    return participantReference;
  }

  public void setParticipantReference(String participantReference) {
    this.participantReference = participantReference;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RFPReqProxyDirectory reqProxyDirectory = (RFPReqProxyDirectory) o;
    return Objects.equals(this.directoryName, reqProxyDirectory.directoryName) &&
        Objects.equals(this.participantReference, reqProxyDirectory.participantReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(directoryName, participantReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReqProxyDirectory {\n");
    
    sb.append("    directoryName: ").append(toIndentedString(directoryName)).append("\n");
    sb.append("    participantReference: ").append(toIndentedString(participantReference)).append("\n");
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
