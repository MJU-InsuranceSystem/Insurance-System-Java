package org.example.planTeam.design.view;

import org.example.common.view.DepartmentView;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.Status;

import static org.example.planTeam.design.view.ProposalConstant.*;


public class DesignTeamView extends DepartmentView {


    public DesignTeamView() {
    }


    public RequestDto manageProposal() {
        return null;
    }

    public RequestDto modifyProposal() {
        return null;
    }

    public RequestDto createProposal() {
        RequestDto designRequest = new RequestDto();
        designRequest.add(KIND, PROPOSAL);

        println("상품 기획서 제목을 입력하세요.");
        designRequest.add(PROPOSAL_TITLE, writeString());

        println("상품 개요를 입력하세요.");
        designRequest.add("productOverview", writeString());

        println("조사한 시장 상황을 입력하세요.");
        designRequest.add(MARKET_RESEARCH, writeString());

        println("판매 전략을 입력하세요.");
        designRequest.add(SALE_STRATEGY, writeString());

        println("보험 납부 방법에 대해서 입력하세요.");
        designRequest.add(Insurance_Payment, writeString());

        println("예상되는 판매 대상을 입력하세요.");
        designRequest.add(SALE_TARGET, writeString());

        println("보상에 대한 정보를 입력하세요.");
        designRequest.add(REWARD, writeString());

        return askSubmit(designRequest);

    }

    private RequestDto askSubmit(RequestDto requestDto) {
        println("제출하시겠습니까?");
        return writeInt() == 1 ? yes(requestDto) : no();
    }


    public RequestDto no() {
        return null;
    }

    public RequestDto yes(RequestDto request) {
        println("제출이 완료되었습니다.");
        return request;
    }
    

    public void completeObect(RequestDto requestDto) {
        System.out.println("완성");
    }

    public void completeCreateProposal(ResponseDto responseDto) {
        if (responseDto.get(Status.key()).equals(Status.SUCCESS.getStatus())) {
            System.out.println("일단 기획서 추가 완료요~");
        } else {
            System.out.println("나중에 responseDTO에 에러메시지 상태를 담도록 만들어야겠당.");
        }
    }
}
