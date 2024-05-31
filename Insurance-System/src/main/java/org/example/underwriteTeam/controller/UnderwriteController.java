package org.example.underwriteTeam.controller;

import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.underwriteTeam.UnderwriteTeam;
import org.example.underwriteTeam.usecase.UnderwriteUsecase;
import org.example.underwriteTeam.view.UnderwriteView;

public class UnderwriteController implements TeamController {

  private final UnderwriteTeam underwriteTeam;
  private final UnderwriteView underwriteView;

  public UnderwriteController(UnderwriteTeam underwriteTeam, UnderwriteView underwriteView) {
    this.underwriteTeam = underwriteTeam;
    this.underwriteView = underwriteView;
  }

  @Override
  public void process() {
    underwriteView.intro("U/W 팀");
    int selectNumber = underwriteView.selectUsecase(UnderwriteUsecase.class);
    UnderwriteUsecase usecase = UnderwriteUsecase.findByNumber(selectNumber);
    RequestDto requestDto = requireInputInfo(usecase);
    ResponseDto responseDto = teamAction(usecase, requestDto);
    showResult(usecase, responseDto);
  }

  private RequestDto requireInputInfo(UnderwriteUsecase usecase) {
    switch (usecase) {
      case ESTABLISH_UNDERWRITING_POLICY -> {
        return underwriteView.createPolicy();
      }
      case PERFORM_UNDERWRITING -> {
        return underwriteView.performUnderwriting();
      }
      case REQUIRE_CO_UNDERWRITING -> {
        return underwriteView.requireCoUnderwriting();
      }
      default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
    }
  }

  private ResponseDto teamAction(UnderwriteUsecase usecase, RequestDto requestDto) {
    switch (usecase) {
      case ESTABLISH_UNDERWRITING_POLICY -> {
        return underwriteTeam.register(requestDto);
      }
      case PERFORM_UNDERWRITING -> {
        return underwriteTeam.process(requestDto);
      }
      case REQUIRE_CO_UNDERWRITING -> {
        return underwriteTeam.retrieve(requestDto);
      }
      default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
    }
  }

  private void showResult(UnderwriteUsecase usecase, ResponseDto responseDto) {
    switch (usecase) {
      case ESTABLISH_UNDERWRITING_POLICY -> {
        underwriteView.showCreatePolicyResult(responseDto);
      }
      case PERFORM_UNDERWRITING -> {
        underwriteView.showPerformUnderwritingResult(responseDto);
      }
      case REQUIRE_CO_UNDERWRITING -> {
        underwriteView.showRequireCoUnderwritingResult(responseDto);
      }
      default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
    }
  }
}
