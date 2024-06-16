package org.example.rewardSupportTeam.controller;

import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.insurance.InsuranceChargeCustomerApplyList;
import org.example.rewardSupportTeam.RewardSupportTeam;
import org.example.rewardSupportTeam.usecase.RewardSupportUseCase;
import org.example.rewardSupportTeam.view.RewardSupportView;

import static org.example.rewardSupportTeam.usecase.RewardSupportUseCase.JUDGE_FAULT;

public class RewardSupportController implements TeamController {
    private final RewardSupportView rewardSupportView;
    private final RewardSupportTeam rewardSupportTeam;


    public RewardSupportController(RewardSupportView rewardSupportView, RewardSupportTeam rewardSupportTeam, InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList) {
        this.rewardSupportView = rewardSupportView;
        this.rewardSupportTeam = rewardSupportTeam;
    }

    @Override
    public void process() {
        this.rewardSupportView.intro("보상 지원팀");
        int selectInt = this.rewardSupportView.selectUsecase(RewardSupportUseCase.class);
        RewardSupportUseCase usecase = RewardSupportUseCase.findByNumber(selectInt);
        executeUsecase(usecase);
    }

    private void executeUsecase(RewardSupportUseCase usecase) {
        switch (usecase) {
            case SUBMIT_ACCIDENT -> {
                RequestDto requestDto = rewardSupportView.submitAccident();
                ResponseDto responseDto = rewardSupportTeam.register(requestDto);
                rewardSupportView.completeSubmitAccident(responseDto);
            }
            case JUDGE_FAULT -> {
                RequestDto requestDto = rewardSupportView.judgeFault();
                ResponseDto responseDto = rewardSupportTeam.process(requestDto);
                rewardSupportView.completeJudgeFault(responseDto);
            }
            case PAY_INSURANCE -> {
                RequestDto requestDto = rewardSupportView.payInsurance();
                ResponseDto responseDto = rewardSupportTeam.retrieve(requestDto);
                rewardSupportView.completePayInsurance(responseDto);
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }
}

