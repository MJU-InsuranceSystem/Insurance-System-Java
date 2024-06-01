package org.example.planTeam.design;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.model.insurance.InsuranceList;
import org.example.planTeam.Status;
import org.example.planTeam.design.model.designPlan.DesignPlanList;
import org.example.planTeam.design.model.insurance.Insurance;
import org.example.planTeam.design.model.proposal.Proposal;
import org.example.planTeam.design.model.proposal.Proposal.ProposalBuilder;
import org.example.planTeam.design.model.proposal.ProposalList;
import org.example.planTeam.design.model.reward.Reward;
import org.example.planTeam.inspection.InsuranceInspectionTeam;

import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE_NAME;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.RESPONSIBLE_PERSON;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.RESTRICTION_REGULATION;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.SUBSCRIBER_RIGHTS_AND_OBLIGATION;
import static org.example.planTeam.design.model.proposal.ProposalConstant.*;
import static org.example.planTeam.design.model.reward.RewardConstant.INSURANCE_RATE;
import static org.example.planTeam.design.model.reward.RewardConstant.MAX_REWARD;
import static org.example.planTeam.design.model.reward.RewardConstant.MONTH_PAYMENT_FEE;
import static org.example.user.CustomerView.INSURANCE_ID;

/**
 * @author USER
 * @version 1.0
 */
public class InsurancePlanTeam extends Team {

    private final DesignPlanList designPlanList;
    private final ProposalList proposalList;

    private final InsuranceList insuranceList;


    public InsurancePlanTeam(DesignPlanList designPlanList, ProposalList proposalList,
        InsuranceList insuranceList) {
        this.designPlanList = designPlanList;
        this.proposalList = proposalList;
        this.insuranceList = insuranceList;
    }

    @Override
    public ResponseDto manage(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto process(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto register(RequestDto request) {
        switch (request.get(KIND)) {
            case PROPOSAL -> {
                Proposal proposal = new ProposalBuilder().proposalId(proposalList.getSize())
                    .title(request.get(PROPOSAL_TITLE)).productOverview(PRODUCT_OVERVIEW)
                    .marketResearch(MARKET_RESEARCH).insurancePayment(Insurance_Payment)
                    .saleStrategy(SALE_STRATEGY).saleTarget(SALE_TARGET).reward(REWARD).build();

                proposalList.add(proposal);
                ResponseDto responseDto = new ResponseDto();
                responseDto.add(Status.key(), Status.SUCCESS.getStatus());
                return responseDto;
            }
            case INSURANCE -> {
                Insurance insurance = new Insurance();
                insurance.setInsuranceId(Integer.toString(this.insuranceList.getList().size()));
                insurance.setInsuranceType(request.get(INSURANCE_KIND));
                insurance.setInsuranceName(request.get(INSURANCE_NAME));
                insurance.setResponsiblePerson(request.get(RESPONSIBLE_PERSON));
                insurance.setReightObligation(request.get(SUBSCRIBER_RIGHTS_AND_OBLIGATION));

                Reward reward = insurance.getReward();
                reward.setRewardId(Integer.parseInt(insurance.getInsuranceId()));
                reward.setMaxReward(Integer.parseInt(request.get(MAX_REWARD)));
                reward.setMonthPaymentFee(Integer.parseInt(request.get(MONTH_PAYMENT_FEE)));
                reward.setInsuranceRate(Integer.parseInt(request.get(INSURANCE_RATE)));
                reward.setRestrictionRegulation(request.get(RESTRICTION_REGULATION));

                this.insuranceList.add(insurance);
                ResponseDto responseDto = new ResponseDto();
                responseDto.add(Status.key(), Status.SUCCESS.getStatus());
                return responseDto;
            }
            default -> {
                throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
            }
        }

    }

    @Override
    public ResponseDto remove(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto retrieve(RequestDto request) {
        ResponseDto responseDto = new ResponseDto();
        switch (request.get("객체리스트")) {
            case "전체" -> {
                for (Insurance insurance : insuranceList.getList()) {
                    responseDto.add(insurance.getInsuranceId(), insurance.toString());
                }

            }
            case "한개" -> {
                Insurance insurance = insuranceList.findById(Integer.parseInt(request.get("선택번호")));
                responseDto.add(INSURANCE_ID, insurance.getInsuranceId());
                responseDto.add(INSURANCE_NAME, insurance.getInsuranceName());
                responseDto.add(INSURANCE_KIND, insurance.getInsuranceType().getDescription());
                responseDto.add(RESPONSIBLE_PERSON, insurance.getResponsiblePerson());
                Reward reward = insurance.getReward();
                responseDto.add(MAX_REWARD, Integer.toString(reward.getMaxReward()));
                responseDto.add(MONTH_PAYMENT_FEE, Integer.toString(reward.getMonthPaymentFee()));
                responseDto.add(INSURANCE_RATE, Integer.toString(reward.getInsuranceRate()));
                responseDto.add(RESTRICTION_REGULATION, reward.getRestrictionRegulation());
                responseDto.add("값", insurance.toEntity());
            }
        }
        return responseDto;

    }
}