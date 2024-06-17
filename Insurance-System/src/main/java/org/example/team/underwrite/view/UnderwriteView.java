package org.example.team.underwrite.view;

import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
import org.example.common.exception.NotCorrectFormat;
import org.example.common.view.DepartmentView;
import org.example.team.plan.Status;

public class UnderwriteView extends DepartmentView {

  public static final String USECASE_NUMBER = "usecaseNumber";
  public static final String POLICY_NUMBER = "policyNumber";
  public static final String POLICY_NAME = "name";
  public static final String POLICY_RISK = "riskAssessmentCriteria";
  public static final String POLICY_PREMIUM = "premiumCalculationCriteria";
  public static final String POLICY_SUBSCRIPTION = "subscriptionReviewCriteria";
  public static final String ALL_INSURANCE_APPLY = "allInsurance";
  public static final String UNDERWRITING_RESULT = "underwritingResult";
  public static final String FINISH_INSURANCE_ID = "finishInsuranceId";
  public static final String FINISH_INSURANCE_CUSTOMER_NAME = "finishInsuranceName";
  public static final String CONTRACT_INFO = "contractInfo";
  public static final String SELECT_APPLICATION_ID = "selectApplicationId";
  public static final String ONE_SELECT_INSURANCE = "oneSelectInsurance";

  public RequestVO createPolicy() {
    RequestVO requestVO = new RequestVO();
    println("인수 정책을 수립하기 위한 정보를 입력해주세요.");
    print("정책 번호 : ");
    requestVO.add(POLICY_NUMBER, writeString());
    print("정책 이름 : ");
    requestVO.add(POLICY_NAME, writeString());
    print("위험 평가 기준 : ");
    requestVO.add(POLICY_RISK, writeString());
    print("보험료 책정 기준 : ");
    requestVO.add(POLICY_PREMIUM, writeString());
    print("가입 심사 기준 : ");
    requestVO.add(POLICY_SUBSCRIPTION, writeString());
    return requestVO;
  }

  public void complete(ResponseVO responseVO) {
    println("업무 수행을 완료하였습니다.");
    println("상태 코드 : " + responseVO.get(Status.getKey()));
  }

  public RequestVO performUnderwriting(ResponseVO responseVO) {
    RequestVO requestVO = new RequestVO();
    println("인수 심사할 보험의 정보는 아래와 같습니다.");
    println(responseVO.get(ONE_SELECT_INSURANCE));
    print("인수를 허가하겠습니까?(Y/N) :");
    requestVO.add(UNDERWRITING_RESULT, writeString());
    return requestVO;
  }

  public RequestVO requireCoUnderwriting() {
    RequestVO requestVO = new RequestVO();
    return requestVO;
  }

  public void showCreatePolicyResult(ResponseVO responseVO) {
    println("인수 정책 수립을 성공적으로 수행하였습니다.");
  }

  public void showPerformUnderwritingResult(ResponseVO responseVO) {
    String result = responseVO.get(UnderwriteView.UNDERWRITING_RESULT);
    switch (result) {
      case "Y" -> {
        println("인수가 허가되어 계약을 등록하였습니다");
      }
      case "N" -> {
        println("인수가 거부되었습니다.");
      }
      default -> {
        throw new NotCorrectFormat("잘못된 값을 입력하였습니다.");
      }
    }
  }

  public void showRequireCoUnderwritingResult(ResponseVO responseVO) {
  }

  public void showErrorMessage(String message) {
    println(message);
  }

  public void showContractResult(ResponseVO contractResult) {
    println("등록된 계약의 정보는 아래와 같습니다.");
    println(contractResult.get(CONTRACT_INFO));
  }

  public void inNotExistInsuranceApply() {
    println("인수 심사할 대상이 존재하지 않습니다.");
  }

  public int selectApplicationId(String insuranceInfo) {
    println("아래의 가입신청 보험리스트 중 보험ID를 선택하세요");
    print(insuranceInfo);
    return writeInt();
  }
}
