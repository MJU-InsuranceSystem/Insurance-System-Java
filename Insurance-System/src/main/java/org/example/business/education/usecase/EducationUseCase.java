package org.example.business.education.usecase;

import java.util.Arrays;
import org.example.common.Usecase;

public enum EducationUseCase implements Usecase {

    PREPARE_EDUCATION(1, "영업 교육을 준비한다."),
    MANAGE_EDUCATION(2, "영업 교육을 관리한다."),
    MANAGE_EDUCATION_STUDENT(3, "교육대상자/수료생을 관리한다.");

    private final int order;
    private final String description;

    EducationUseCase(int order, String description) {
        this.order = order;
        this.description = description;
    }

    public static EducationUseCase findByNumber(int selectNumber) {
        return Arrays.stream(EducationUseCase.values())
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
