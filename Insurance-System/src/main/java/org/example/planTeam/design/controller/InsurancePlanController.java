package org.example.planTeam.design.controller;


import org.example.Team;
import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.inspection.InsuranceInspectionView;
import org.example.planTeam.design.usecase.DesignUseCase;
import org.example.planTeam.design.view.InsurancePlanView;

import static org.example.planTeam.design.model.insurance.InsuranceConstant.ENTITY_KIND;
import static org.example.planTeam.design.model.proposal.ProposalConstant.DESIGN_TEAM_NAME;
import static org.example.planTeam.design.model.proposal.ProposalConstant.KIND;
import static org.example.planTeam.design.model.proposal.ProposalConstant.PROPOSAL;

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
            case CREATE_INSURANCE -> {
                RequestDto requestDto = insurancePlanView.createInsurance();
                ResponseDto responseDto = insurancePlanTeam.register(requestDto);
                insurancePlanView.createInsurance(responseDto);
            }
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
                requestDto.add("객체리스트", "전체");
                requestDto.add(ENTITY_KIND, PROPOSAL);

                requestDto = insurancePlanView.selectProposal(
                    insurancePlanTeam.retrieve(requestDto));
                responseDto = insurancePlanTeam.retrieve(requestDto);
                requestDto = insurancePlanView.createDesign(responseDto);
                responseDto = insurancePlanTeam.register(requestDto);
                insurancePlanView.completeCreateDesignPlan(responseDto);
            }
            default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
        }
    }


}
