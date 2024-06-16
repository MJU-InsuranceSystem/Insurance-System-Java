package org.example.business.education.controller;

import java.util.Objects;
import org.example.TeamController;
import org.example.business.education.BusinessEducationTeam;
import org.example.business.education.usecase.EducationUseCase;
import org.example.business.education.view.EducationView;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

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
        RequestDto requestDto = educationView.manageEducation();
        if(Objects.equals(requestDto.get(EducationView.MANAGE_RESPONSE_RESULT), "Y")) {
          ResponseDto responseDto = businessEducationTeam.retrieve(requestDto);
          educationView.showAllEducationName(responseDto);
          return;
        }
        educationView.deny();
      }
      case PREPARE_EDUCATION -> {
        RequestDto requestDto = educationView.prepareEducation();
        ResponseDto responseDto = businessEducationTeam.register(requestDto);
        educationView.completeMessage(responseDto);
      }
      case MANAGE_EDUCATION_STUDENT -> {
        RequestDto requestDto = educationView.manageEducationStudent();
      }
      default -> throw new IllegalArgumentException("해당 유스케이스 번호는 존재하지 않습니다.");
    }
  }
}
