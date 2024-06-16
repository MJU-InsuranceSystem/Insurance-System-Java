package org.example.team.education.controller;

import java.util.Objects;
import org.example.team.TeamController;
import org.example.team.education.BusinessEducationTeam;
import org.example.team.education.usecase.EducationUseCase;
import org.example.team.education.view.EducationView;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;

public class EducationController implements TeamController {

  private final EducationView educationView;
  private final BusinessEducationTeam businessEducationTeam;

  public EducationController(EducationView educationView, BusinessEducationTeam businessEducationTeam) {
    this.educationView = educationView;
    this.businessEducationTeam = businessEducationTeam;
  }

  @Override
  public void process() {
    educationView.intro();
    int selectNumber = educationView.selectUsecase(EducationUseCase.class);
    EducationUseCase useCase = EducationUseCase.findByNumber(selectNumber);
    processUsecase(useCase);
  }

  private void processUsecase(EducationUseCase useCase) {
    switch (useCase) {
      case MANAGE_EDUCATION -> {
        RequestVO requestVO = educationView.manageEducation();
        if(Objects.equals(requestVO.get(EducationView.MANAGE_RESPONSE_RESULT), "Y")) {
          ResponseVO responseVO = businessEducationTeam.retrieve(requestVO);
          educationView.showAllEducationName(responseVO);
          return;
        }
        educationView.deny();
      }
      case PREPARE_EDUCATION -> {
        RequestVO requestVO = educationView.prepareEducation();
        ResponseVO responseVO = businessEducationTeam.register(requestVO);
        educationView.completeMessage(responseVO);
      }
      case MANAGE_EDUCATION_STUDENT -> {
        RequestVO requestVO = educationView.manageEducationStudent();
      }
      default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
    }
  }
}
