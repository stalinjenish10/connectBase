package com.capestart.pojos.advancecpqv2;

import java.util.List;


public class CreateAccountResponseDetails {

  private String status;
  private List<DataDetails> data;
  private String message;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<DataDetails> getData() {
    return data;
  }

  public void setData(List<DataDetails> data) {
    this.data = data;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
