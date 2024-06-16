package org.example.rewardSupportTeam.controller;

import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.insurance.InsuranceChargeCustomerApplyList;
import org.example.rewardSupportTeam.RewardSupportTeam;
import org.example.rewardSupportTeam.model.Accident;
import org.example.rewardSupportTeam.usecase.RewardSupportUseCase;
import org.example.rewardSupportTeam.view.RewardSupportView;

import java.util.List;

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
            case JUDGE_FAULT -> {
                RequestDto tempRequest = new RequestDto();
                ResponseDto tempResponseDto = rewardSupportTeam.retrieve(tempRequest);
                RequestDto requestDto = rewardSupportView.judgeFault(tempResponseDto);
                ResponseDto responseDto = rewardSupportTeam.process(requestDto);
                rewardSupportView.completeJudgeFault(responseDto);
            }
            case PAY_INSURANCE -> {
                RequestDto requestDto = rewardSupportView.payInsurance();
                ResponseDto responseDto = rewardSupportTeam.retrieve(requestDto);
                rewardSupportView.completePayInsurance(responseDto);
            }
            case MANAGE_LAWSUIT -> {
                RequestDto requestDto = rewardSupportView.manageLawsuit();

            }
            case CHECK_NOT_PAID_CUSTOMER -> {
                ResponseDto responseDto = rewardSupportTeam.getNotPaidCustomer();
                rewardSupportView.showNotPaidCustomer(responseDto);
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }
}

