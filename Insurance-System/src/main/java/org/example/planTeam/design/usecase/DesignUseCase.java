package org.example.planTeam.design.usecase;

import org.example.Team;
import org.example.common.usecase.Usecase;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.view.DesignTeamView;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum DesignUseCase implements Usecase {
    PLAN_INSURANCE(1, "상품을 기획한다."),
    DESIGN_INSURANCE(2, "상품을 설계한다."),
    CREATE_INSURANCE(3, "보험 상품을 만들다."),
    ASK_INSURANCE_AUTHORIZATION(4, "상품 인가를 요청한다."),
    MANAGE_INSURANCE(5, "상품을 사후 관리하다.");
    private final int order;
    private final String description;


    DesignUseCase(int order, String description) {
        this.order = order;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getOrder() {
        return order;
    }

    public static DesignUseCase findByNumber(int selectNumber) {
        return Arrays.stream(DesignUseCase.values())
            .filter(usecase -> usecase.getOrder() == selectNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
