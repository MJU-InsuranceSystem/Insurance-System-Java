package org.example.planTeam.design.usecase;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.example.Team;
import org.example.common.Usecase;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.DesignInspectionTeam;
import org.example.planTeam.design.view.DesignTeamView;

public enum DesignUseCase implements Usecase {
    PLAN_INSURANCE(1, "상품을 기획한다.",
        DesignTeamView::manageProposal, (designInspectionTeam, requestDto) -> {
        return designInspectionTeam.manage(requestDto);
    }),
    DESIGN_INSURANCE(2,
        "상품을 설계한다.", DesignTeamView::manageProposal, (designInspectionTeam, requestDto) -> {
        return designInspectionTeam.process(requestDto);
    }),
    APPLY_RATE_TEST(3,
        "상품 요율 분석을 요청한다.", DesignTeamView::modifyProposal, (designInspectionTeam, requestDto) -> {
        return designInspectionTeam.process(requestDto);
    }),
    ASK_INSURANCE_AUTHORIZATION(4,
        "상품 인가를 요청한다.", DesignTeamView::createProposal, (designInspectionTeam, requestDto) -> {
        return designInspectionTeam.process(requestDto);
    }),
    MANAGE_INSURANCE(5, "상품을 사후 관리하다.", DesignTeamView::manageProposal,
        (designInspectionTeam, requestDto) -> {
            return designInspectionTeam.process(requestDto);
        });
    private final int order;
    private final String description;

    private Function<DesignTeamView, RequestDto> action;
    private BiFunction<Team, RequestDto, ResponseDto> teamAction;

    DesignUseCase(int order, String description, Function<DesignTeamView, RequestDto> action,
        BiFunction<Team, RequestDto, ResponseDto> teamAction) {
        this.order = order;
        this.description = description;
        this.action = action;
        this.teamAction = teamAction;
    }

    public String getDescription() {
        return description;
    }

    public int getOrder() {
        return order;
    }

    public RequestDto execute(DesignTeamView designTeamView) {
        return action.apply(designTeamView);
    }

    public ResponseDto teamAction(Team team, RequestDto responseDto) {
        return teamAction.apply(team, responseDto);
    }

    public static DesignUseCase findByNumber(int selectNumber) {
        return Arrays.stream(DesignUseCase.values())
            .filter(usecase -> usecase.getOrder() == selectNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
