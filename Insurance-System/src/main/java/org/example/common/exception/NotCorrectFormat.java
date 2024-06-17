package org.example.common.exception;

public class  NotCorrectFormat extends RuntimeException{

  private String message;
  public NotCorrectFormat(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
