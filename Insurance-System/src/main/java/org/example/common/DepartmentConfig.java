package org.example.common;

import org.example.TeamController;
import org.example.business.education.BusinessEducationTeam;
import org.example.business.education.controller.EducationController;
import org.example.business.education.view.EducationView;
import org.example.planTeam.design.DesignInspectionTeam;
import org.example.planTeam.design.controller.DesignInspectionController;
import org.example.planTeam.design.view.DesignTeamView;

public class DepartmentConfig {

    public static EducationController educationController() {
        return new EducationController(educationView(), businessEducationTeam());
    }

    private static EducationView educationView() {
        return new EducationView();
    }

    private static BusinessEducationTeam businessEducationTeam() {
        return new BusinessEducationTeam();
    }

    public static TeamController designInspectionController() {
        return new DesignInspectionController(designTeamView(), designInspectionTeam());

    }

    private static DesignTeamView designTeamView() {
        return new DesignTeamView();
    }

    private static DesignInspectionTeam designInspectionTeam() {
        return new DesignInspectionTeam();
    }

}
