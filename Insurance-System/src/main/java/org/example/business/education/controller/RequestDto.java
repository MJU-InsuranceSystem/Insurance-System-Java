package org.example.business.education.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestDto {

  protected final Map<String, String> requestInfo = new HashMap<>();

  public void add(String key, String value) {
    requestInfo.put(key, value);
  }

  public String get(String key) {
    return requestInfo.get(key);
  }
}
