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
        this.rewardSupportView.intro("보상 지원팀");
        int selectInt = this.rewardSupportView.selectUsecase(RewardSupportUseCase.class);
        RewardSupportUseCase usecase = RewardSupportUseCase.findByNumber(selectInt);
        RequestDto requestDto = requireInputInfo(usecase);
        ResponseDto responseDto = teamAction(usecase, requestDto);
        showResult(usecase, responseDto);
    }

    private RequestDto requireInputInfo(RewardSupportUseCase usecase) {
        switch (usecase) {
            case SUBMIT_ACCIDENT -> {
                return rewardSupportView.submitAccident();
            }
            case JUDGE_FAULT -> {
                return rewardSupportView.judgeFault();
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }

    private ResponseDto teamAction(RewardSupportUseCase usecase, RequestDto requestDto) {
        switch (usecase) {
            case SUBMIT_ACCIDENT -> {
                return rewardSupportTeam.register(requestDto);
            }
            case JUDGE_FAULT -> {
                return rewardSupportTeam.process(requestDto);
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }

    private void showResult(RewardSupportUseCase usecase, ResponseDto responseDto) {
        switch (usecase) {
            case SUBMIT_ACCIDENT -> {
                rewardSupportView.completeSubmitAccident(responseDto);
            }
            case JUDGE_FAULT -> {
                rewardSupportView.completeJudgeFault(responseDto);
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }
}
