package org.example.common;

import org.example.TeamController;
import org.example.business.education.BusinessEducationTeam;
import org.example.business.education.controller.EducationController;
import org.example.business.education.view.EducationView;
import org.example.planTeam.design.DesignInspectionTeam;
import org.example.planTeam.design.controller.DesignInspectionController;
import org.example.planTeam.design.model.DesignPlanList;
import org.example.planTeam.design.model.DesignPlanListImpl;
import org.example.planTeam.design.model.ProposalList;
import org.example.planTeam.design.model.ProposalListImpl;
import org.example.planTeam.design.view.DesignTeamView;
import org.example.rewardSupportTeam.RewardSupportTeam;
import org.example.rewardSupportTeam.controller.RewardSupportController;
import org.example.rewardSupportTeam.model.AccidentList;
import org.example.rewardSupportTeam.model.AccidentListImpl;
import org.example.rewardSupportTeam.model.litigationInfoList;
import org.example.rewardSupportTeam.model.litigationInfoListImpl;
import org.example.rewardSupportTeam.view.RewardSupportView;
import org.example.underwriteTeam.UnderwriteTeam;
import org.example.underwriteTeam.view.UnderwriteView;
import org.example.underwriteTeam.controller.UnderwriteController;

public class DepartmentConfig {

    public static EducationController educationController() {
        return new EducationController(educationView(), businessEducationTeam());
    }

    public static UnderwriteController underwriteController() {
        return new UnderwriteController();
    }

    private static UnderwriteView underwriteView() {
        return new UnderwriteView();
    }

    private static UnderwriteTeam underwriteTeam() {
        return new UnderwriteTeam();
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
        return new DesignInspectionTeam(designPlanList(), proposalList());
    }

    private static DesignPlanList designPlanList() {
        return new DesignPlanListImpl();
    }

    private static ProposalList proposalList() {
        return new ProposalListImpl();
    }

    // reward
    public static RewardSupportController rewardSupportController() {
        return new RewardSupportController(rewardSupportView(), rewardSupportTeam());
    }

    private static RewardSupportView rewardSupportView() {
        return new RewardSupportView();
    }

    private static RewardSupportTeam rewardSupportTeam() {
        return new RewardSupportTeam(accidentList(), litigationInfoList());
    }

    private static AccidentList accidentList() {
        return new AccidentListImpl();
    }

    private static litigationInfoList litigationInfoList() {
        return new litigationInfoListImpl();
    }
}
