package org.example.planTeam.design;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.Status;
import org.example.planTeam.design.model.designPlan.DesignPlanList;
import org.example.planTeam.design.model.insurance.Insurance;
import org.example.planTeam.design.model.proposal.Proposal;
import org.example.planTeam.design.model.proposal.Proposal.ProposalBuilder;
import org.example.planTeam.design.model.proposal.ProposalList;

import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE_NAME;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.RESPONSIBLE_PERSON;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.SUBSCRIBER_RIGHTS_AND_OBLIGATION;
import static org.example.planTeam.design.model.proposal.ProposalConstant.*;

/**
 * @author USER
 * @version 1.0
 */
public class DesignInspectionTeam extends Team {

    private final DesignPlanList designPlanList;
    private final ProposalList proposalList;

    public DesignInspectionTeam(DesignPlanList designPlanList, ProposalList proposalList) {
        this.designPlanList = designPlanList;
        this.proposalList = proposalList;
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
                insurance.setInsuranceName(request.get(INSURANCE_NAME));
                insurance.setResponsiblePerson(request.get(RESPONSIBLE_PERSON));
                insurance.setReightObligation(request.get(SUBSCRIBER_RIGHTS_AND_OBLIGATION));
                ResponseDto responseDto = new ResponseDto();
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
        return null;
    }
}