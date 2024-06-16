package org.example.team.workerManagement.usecase;

import org.example.common.usecase.Usecase;

import java.util.Arrays;

public enum WorkerManagementUsecase implements Usecase {
    ALL_WORKER_RETRIEVE(1, "모든 직원 조회")
    ;

    private final int order;
    private final String description;

    WorkerManagementUsecase(int order, String description) {
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

    public static WorkerManagementUsecase findByNumber(int selectNumber) {
        return Arrays.stream(WorkerManagementUsecase.values())
                .filter(usecase -> usecase.getOrder() == selectNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
