package org.example.contract;

import org.example.common.usecase.Usecase;
import org.example.underwriteTeam.usecase.UnderwriteUsecase;

import java.util.Arrays;

public enum ContractManagementUsecase implements Usecase {

    ALL_CONTRACT_RETRIEVE(1, "모든 계약 조회"),
    CONTRACT_DELETE(2, "계약 삭제"),
    CHECK_INSURANCE_ACCOUNT(3, "보험급 납부 확인");

    private final int order;
    private final String description;

    ContractManagementUsecase(int order, String description) {
        this.order = order;
        this.description = description;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static ContractManagementUsecase findByNumber(int selectNumber) {
        return Arrays.stream(ContractManagementUsecase.values())
                .filter(usecase -> usecase.getOrder() == selectNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
