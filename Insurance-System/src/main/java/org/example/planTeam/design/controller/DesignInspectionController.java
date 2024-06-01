package org.example.planTeam.design.controller;


import org.example.Team;
import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.usecase.DesignUseCase;
import org.example.planTeam.design.view.DesignTeamView;

import static org.example.planTeam.design.model.proposal.ProposalConstant.DESIGN_TEAM_NAME;

public class DesignInspectionController implements TeamController {

    private final DesignTeamView designTeamView;

    private final Team designInspectionTeam;

    public DesignInspectionController(DesignTeamView designTeamView, Team designInspectionTeam) {
        this.designTeamView = designTeamView;
        this.designInspectionTeam = designInspectionTeam;
    }


    @Override
    public void process() {
        this.designTeamView.intro(DESIGN_TEAM_NAME);
        int selectInt = this.designTeamView.selectUsecase(DesignUseCase.class);
        DesignUseCase useCase = DesignUseCase.findByNumber(selectInt);
        RequestDto requestDto = showUsecaseRequireInfo(useCase);
        ResponseDto responseDto = teamAction(useCase, requestDto);
//        ResponseDto responseDto = useCase.teamAction(designInspectionTeam, requestDto);
//        useCase.showResult(this.designTeamView, responseDto);
    }

    private ResponseDto teamAction(DesignUseCase useCase, RequestDto requestDto) {
        switch (useCase) {
            case CREATE_INSURANCE -> {
                return designInspectionTeam.register(requestDto);
            }
            default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
        }
    }

    private RequestDto showUsecaseRequireInfo(DesignUseCase useCase) {
        switch (useCase) {
            case CREATE_INSURANCE -> {
                return designTeamView.createInsurance();
            }
            default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
        }
    }
}
