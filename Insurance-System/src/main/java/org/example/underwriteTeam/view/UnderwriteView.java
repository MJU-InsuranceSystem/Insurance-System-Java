package org.example.underwriteTeam.view;

import org.example.common.view.DepartmentView;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.Status;

public class UnderwriteView extends DepartmentView {

  public static final String POLICY_NUMBER = "policyNumber";
  public static final String POLICY_NAME = "policyName";
  public static final String POLICY_CONTENTS = "policyContents";

  public RequestDto createPolicy() {
    RequestDto requestDto = new RequestDto();
    println("인수 정책을 수립하기 위한 정보를 입력해주세요.");
    print("정책 번호 : ");
    requestDto.add(POLICY_NUMBER, writeString());
    print("정책 이름 : ");
    requestDto.add(POLICY_NAME, writeString());
    print("정책 내용 : ");
    requestDto.add(POLICY_CONTENTS, writeString());
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
}
