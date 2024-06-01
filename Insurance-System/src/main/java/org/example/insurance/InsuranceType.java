package org.example.insurance;

import java.util.Arrays;

public enum InsuranceType {
  FIRE(1, "화재보험"),
  LIFE(2, "생명보험"),
  TRAVEL(3, "여행보험"),
  CAR(4, "자동차보험"),
  CANCER(5, "암보험");

  private final int insuranceNumber;
  private final String description;

  InsuranceType(int insuranceNumber, String description) {
    this.insuranceNumber = insuranceNumber;
    this.description = description;
  }

  public static InsuranceType findByNumber(int insuranceNumber) {
    return Arrays.stream(InsuranceType.values())
        .filter(insurance -> insurance.getInsuranceNumber() == insuranceNumber)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("해당 보험 번호를 찾을 수 없습니다."));
  }

  public int getInsuranceNumber() {
    return insuranceNumber;
  }

  public String getDescription() {
    return description;
  }
}
