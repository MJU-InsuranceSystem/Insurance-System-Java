package org.example.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.example.common.dto.RequestDto;
import org.example.insurance.InsuranceType;

public class CustomerView {

  public static final String INSURANCE_ID = "id";
  public static final String INSURANCE_NUMBER = "number";
  public static final String FIRE_INFO = "fireInfo";
  public static final String SUBSCRIBER_NAME = "name";
  public static final String ACCOUNT_NUMBER = "accountNumber";
  public static final String DETAIL = "detail";
  public static final String MONTH_PAYMENT = "monthPayment";
  private static int INSURANCE_COUNT = 0;

  public void successTask() {
    println("업무 수행을 완료하였습니다.");
  }

  public int selectInsuranceNumber() {
    for (InsuranceType insuranceType : InsuranceType.values()) {
      println(insuranceType.getInsuranceNumber() + ". : " + insuranceType.getDescription());
    }
    return writeInt();
  }

  public RequestDto requireInsuranceInfo() {
    RequestDto requestDto = new RequestDto();
    requestDto.add(INSURANCE_ID,String.valueOf(++INSURANCE_COUNT)) ;
    println("보험 종류를 먼저 선택해 주세요");
    for (InsuranceType insuranceType : InsuranceType.values()) {
      println(insuranceType.getInsuranceNumber() + ". : " + insuranceType.getDescription());
    }
    requestDto.add(INSURANCE_NUMBER, writeString());
    print("보험 가입자 이름 : ");
    requestDto.add(SUBSCRIBER_NAME, writeString());
    print("보험 세부사항 : ");
    requestDto.add(DETAIL, writeString());
    print("월 보험료 : ");
    requestDto.add(MONTH_PAYMENT, writeString());
    print("계좌 번호 : ");
    requestDto.add(ACCOUNT_NUMBER, writeString());
    return requestDto;
  }

  public RequestDto requireFireInfo() {
    RequestDto requestDto = new RequestDto();
    println("화재 보험을 선택하였습니다. 화재 보험 가입에 필요한 정보를 입력해 주세요");
    requestDto.add(INSURANCE_NUMBER, "1");
    print("화재 보험 가입자 이름 : ");
    requestDto.add(SUBSCRIBER_NAME, writeString());
    print("화재 보험 정보 : ");
    requestDto.add(FIRE_INFO, writeString());
    print("계좌 번호 : ");
    requestDto.add(ACCOUNT_NUMBER, writeString());
    return requestDto;
  }

  public RequestDto requireLifeInfo() {
    RequestDto requestDto = new RequestDto();

    return requestDto;
  }

  public RequestDto requireTravelInfo() {
    RequestDto requestDto = new RequestDto();

    return requestDto;
  }

  public RequestDto requireCarInfo() {
    RequestDto requestDto = new RequestDto();

    return requestDto;
  }

  public RequestDto requireCancerInfo() {
    RequestDto requestDto = new RequestDto();

    return requestDto;
  }

  public RequestDto payInsurancePremiumInfo() {
    RequestDto requestDto = new RequestDto();

    return requestDto;
  }

  public RequestDto requireInsuranceBenefitInfo() {
    RequestDto requestDto = new RequestDto();

    return requestDto;
  }

  private String writeString() {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return br.readLine();
    } catch (IOException e) {
      throw new IllegalArgumentException("잘못 입력하였습니다.");
    }
  }

  private int writeInt() {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return Integer.parseInt(br.readLine());
    } catch (IOException e) {
      throw new IllegalArgumentException("잘못 입력하였습니다.");
    }
  }

  private void println(String message) {
    System.out.println(message);
  }

  private void print(String message) {
    System.out.print(message);
  }
}
