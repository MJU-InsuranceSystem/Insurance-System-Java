package org.example.rewardSupportTeam.usecase;

import org.example.Team;
import org.example.common.usecase.Usecase;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.rewardSupportTeam.view.RewardSupportView;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum RewardSupportUseCase implements Usecase {

    SUBMIT_ACCIDENT(1, "사고 접수하기", RewardSupportView::submitAccident, Team::register, RewardSupportView::completeSubmitAccident),
    JUDGE_FAULT(2, "면/부책을 판단하기", RewardSupportView::judgeFault, Team::process, RewardSupportView::completeJudgeFault);
//    EXECUTE_LAWSUIT(3, "소송업무를 처리한다.");

    private final int order;
    private final String description;

    private final Function<RewardSupportView, RequestDto> viewAction;
    private final BiFunction<Team, RequestDto, ResponseDto> teamAction;
    private final BiConsumer<RewardSupportView, ResponseDto> showResult;


    RewardSupportUseCase(int order, String description, Function<RewardSupportView, RequestDto> viewAction, BiFunction<Team, RequestDto, ResponseDto> teamAction, BiConsumer<RewardSupportView, ResponseDto> showResult) {
        this.order = order;
        this.description = description;
        this.viewAction = viewAction;
        this.teamAction = teamAction;
        this.showResult = showResult;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public RequestDto viewAction(RewardSupportView rewardSupportView) {
        return viewAction.apply(rewardSupportView);
    }

    public ResponseDto teamAction(Team team, RequestDto responseDto) {
        return teamAction.apply(team, responseDto);
    }

    public void showResult(RewardSupportView rewardSupportView, ResponseDto responseDto) {
        this.showResult.accept(rewardSupportView, responseDto);
    }

    public static RewardSupportUseCase findByNumber(int selectNumber) {
        return Arrays.stream(RewardSupportUseCase.values())
                .filter(usecase -> usecase.getOrder() == selectNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
