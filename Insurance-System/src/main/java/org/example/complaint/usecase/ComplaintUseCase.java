package org.example.complaint.usecase;


import org.example.common.usecase.Usecase;

import java.util.Arrays;

public enum ComplaintUseCase implements Usecase {
    REGISTER_COMPLAINT(1, "민원을 신청한다."),
    REQUEST_PROCESSING_STATUS(2, "민원 처리 현황을 요청한다."),
    EVALUATE_COMPLAINT(3, "민원을 평가한다.");

    private final int order;
    private final String description;

    ComplaintUseCase(int order, String description) {
        this.order = order;
        this.description = description;
    }

    public static ComplaintUseCase findByNumber(int selectNumber) {
        return Arrays.stream(ComplaintUseCase.values())
                .filter(usecase -> usecase.getOrder() == selectNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }

    public String getDescription() {
        return description;
    }

    public int getOrder() {
        return order;
    }
}
