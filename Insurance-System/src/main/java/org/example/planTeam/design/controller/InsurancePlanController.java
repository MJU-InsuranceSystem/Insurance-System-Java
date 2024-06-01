package org.example.planTeam.design.controller;


import org.example.Team;
import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.inspection.InsuranceInspectionView;
import org.example.planTeam.design.usecase.DesignUseCase;
import org.example.planTeam.design.view.DesignTeamView;

import static org.example.planTeam.design.model.proposal.ProposalConstant.DESIGN_TEAM_NAME;

public class InsurancePlanController implements TeamController {

    private final DesignTeamView designTeamView;
    private final InsuranceInspectionView insuranceInspectionView;
    private final Team insurancePlanTeam;
    private final Team insuranceInspectionTeam;

    public InsurancePlanController(DesignTeamView designTeamView,
        InsuranceInspectionView insuranceInspectionView, Team insurancePlanTeam,
        Team insuranceInspectionTeam) {
        this.designTeamView = designTeamView;
        this.insuranceInspectionView = insuranceInspectionView;
        this.insurancePlanTeam = insurancePlanTeam;
        this.insuranceInspectionTeam = insuranceInspectionTeam;
    }


    @Override
    public void process() {
        this.designTeamView.intro(DESIGN_TEAM_NAME);
        int selectInt = this.designTeamView.selectUsecase(DesignUseCase.class);
        DesignUseCase useCase = DesignUseCase.findByNumber(selectInt);
        startProcess(useCase);


    }

    private void startProcess(DesignUseCase useCase) {
        switch (useCase) {
            case CREATE_INSURANCE -> {
                RequestDto requestDto = designTeamView.createInsurance();
                ResponseDto responseDto = insurancePlanTeam.register(requestDto);
                designTeamView.createInsurance(responseDto);
            }
            case ASK_INSURANCE_AUTHORIZATION -> {
                RequestDto requestDto = designTeamView.requestAuthorization();
                ResponseDto responseDto = insurancePlanTeam.retrieve(requestDto);
                requestDto = designTeamView.requestAuthorization(responseDto);
                responseDto = insurancePlanTeam.retrieve(requestDto);

                requestDto = insuranceInspectionView.authorizationInsurance(responseDto);
                responseDto = insuranceInspectionTeam.process(requestDto);
            }
            default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
        }
    }


}
