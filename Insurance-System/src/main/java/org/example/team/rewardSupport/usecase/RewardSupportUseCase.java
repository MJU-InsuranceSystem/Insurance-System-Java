package org.example.team.rewardSupport.usecase;

import org.example.common.usecase.Usecase;

import java.util.Arrays;

public enum RewardSupportUseCase implements Usecase {

    JUDGE_FAULT(1, "면/부책을 판단하기"),
    PAY_INSURANCE(2, "보험금 지급하기"),
    CHECK_NOT_PAID_CUSTOMER(3, "보험료 미납 고객 확인"),
    MANAGE_LAWSUIT(4, "소송업무 처리하기")
    ;
//    EXECUTE_LAWSUIT(4, "소송업무를 처리한다.");

    private final int order;
    private final String description;


    RewardSupportUseCase(int order, String description) {
        this.order = order;
        this.description = description;

    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public static RewardSupportUseCase findByNumber(int selectNumber) {
        return Arrays.stream(RewardSupportUseCase.values())
                .filter(usecase -> usecase.getOrder() == selectNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    };
}
