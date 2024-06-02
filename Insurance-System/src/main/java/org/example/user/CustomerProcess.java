package org.example.user;

import java.util.Arrays;

public enum CustomerProcess {
  APPLY_INSURANCE_JOIN(1, "보험 가입 신청하기"),
  PAY_INSURANCE_PREMIUM(2, "보험료 납부하기"),
  REQUIRE_INSURANCE_BENEFIT(3, "보험금을 청구하기"),
  RETRIEVE_CONTRACT(4, "가입 보험 조회하기");

  private int processNumber;
  private String description;

  CustomerProcess(int processNumber, String description) {
    this.processNumber = processNumber;
    this.description = description;
  }

  public int getProcessNumber() {
    return processNumber;
  }

  public String getDescription() {
    return description;
  }

  public static CustomerProcess findByNumber(int processNumber) {
    return Arrays.stream(CustomerProcess.values())
        .filter(usecase -> usecase.getProcessNumber() == processNumber)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("해당 업무 번호를 찾을 수 없습니다."));
  }
}
