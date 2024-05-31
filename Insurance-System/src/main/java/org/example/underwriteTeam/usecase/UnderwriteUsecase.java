package org.example.underwriteTeam.usecase;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.common.usecase.Usecase;
import org.example.underwriteTeam.view.UnderwriteView;

public enum UnderwriteUsecase implements Usecase {
  ESTABLISH_UNDERWRITING_POLICY(1, "인수 정책을 수립하다.",
      UnderwriteView::createPolicy, Team::register, UnderwriteView::complete),
  PERFORM_UNDERWRITING(2, "인수를 심사하다.",
      UnderwriteView::performUnderwriting, Team::process, UnderwriteView::complete),
  REQUIRE_CO_UNDERWRITING(3, "공동 인수를 요청하다",
      UnderwriteView::requireCoUnderwriting, Team::register, UnderwriteView::complete);

  private final int order;
  private final String description;

  private final Function<UnderwriteView, RequestDto> action;
  private final BiFunction<Team, RequestDto, ResponseDto> teamAction;
  private final BiConsumer<UnderwriteView, ResponseDto> showResult;


  UnderwriteUsecase(int order, String description, Function<UnderwriteView, RequestDto> action,
      BiFunction<Team, RequestDto, ResponseDto> teamAction,
      BiConsumer<UnderwriteView, ResponseDto> showResult) {
    this.order = order;
    this.description = description;
    this.action = action;
    this.teamAction = teamAction;
    this.showResult = showResult;
  }

  @Override
  public int getOrder() {
    return 0;
  }

  @Override
  public String getDescription() {
    return null;
  }

  public RequestDto viewAction(UnderwriteView underwriteView) {
    return action.apply(underwriteView);
  }

  public ResponseDto teamAction(Team team, RequestDto responseDto) {
    return teamAction.apply(team, responseDto);
  }

  public void showResult(UnderwriteView view, ResponseDto responseDto) {
    this.showResult.accept(view, responseDto);
  }

  public static UnderwriteUsecase findByNumber(int selectNumber) {
    return Arrays.stream(UnderwriteUsecase.values())
        .filter(usecase -> usecase.getOrder() == selectNumber)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
  }
}
