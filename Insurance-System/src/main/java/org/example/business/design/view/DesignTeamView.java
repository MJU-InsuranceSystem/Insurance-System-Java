package org.example.business.design.view;

import java.util.Scanner;
import org.example.business.design.controller.dto.DesignRequest;
import org.example.business.design.controller.dto.Request;
import org.example.business.design.controller.dto.Response;
import org.example.business.design.view.DesignInspectionController.Function;

public class DesignTeamView {

    private Scanner sc;

    public DesignTeamView(Scanner sc) {
        this.sc = sc;
    }


    public Request process(Function function, Request request) throws Exception {
        return switch (function) {
            case planProposal -> manageProposal(request);
            default -> throw new Exception("힝");
        };
    }

    private Request manageProposal(Request request) throws Exception {
        System.out.println("상품 기획을 누르셨습니다. 어떤 것을 하시겠습니까?\n1번 새로운 상품기획서 만들기. 2번 기존 기획 관리하기.");
        int selectNumber = sc.nextInt();
        return switch (selectNumber) {
            case 1 -> createProposal(request);
            case 2 -> modifyProposal(request);
            default -> throw new Exception("힝");
        };

    }

    private Request modifyProposal(Request request) {
        return null;
    }

    private Request createProposal(Request request) {
        System.out.println("상품 기획서 제목을 입력하세요.");
        DesignRequest designRequest = (DesignRequest) request;
        designRequest.setTitle(sc.next());
        System.out.println("상품 개요를 입력하세요.");
        designRequest.setProductOverView(sc.nextLine());
        System.out.println("조사한 시장 상황을 입력하세요.");
        designRequest.setMarketReserach(sc.nextLine());
        System.out.println("판매 전략을 입력하세요.");
        designRequest.setSaleStrategy(sc.nextLine());
        System.out.println("보험 납부 방법에 대해서 입력하세요.");
        designRequest.setInsurancePayment(sc.nextLine());
        System.out.println("예상되는 판매 대상을 입력하세요.");
        designRequest.setSaleTarget(sc.nextLine());
        System.out.println("제출하시겠습니까?");
        return sc.nextInt() == 1 ? yes(designRequest) : no();
    }

    private Request no() {
        return null;
    }

    private Request yes(Request request) {
        System.out.println("제출이 완료되었습니다.");
        return request;
    }

    public boolean process(Function function, Response response) throws Exception {
        return switch (function) {
            case planProposal -> manageProposal2(response);
            default -> throw new Exception("힝");
        };
    }

    private boolean manageProposal2(Response response) {
        System.out.println("반환값에 필요한 거 꺼내서 출력");
        return true;
    }

}
