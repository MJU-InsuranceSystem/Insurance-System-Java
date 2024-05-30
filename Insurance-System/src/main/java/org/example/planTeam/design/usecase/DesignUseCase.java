package org.example.planTeam.design.usecase;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.example.Team;
import org.example.common.Usecase;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.view.DesignTeamView;

public enum DesignUseCase implements Usecase {
    PLAN_INSURANCE(1, "상품을 기획한다.",
        DesignTeamView::createProposal, Team::register, DesignTeamView::completeCreateProposal),
    DESIGN_INSURANCE(2,
        "상품을 설계한다.", DesignTeamView::manageProposal, Team::process,
        DesignTeamView::completeCreateProposal),
    APPLY_RATE_TEST(3,
        "상품 요율 분석을 요청한다.", DesignTeamView::modifyProposal, Team::process,
        DesignTeamView::completeCreateProposal),
    ASK_INSURANCE_AUTHORIZATION(4,
        "상품 인가를 요청한다.", DesignTeamView::createProposal, Team::process,
        DesignTeamView::completeCreateProposal),
    MANAGE_INSURANCE(5, "상품을 사후 관리하다.", DesignTeamView::manageProposal,
        Team::process, DesignTeamView::completeCreateProposal);
    private final int order;
    private final String description;

    private final Function<DesignTeamView, RequestDto> action;
    private final BiFunction<Team, RequestDto, ResponseDto> teamAction;
    private final BiConsumer<DesignTeamView, ResponseDto> showResult;


    DesignUseCase(int order, String description, Function<DesignTeamView, RequestDto> action,
        BiFunction<Team, RequestDto, ResponseDto> teamAction,
        BiConsumer<DesignTeamView, ResponseDto> showResult) {
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

    public RequestDto viewAction(DesignTeamView designTeamView) {
        return action.apply(designTeamView);
    }

    public ResponseDto teamAction(Team team, RequestDto responseDto) {
        return teamAction.apply(team, responseDto);
    }

    public void showResult(DesignTeamView team, ResponseDto responseDto) {
        this.showResult.accept(team, responseDto);
    }

    public static DesignUseCase findByNumber(int selectNumber) {
        return Arrays.stream(DesignUseCase.values())
            .filter(usecase -> usecase.getOrder() == selectNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
