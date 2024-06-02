package org.example.planTeam.design.view;

import java.util.Arrays;
import org.example.common.view.DepartmentView;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.insurance.InsuranceType;
import org.example.planTeam.Status;
import org.example.planTeam.design.model.proposal.Proposal;
import org.example.planTeam.design.model.reward.RewardConstant;

import static org.example.planTeam.design.model.designPlan.DesignConstant.DESIGNPLAN;
import static org.example.planTeam.design.model.designPlan.DesignConstant.DESIGN_CONTENT;
import static org.example.planTeam.design.model.designPlan.DesignConstant.DESIGN_MANAGER;
import static org.example.planTeam.design.model.designPlan.DesignConstant.DESIGN_TITLE;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ALL;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ENTITY_KIND;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ENTITY_LIST;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE_NAME;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ONE;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.RESPONSIBLE_PERSON;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.RESTRICTION_REGULATION;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.SUBSCRIBER_RIGHTS_AND_OBLIGATION;
import static org.example.planTeam.design.model.proposal.ProposalConstant.*;


public class InsurancePlanView extends DepartmentView {


    public InsurancePlanView() {
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
            System.out.println("상품 기획이 완료 되었습니다.");
        } else {
            System.out.println("나중에 responseDTO에 에러메시지 상태를 담도록 만들어야겠당.");
        }
    }

    public RequestDto createInsurance() {
        RequestDto requestDto = new RequestDto();
        requestDto.add(KIND, INSURANCE);
        println("보험 종류를 선택하세요.");
        for (InsuranceType insuranceType : InsuranceType.values()) {
            println(insuranceType.getInsuranceNumber() + "번 " + insuranceType.getDescription());
        }

        String insuranceKind = writeIntToString(InsuranceType.values().length);
        requestDto.add(INSURANCE_KIND, insuranceKind);
        println("보험 이름을 입력하세요.");
        requestDto.add(INSURANCE_NAME, writeString());
        println("만든 사람의 이름을 입력하세요.");
        requestDto.add(RESPONSIBLE_PERSON, writeString());
        println("보험에 포함되는 보상 최대 액을 입력하세요.");
        requestDto.add(RewardConstant.MAX_REWARD, writeString());
        println("계약시에 제약사항을 입력해주세요.");
        requestDto.add(RESTRICTION_REGULATION, writeString());
        println("매달 내야하는 보험료를 입력해주세요.");
        requestDto.add(RewardConstant.MONTH_PAYMENT_FEE, writeString());
        println("보험요율을 입력해주세요.");
        requestDto.add(RewardConstant.INSURANCE_RATE, writeString());
        println("보험 가입자의 권리와 의무를 입력해주세요.");
        requestDto.add(SUBSCRIBER_RIGHTS_AND_OBLIGATION, writeString());

        switch (InsuranceType.findByNumber(Integer.parseInt(insuranceKind))) {
            case FIRE -> {

            }
            case LIFE -> {

            }

            case TRAVEL -> {

            }
            case CAR -> {
                println("적용되는 차 종류를 입력해주세요.");
                // car enum으로 써서 선택하기.
//                requestDto.add();
            }
            case CANCER -> {

            }
        }
        return requestDto;
    }

    public RequestDto designProduct() {
        return null;
    }

    public void createInsurance(ResponseDto responseDto) {
        if (responseDto.get(Status.key()).equals(Status.SUCCESS.getStatus())) {
            System.out.println("보험 생성이 완료되었습니다.");
        }
    }

    public RequestDto requestAuthorization() {
        RequestDto requestDto = new RequestDto();
        System.out.println("만들어진 보험 리스트입니다.\n인가 요청을 할 보험 번호를 입력하세요.");
        requestDto.add(ENTITY_LIST, ALL);
        requestDto.add(ENTITY_KIND, INSURANCE);
        return requestDto;
    }

    public RequestDto requestAuthorization(ResponseDto responseDto) {
        RequestDto requestDto = new RequestDto();
        requestDto.add(KIND, "인가요청");

        responseDto.getTotalInfo().forEach(
            (key, value) -> System.out.println("보험 번호: " + key + " " + value));
        requestDto.add(ENTITY_LIST, ONE);
        requestDto.add("선택번호",
            writeIntToString(responseDto.getTotalInfo().size()));
        requestDto.add(ENTITY_KIND, INSURANCE);
        return requestDto;
    }

    public void showAuthrizationResult(ResponseDto responseDto) {
        switch (responseDto.get(Status.key())) {
            case Status.SUCCESS_NUMBER -> {
                System.out.println("보험에 대한 인가가 통과되었습니다.");
            }
        }
    }

    public RequestDto selectProposal(ResponseDto responseDto) {
        RequestDto requestDto = new RequestDto();
        responseDto.getTotalInfo().forEach(
            (key, value) -> System.out.println("기획안 번호: " + key + " " + value));
        println("만들어진 기획안 리스트입니다.\n설계할 기획안 번호를 입력하세요. ");
        requestDto.add("객체리스트", "한개");
        requestDto.add(ENTITY_KIND, PROPOSAL);
        requestDto.add("선택번호", writeIntToString(responseDto.getTotalInfo().size()));
        return requestDto;
    }

    public RequestDto createDesign(ResponseDto responseDto) {
        RequestDto requestDto = new RequestDto();
        String[] proposal = responseDto.get("entity").split(" ");
        println("기획서 번호 | 제목 | 상품 개요| 시장 조사 | 보험 납부 방법 | 판매 전략 | 보상");
        println(Arrays.toString(proposal));
        println("설계안 제목을 입력해주세요.");
        requestDto.add(DESIGN_TITLE, writeString());
        println("설계안 내용을 입력해주세요.");
        requestDto.add(DESIGN_CONTENT, writeString());
        println("설계안 책임자를 입력해주세요.");
        requestDto.add(DESIGN_MANAGER, writeString());

        requestDto.add("기획서번호", proposal[0]);
        requestDto.add(KIND, "설계안");
        return requestDto;
    }

    public void completeCreateDesignPlan(ResponseDto responseDto) {
        if (responseDto.get(Status.key()).equals(Status.SUCCESS.getStatus())) {
            System.out.println("설계안이 등록되었습니다!");
        }
    }
}
