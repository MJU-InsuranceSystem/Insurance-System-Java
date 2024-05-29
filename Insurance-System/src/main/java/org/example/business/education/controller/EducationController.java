package org.example.business.education.controller;

import org.example.TeamController;
import org.example.business.education.BusinessEducationTeam;
import org.example.business.education.usecase.EducationUseCase;
import org.example.business.education.view.EducationView;
import org.example.common.dto.RequestDto;

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
    int selectNumber = educationView.selectUsecase();
    EducationUseCase useCase = EducationUseCase.findByNumber(selectNumber);
    RequestDto requestDto = showUsecaseRequireInfo(useCase);
    businessEducationTeam.process(selectNumber, requestDto);
  }

  private RequestDto showUsecaseRequireInfo(EducationUseCase useCase) {
    switch (useCase) {
      case MANAGE_EDUCATION -> {
        return educationView.manageEducation();
      }
      case PREPARE_EDUCATION -> {
        return educationView.prepareEducation();
      }
      case MANAGE_EDUCATION_STUDENT -> {
        return educationView.manageEducationStudent();
      }
      default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
    }
  }
}
