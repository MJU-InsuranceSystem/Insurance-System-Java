package org.example.planTeam.design.usecase;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.common.usecase.Usecase;
import org.example.planTeam.design.view.InsurancePlanView;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum ProducePlanUseCase implements Usecase {
    PLAN_INSURANCE(1, "상품을 기획한다.",
        InsurancePlanView::createProposal, Team::register,
        InsurancePlanView::completeCreateProposal),
    DESIGN_INSURANCE(2,
        "상품을 설계한다.", InsurancePlanView::designProduct, Team::process,
        InsurancePlanView::completeCreateProposal),
    APPLY_RATE_TEST(3,
        "상품 요율 분석을 요청한다.", InsurancePlanView::modifyProposal, Team::process,
        InsurancePlanView::completeCreateProposal),
    ASK_INSURANCE_AUTHORIZATION(4,
        "상품 인가를 요청한다.", InsurancePlanView::createProposal, Team::process,
        InsurancePlanView::completeCreateProposal),
    MANAGE_INSURANCE(5, "상품을 사후 관리하다.", InsurancePlanView::manageProposal,
        Team::process, InsurancePlanView::completeCreateProposal);
    private final int order;
    private final String description;

    private final Function<InsurancePlanView, RequestDto> action;
    private final BiFunction<Team, RequestDto, ResponseDto> teamAction;
    private final BiConsumer<InsurancePlanView, ResponseDto> showResult;


    ProducePlanUseCase(int order, String description,
        Function<InsurancePlanView, RequestDto> action,
        BiFunction<Team, RequestDto, ResponseDto> teamAction,
        BiConsumer<InsurancePlanView, ResponseDto> showResult) {
        this.order = order;
        this.description = description;
        this.action = action;
        this.teamAction = teamAction;
        this.showResult = showResult;
    }

    public String getDescription() {
        return description;
    }

    public int getOrder() {
        return order;
    }

    public RequestDto viewAction(InsurancePlanView insurancePlanView) {
        return action.apply(insurancePlanView);
    }

    public ResponseDto teamAction(Team team, RequestDto responseDto) {
        return teamAction.apply(team, responseDto);
    }

    public void showResult(InsurancePlanView team, ResponseDto responseDto) {
        this.showResult.accept(team, responseDto);
    }

    public static ProducePlanUseCase findByNumber(int selectNumber) {
        return Arrays.stream(ProducePlanUseCase.values())
            .filter(usecase -> usecase.getOrder() == selectNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
