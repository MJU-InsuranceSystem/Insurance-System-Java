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
    int selectNumber = underwriteView.selectUsecase(UnderwriteUsecase.class);
    UnderwriteUsecase usecase = UnderwriteUsecase.findByNumber(selectNumber);
    RequestDto requestDto = usecase.viewAction(underwriteView);
    ResponseDto responseDto = usecase.teamAction(underwriteTeam, requestDto);
    usecase.showResult(underwriteView, responseDto);
  }
}
