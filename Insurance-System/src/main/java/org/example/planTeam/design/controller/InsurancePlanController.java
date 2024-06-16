package org.example.planTeam.design.controller;


import static org.example.planTeam.design.model.insurance.InsuranceConstant.ALL;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ENTITY_KIND;
import static org.example.planTeam.design.model.insurance.InsuranceConstant.ENTITY_LIST;
import static org.example.planTeam.design.model.proposal.ProposalConstant.DESIGN_TEAM_NAME;
import static org.example.planTeam.design.model.proposal.ProposalConstant.PROPOSAL;

import java.util.Objects;
import org.example.Team;
import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.model.designPlan.DesignConstant;
import org.example.planTeam.design.usecase.DesignUseCase;
import org.example.planTeam.design.view.InsurancePlanView;
import org.example.planTeam.inspection.InsuranceInspectionView;

public class InsurancePlanController implements TeamController {

    private final InsurancePlanView insurancePlanView;
    private final InsuranceInspectionView insuranceInspectionView;
    private final Team insurancePlanTeam;
    private final Team insuranceInspectionTeam;

    public InsurancePlanController(InsurancePlanView insurancePlanView,
        InsuranceInspectionView insuranceInspectionView, Team insurancePlanTeam,
        Team insuranceInspectionTeam) {
        this.insurancePlanView = insurancePlanView;
        this.insuranceInspectionView = insuranceInspectionView;
        this.insurancePlanTeam = insurancePlanTeam;
        this.insuranceInspectionTeam = insuranceInspectionTeam;
    }


    @Override
    public void process() {
        this.insurancePlanView.intro(DESIGN_TEAM_NAME);
        int selectInt = this.insurancePlanView.selectUsecase(DesignUseCase.class);
        DesignUseCase useCase = DesignUseCase.findByNumber(selectInt);
        startProcess(useCase);
    }

    private void startProcess(DesignUseCase useCase) {
        switch (useCase) {
            case ASK_INSURANCE_AUTHORIZATION -> {
                RequestDto requestDto = insurancePlanView.requestAuthorization();
                ResponseDto responseDto = insurancePlanTeam.retrieve(requestDto);
                requestDto = insurancePlanView.requestAuthorization(responseDto);
                responseDto = insurancePlanTeam.retrieve(requestDto);

                requestDto = insuranceInspectionView.authorizationInsurance(responseDto);
                responseDto = insurancePlanTeam.process(requestDto);
                insurancePlanView.showAuthrizationResult(responseDto);
            }
            case PLAN_INSURANCE -> {
                RequestDto requestDto = insurancePlanView.createProposal();
                ResponseDto responseDto = insurancePlanTeam.register(requestDto);
                insurancePlanView.completeCreateProposal(responseDto);
            }
            case DESIGN_INSURANCE -> {
                RequestDto requestDto = new RequestDto();
                ResponseDto responseDto;
                requestDto.add(ENTITY_LIST, ALL);
                requestDto.add(ENTITY_KIND, PROPOSAL);

                requestDto = insurancePlanView.selectProposal(insurancePlanTeam.retrieve(requestDto));
                responseDto = insurancePlanTeam.retrieve(requestDto);
                requestDto = insurancePlanView.createDesign(responseDto);
                RequestDto requestInsuranceDto = insurancePlanView.createInsurance();

                insurancePlanTeam.register(requestInsuranceDto);
                responseDto = insurancePlanTeam.register(requestDto);
                insurancePlanView.completeCreateDesignPlan(responseDto);
            }
            case MANAGE_INSURANCE -> {
                RequestDto requestDto = insurancePlanView.requestInsurances();
                if (Objects.equals(requestDto.get(DesignConstant.READ_INSURANCE_RESULT), "Y")) {
                    ResponseDto responseDto = insurancePlanTeam.retrieve(requestDto);
                    insurancePlanView.showAllInsurance(responseDto);
                    return;
                }
                insurancePlanView.denyShowInsurances();
            }
            default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
        }
    }
}
