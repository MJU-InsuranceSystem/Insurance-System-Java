package org.example.planTeam.inspection;

import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE_NAME;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.RESPONSIBLE_PERSON;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.RESTRICTION_REGULATION;
import static org.example.planTeam.design.model.proposal.ProposalConstant.INSURANCE_KIND;
import static org.example.planTeam.design.model.proposal.ProposalConstant.KIND;
import static org.example.planTeam.design.model.reward.RewardConstant.INSURANCE_RATE;
import static org.example.planTeam.design.model.reward.RewardConstant.MAX_REWARD;
import static org.example.planTeam.design.model.reward.RewardConstant.MONTH_PAYMENT_FEE;
import static org.example.user.CustomerView.INSURANCE_ID;

import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.common.view.DepartmentView;

public class InsuranceInspectionView extends DepartmentView {

    public RequestDto authorizationInsurance(ResponseDto responseDto) {
        String insuranceId = responseDto.get(INSURANCE_ID);
        String insuranceName = responseDto.get(INSURANCE_NAME);
        String insuranceKind = responseDto.get(INSURANCE_KIND);
        String person = responseDto.get(RESPONSIBLE_PERSON);
        String maxPay = responseDto.get(MAX_REWARD);
        String monthPay = responseDto.get(MONTH_PAYMENT_FEE);
        String rate = responseDto.get(INSURANCE_RATE);
        String restriction = responseDto.get(RESTRICTION_REGULATION);

        print("보험 번호: " + insuranceId + "보험 이름: " + insuranceName + " 보험 종류: " + insuranceKind
            + " 책임자: "
            + person + " 최대 보상액: " + maxPay
            + " 월 보험료: " + monthPay + " 보험요율: " + rate + " 제약 사항: " + restriction);
        // 상품 설계안을 보여주는 로직
        RequestDto requestDto = new RequestDto();
        requestDto.add(KIND, "인가");
        print("이 보험 상품에 대한 인가를 허가 하겠습니까?\nY/N");
        requestDto.add("인가응답", writeString());
        print("인가 결정 날짜를 입력해주세요.");
        requestDto.add("날짜", writeString());
        print("인가를 결정한 담당자 이름을 입력해주세요.");
        requestDto.add("책임자이름", writeString());
        print("결정에 대한 사유를 입력해주세요.");
        requestDto.add("reason", writeString());
        requestDto.add("값", responseDto.get("값"));
        return requestDto;
    }
}
