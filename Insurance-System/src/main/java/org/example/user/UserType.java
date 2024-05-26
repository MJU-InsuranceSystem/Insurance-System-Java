package org.example.user;

import java.util.Arrays;

public enum UserType {
  CUSTOMER("고객"),
  WORKER("직원");

  private final String type;

  UserType(String type){
    this.type = type;
  }

  public String getType() {
    return this.type;
  }

  public static UserType find(String type) {
    return Arrays.stream(UserType.values())
        .filter(userType -> userType.getType().equals(type))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unknown type: " + type));
  }
}
