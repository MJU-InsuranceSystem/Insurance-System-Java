package org.example.common;

import org.example.business.education.BusinessEducationTeam;
import org.example.business.education.controller.EducationController;
import org.example.business.education.view.EducationView;

public class DepartmentConfig {

  public static EducationController educationController() {
    return new EducationController(educationView(), businessEducationTeam());
  }

  private static  EducationView educationView() {
    return new EducationView();
  }

  private static BusinessEducationTeam businessEducationTeam() {
    return new BusinessEducationTeam();
  }

}
