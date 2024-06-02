package org.example.common.dto;

import java.util.HashMap;
import java.util.Map;

public class RequestDto {

    private final Map<String, String> requestInfo = new HashMap<>();

    public void add(String key, String value) {
        requestInfo.put(key, value);
    }

    public String get(String key) {
        return requestInfo.get(key);
    }

    public Map<String, String> getTotalInfo() {
        requestInfo.forEach(
            (key, value) -> System.out.println("Key: " + key + ", Value: " + value));
        return this.requestInfo;
    }
}
