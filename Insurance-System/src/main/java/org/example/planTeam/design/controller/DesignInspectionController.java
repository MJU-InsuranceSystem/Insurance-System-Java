package org.example.planTeam.design.controller;


import org.example.Team;
import org.example.TeamController;
import org.example.common.dto.RequestDto;

import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.usecase.DesignUseCase;
import org.example.planTeam.design.view.DesignTeamView;

public class DesignInspectionController implements TeamController {


    private boolean status;

    private final DesignTeamView designTeamView;

    private final Team designInspectionTeam;

    public DesignInspectionController(DesignTeamView designTeamView, Team designInspectionTeam) {
        this.designTeamView = designTeamView;
        this.designInspectionTeam = designInspectionTeam;
    }


    @Override
    public void process() {
        status = true;
        while (status) {
            this.designTeamView.intro();
            int selectInt = this.designTeamView.selectUsecase(DesignUseCase.class);
            DesignUseCase useCase = DesignUseCase.findByNumber(selectInt);
            RequestDto requestDto = useCase.execute(designTeamView);
            ResponseDto responseDto = useCase.teamAction(designInspectionTeam, requestDto);
        }
    }

}


