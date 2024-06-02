package org.example.underwriteTeam.view;

import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.common.view.DepartmentView;
import org.example.planTeam.Status;

public class UnderwriteView extends DepartmentView {

  public static final String USECASE_NUMBER = "usecaseNumber";
  public static final String POLICY_NUMBER = "policyNumber";
  public static final String POLICY_NAME = "name";
  public static final String POLICY_RISK = "riskAssessmentCriteria";
  public static final String POLICY_PREMIUM = "premiumCalculationCriteria";
  public static final String POLICY_SUBSCRIPTION = "subscriptionReviewCriteria";
  public static final String FIRST_INSURANCE_APPLY = "firstInsurance";
  public static final String UNDERWRITING_RESULT = "underwritingResult";
  public static final String FINISH_INSURANCE_ID = "finishInsuranceId";
  public static final String FINISH_INSURANCE_CUSTOMER_NAME = "finishInsuranceName";
  public static final String CONTRACT_INFO = "contractInfo";

  public RequestDto createPolicy() {
    RequestDto requestDto = new RequestDto();
    println("인수 정책을 수립하기 위한 정보를 입력해주세요.");
    print("정책 번호 : ");
    requestDto.add(POLICY_NUMBER, writeString());
    print("정책 이름 : ");
    requestDto.add(POLICY_NAME, writeString());
    print("위험 평가 기준 : ");
    requestDto.add(POLICY_RISK, writeString());
    print("보험료 책정 기준 : ");
    requestDto.add(POLICY_PREMIUM, writeString());
    print("가입 심사 기준 : ");
    requestDto.add(POLICY_SUBSCRIPTION, writeString());
    return requestDto;
  }

  public void complete(ResponseDto responseDto) {
    println("업무 수행을 완료하였습니다.");
    println("상태 코드 : " + responseDto.get(Status.key()));
  }

  public RequestDto performUnderwriting(String insuranceApplyInfo) {
    RequestDto requestDto = new RequestDto();
    println("인수 심사할 보험의 정보는 아래와 같습니다.");
    println(insuranceApplyInfo);
    println("===============");
    print("인수를 허가하겠습니까?(Y/N) :");
    requestDto.add(UNDERWRITING_RESULT, writeString());
    return requestDto;
  }

  public RequestDto requireCoUnderwriting() {
    RequestDto requestDto = new RequestDto();
    return requestDto;
  }

  public void showCreatePolicyResult(ResponseDto responseDto) {
    println("인수 정책 수립을 성공적으로 수행하였습니다.");
  }

  public void showPerformUnderwritingResult(ResponseDto responseDto) {
    String result = responseDto.get(UnderwriteView.UNDERWRITING_RESULT);
    switch (result) {
      case "Y" -> {
        println("인수가 허가되어 계약을 등록하였습니다");
      }
      case "N" -> {
        println("인수가 거부되었습니다.");
      }
      default -> {
        println("잘못된 값을 입력하였습니다.");
      }
    }
  }

  public void showRequireCoUnderwritingResult(ResponseDto responseDto) {
  }

  public void showContractResult(ResponseDto contractResult) {
    println("등록된 계약의 정보는 아래와 같습니다.");
    println(contractResult.get(CONTRACT_INFO));
  }

  public void inNotExistInsuranceApply() {
    println("인수 심사할 대상이 존재하지 않습니다.");
  }
}
