package org.example.common.exception;

public class EmptyInputException extends RuntimeException{

  private String message;
  public EmptyInputException(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
