package org.example.planTeam.design.view;

import java.util.Scanner;
import org.example.common.DepartmentView;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;


public class DesignTeamView extends DepartmentView {

    public DesignTeamView() {
    }

    public void intro() {
        System.out.println("보험 기획팀입니다. 업무를 선택해주세요.");
    }

    public RequestDto manageProposal() {
        return null;
    }

    public RequestDto modifyProposal() {
        return null;
    }

    public RequestDto createProposal() {
//        System.out.println("상품 기획서 제목을 입력하세요.");
//        RequestDto designRequest = new RequestDto();
//        designRequest.setTitle(sc.next());
//        System.out.println("상품 개요를 입력하세요.");
//        designRequest.setProductOverView(sc.nextLine());
//        System.out.println("조사한 시장 상황을 입력하세요.");
//        designRequest.setMarketReserach(sc.nextLine());
//        System.out.println("판매 전략을 입력하세요.");
//        designRequest.setSaleStrategy(sc.nextLine());
//        System.out.println("보험 납부 방법에 대해서 입력하세요.");
//        designRequest.setInsurancePayment(sc.nextLine());
//        System.out.println("예상되는 판매 대상을 입력하세요.");
//        designRequest.setSaleTarget(sc.nextLine());
//        System.out.println("제출하시겠습니까?");
//        return sc.nextInt() == 1 ? yes(designRequest) : no();
        return null;
    }


    public RequestDto no() {
        return null;
    }

    public RequestDto yes(RequestDto request) {
        System.out.println("제출이 완료되었습니다.");
        return request;
    }


    public boolean manageProposal2(ResponseDto response) {
        System.out.println("반환값에 필요한 거 꺼내서 출력");
        return true;
    }

    public void completeObect(RequestDto requestDto) {
        System.out.println("완성");
    }

}
