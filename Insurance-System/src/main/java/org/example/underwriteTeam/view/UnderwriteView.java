package org.example.underwriteTeam.view;

import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.common.view.DepartmentView;
import org.example.planTeam.Status;

public class UnderwriteView extends DepartmentView {

  public static final String POLICY_NUMBER = "number";
  public static final String POLICY_NAME = "name";
  public static final String POLICY_RISK = "riskAssessmentCriteria";
  public static final String POLICY_PREMIUM = "premiumCalculationCriteria";
  public static final String POLICY_SUBSCRIPTION = "subscriptionReviewCriteria";

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

  public RequestDto performUnderwriting() {
    RequestDto requestDto = new RequestDto();
    return requestDto;
  }

  public RequestDto requireCoUnderwriting() {
    RequestDto requestDto = new RequestDto();
    return requestDto;
  }

  public void showCreatePolicyResult(ResponseDto responseDto) {
  }

  public void showPerformUnderwritingResult(ResponseDto responseDto) {
  }

  public void showRequireCoUnderwritingResult(ResponseDto responseDto) {
  }
}
