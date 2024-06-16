package org.example.rewardSupportTeam.view;

import org.example.common.view.DepartmentView;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.Status;

public class RewardSupportView extends DepartmentView {

    // accident
    public static final String ACCIDENT_CONTENT = "content";
    public static final String ACCIDENT_NAME = "name";
    // claimInsurance
    public static final String CLAIMINSURANCE_ACCOUNT = "account";
    public static final String CLAIMINSURANCE_ADDRESS = "address";
    public static final String CLAIMINSURANCE_PHONENUMBER = "phoneNumber";
    public static final String CLAIMINSURANCE_RESIDENTNUMBER = "residentNumber";
    public static final String CLAIMINSURANCE_SUPPORTINGFILE = "supportingFile";
    //judgeAnswer
    public static final String JUDGE_ANSWER = "answer";
    public static final String NOT_PAID_CUSTOMER = "notPaidCustomer";
    public static final String PAY_ANSWER = "pay_answer";
    public static final String ACCIDENT_ANSWER = "accidet_answer";

    public static final String ALL = "전체";
    public static final String ENTITY_LIST = "객체리스트";

    public RequestDto submitAccident() {
        RequestDto requestDto = new RequestDto();
        println("고객의 사건을 접수하시겠습니까? (Y/N)");
        requestDto.add(ACCIDENT_ANSWER, writeString());
        return requestDto;
    }

    public void completeSubmitAccident(ResponseDto responseDto) {
        if (responseDto.get(Status.getKey()).equals(Status.SUCCESS.getStatus())) {
            println("성공적으로 사고가 접수되었습니다.");
        }
        println("고객으로부터 보험금 신청 접수가 된 것이 없습니다.");
    }

    public RequestDto judgeFault(ResponseDto responseDto) {
        RequestDto requestDto = new RequestDto();

        println(responseDto.get(ENTITY_LIST));
        println("면/부책을 판단하시겠습니까? (Y/N) ");
        requestDto.add(JUDGE_ANSWER, writeString());
        return requestDto;
    }

    public void completeJudgeFault(ResponseDto responseDto) {
        if (responseDto.get(Status.getKey()).equals(Status.SUCCESS.getStatus())) {
            println("면/부책 판단에 성공하셨습니다.");
        } else if (responseDto.get(Status.getKey()).equals(Status.FAIL.getStatus())) {
            println("면/부책 판단을 취소하였습니다.");
        } else if (responseDto.get(Status.getKey()).equals(Status.EMPTY.getStatus())) {
            println("고객으로부터 보험금 신청 접수가 된 것이 없습니다.");
        } else {
            println("잘못된 입력값입니다. 다시 시도해주세요.");
        }
    }

    public void showNotPaidCustomer(ResponseDto responseDto) {
        String notPaidCustomers = responseDto.get(NOT_PAID_CUSTOMER);
        System.out.println("미납자 목록 : " + notPaidCustomers);
    }

    public RequestDto payInsurance() {
        RequestDto requestDto = new RequestDto();
        println("고객에게 보험금을 지급하시겠습니까? (Y/N) ");
        requestDto.add(PAY_ANSWER, writeString());
        return requestDto;
    }

    public void completePayInsurance(ResponseDto responseDto) {
        if (responseDto.get(Status.getKey()).equals(Status.SUCCESS.getStatus())) {
            println(responseDto.get(ACCIDENT_NAME) +"님의 " + responseDto.get(CLAIMINSURANCE_ACCOUNT) + " 계좌로 입금 하였습니다.");
            println("최종 보험금 지급에 성공하였습니다.");
        } else {
            println("보험금 지급에 실패하였습니다");
        }
    }

    public RequestDto manageLawsuit() {
        RequestDto requestDto = new RequestDto();
        println("소송 관리 메뉴 입니다. 원하는 번호를 입력해주세요");
        println("1. 소송을 등록한다");

        requestDto.add(JUDGE_ANSWER, writeString());
        return requestDto;
    }
}
