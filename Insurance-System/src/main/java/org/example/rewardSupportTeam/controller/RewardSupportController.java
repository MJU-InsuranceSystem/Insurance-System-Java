package org.example.rewardSupportTeam.controller;

import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.rewardSupportTeam.RewardSupportTeam;
import org.example.rewardSupportTeam.usecase.RewardSupportUseCase;
import org.example.rewardSupportTeam.view.RewardSupportView;

public class RewardSupportController implements TeamController {
    private final RewardSupportView rewardSupportView;
    private final RewardSupportTeam rewardSupportTeam;

    public RewardSupportController(RewardSupportView rewardSupportView, RewardSupportTeam rewardSupportTeam) {
        this.rewardSupportView = rewardSupportView;
        this.rewardSupportTeam = rewardSupportTeam;

    }

    @Override
    public void process() {
        int selectInt = this.rewardSupportView.selectUsecase(RewardSupportUseCase.class);
        RewardSupportUseCase usecase = RewardSupportUseCase.findByNumber(selectInt);
        RequestDto requestDto = usecase.viewAction(rewardSupportView);
        ResponseDto responseDto = usecase.teamAction(rewardSupportTeam, requestDto);
        usecase.showResult(rewardSupportView, responseDto);
    }
}
