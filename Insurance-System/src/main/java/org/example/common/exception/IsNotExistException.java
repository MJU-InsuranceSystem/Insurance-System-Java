package org.example.common.exception;

public class IsNotExistException extends RuntimeException{

  private String message;
  public IsNotExistException(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
