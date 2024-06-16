package org.example.planTeam.design;

import static org.example.planTeam.design.model.designPlan.DesignConstant.DESIGNPLAN;
import static org.example.planTeam.design.model.designPlan.DesignConstant.DESIGN_CONTENT;
import static org.example.planTeam.design.model.designPlan.DesignConstant.DESIGN_MANAGER;
import static org.example.planTeam.design.model.designPlan.DesignConstant.DESIGN_TITLE;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ALL;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ENTITY;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ENTITY_KIND;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ENTITY_LIST;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE_NAME;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ONE;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.RESPONSIBLE_PERSON;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.RESTRICTION_REGULATION;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.SUBSCRIBER_RIGHTS_AND_OBLIGATION;
import static org.example.planTeam.design.model.proposal.ProposalConstant.INSURANCE_KIND;
import static org.example.planTeam.design.model.proposal.ProposalConstant.Insurance_Payment;
import static org.example.planTeam.design.model.proposal.ProposalConstant.KIND;
import static org.example.planTeam.design.model.proposal.ProposalConstant.MARKET_RESEARCH;
import static org.example.planTeam.design.model.proposal.ProposalConstant.PRODUCT_OVERVIEW;
import static org.example.planTeam.design.model.proposal.ProposalConstant.PROPOSAL;
import static org.example.planTeam.design.model.proposal.ProposalConstant.PROPOSAL_TITLE;
import static org.example.planTeam.design.model.proposal.ProposalConstant.REWARD;
import static org.example.planTeam.design.model.proposal.ProposalConstant.SALE_STRATEGY;
import static org.example.planTeam.design.model.proposal.ProposalConstant.SALE_TARGET;
import static org.example.planTeam.design.model.reward.RewardConstant.INSURANCE_RATE;
import static org.example.planTeam.design.model.reward.RewardConstant.MAX_REWARD;
import static org.example.planTeam.design.model.reward.RewardConstant.MONTH_PAYMENT_FEE;
import static org.example.user.CustomerView.INSURANCE_ID;

import java.util.Objects;
import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.Status;
import org.example.planTeam.design.model.designPlan.DesignPlan;
import org.example.planTeam.design.model.designPlan.DesignPlanList;
import org.example.planTeam.design.model.insurance.Insurance;
import org.example.planTeam.design.model.insurance.InsuranceList;
import org.example.planTeam.design.model.proposal.Proposal;
import org.example.planTeam.design.model.proposal.Proposal.ProposalBuilder;
import org.example.planTeam.design.model.proposal.ProposalList;
import org.example.planTeam.design.model.reward.Reward;

/**
 * @author USER
 * @version 1.0
 */
public class InsurancePlanTeam extends Team {

    private final DesignPlanList designPlanList;
    private final ProposalList proposalList;
    private final InsuranceList insuranceList;
    private final InsuranceList authrizationInsuranceList;


    public InsurancePlanTeam(DesignPlanList designPlanList, ProposalList proposalList,
        InsuranceList insuranceList, InsuranceList authrizationInsuranceList) {
        this.designPlanList = designPlanList;
        this.proposalList = proposalList;
        this.insuranceList = insuranceList;
        this.authrizationInsuranceList = authrizationInsuranceList;
    }

    @Override
    public ResponseDto manage(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto process(RequestDto request) {
        ResponseDto responseDto = new ResponseDto();
        switch (request.get(KIND)) {
            case "인가" -> {
                if (request.get("인가응답").equalsIgnoreCase("y")) {
                    Insurance insurance = insuranceList.findById(
                        Integer.parseInt(request.get(INSURANCE_ID)));
                    insurance.setDate(request.get("날짜"));
                    insurance.setAuthorizedPerson(request.get("책임자이름"));
                    insurance.setReason(request.get("reason"));
                    authrizationInsuranceList.add(insurance);
                    if (!Objects.isNull(authrizationInsuranceList.findById(
                        Integer.parseInt(request.get(INSURANCE_ID))))) {
                        responseDto.add(Status.getKey(), Status.SUCCESS.getStatus());
                        return responseDto;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public ResponseDto register(RequestDto request) {
        ResponseDto responseDto = new ResponseDto();
        switch (request.get(KIND)) {
            case PROPOSAL -> {
                Proposal proposal = new ProposalBuilder().proposalId(proposalList.getSize())
                    .title(request.get(PROPOSAL_TITLE))
                    .productOverview(request.get(PRODUCT_OVERVIEW))
                    .marketResearch(request.get(MARKET_RESEARCH))
                    .insurancePayment(request.get(Insurance_Payment))
                    .saleStrategy(request.get(SALE_STRATEGY)).saleTarget(request.get(SALE_TARGET))
                    .reward(request.get(REWARD)).build();

                proposalList.add(proposal);
                responseDto.add(Status.getKey(), Status.SUCCESS.getStatus());
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

                responseDto.add(Status.getKey(), Status.SUCCESS.getStatus());
                return responseDto;
            }
            case DESIGNPLAN -> {
                DesignPlan designPlan = new DesignPlan();
                designPlan.setProposal(
                    proposalList.findById(Integer.parseInt(request.get("기획서번호"))));
                designPlan.setDesingPlanTitle(request.get(DESIGN_TITLE));
                designPlan.setContent(request.get(DESIGN_CONTENT));
                designPlan.setManager(request.get(DESIGN_MANAGER));
                designPlanList.add(designPlan);
                responseDto.add(Status.getKey(), Status.SUCCESS.getStatus());
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
        switch (request.get(ENTITY_LIST)) {
            case ALL -> {
                switch (request.get(ENTITY_KIND)) {
                    case INSURANCE -> {
                        for (Insurance insurance : insuranceList.getList()) {
                            responseDto.add(insurance.getInsuranceId(), insurance.toString());
                        }
                    }
                    case PROPOSAL -> {
                        for (Proposal proposal : proposalList.getList()) {
                            responseDto.add(Integer.toString(proposal.getProposalId()),
                                proposal.toString());
                        }
                    }
                }


            }
            case ONE -> {
                switch (request.get(ENTITY_KIND)) {
                    case INSURANCE -> {
                        Insurance insurance = insuranceList.findById(
                            Integer.parseInt(request.get("선택번호")));
                        responseDto.add(INSURANCE_ID, insurance.getInsuranceId());
                        responseDto.add(INSURANCE_NAME, insurance.getInsuranceName());
                        responseDto.add(INSURANCE_KIND,
                            insurance.getInsuranceType().getDescription());
                        responseDto.add(RESPONSIBLE_PERSON, insurance.getResponsiblePerson());
                        Reward reward = insurance.getReward();
                        responseDto.add(MAX_REWARD, Integer.toString(reward.getMaxReward()));
                        responseDto.add(MONTH_PAYMENT_FEE,
                            Integer.toString(reward.getMonthPaymentFee()));
                        responseDto.add(INSURANCE_RATE,
                            Integer.toString(reward.getInsuranceRate()));
                        responseDto.add(RESTRICTION_REGULATION, reward.getRestrictionRegulation());
                        responseDto.add(ENTITY, insurance.toEntity());
                    }
                    case PROPOSAL -> {
                        Proposal proposal = proposalList.findById(
                            Integer.parseInt(request.get("선택번호")));
                        responseDto.add(ENTITY, proposal.toEntity());
                    }
                    case DESIGNPLAN -> {

                    }
                }
            }
        }
        return responseDto;

    }
}