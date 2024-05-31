package org.example.planTeam.design.controller;


import static org.example.planTeam.design.view.ProposalConstant.DESIGN_TEAM_NAME;

import org.example.Team;
import org.example.TeamController;
import org.example.common.dto.RequestDto;

import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.usecase.DesignUseCase;
import org.example.planTeam.design.view.DesignTeamView;

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
        int selectInt = this.designTeamView.selectUseCase(DesignUseCase.class);
        DesignUseCase useCase = DesignUseCase.findByNumber(selectInt);
        RequestDto requestDto = useCase.viewAction(designTeamView);
        ResponseDto responseDto = useCase.teamAction(designInspectionTeam, requestDto);
        useCase.showResult(this.designTeamView, responseDto);
    }
}




