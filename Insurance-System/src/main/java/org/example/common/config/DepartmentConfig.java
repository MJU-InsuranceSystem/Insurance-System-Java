package org.example.common.config;

import org.example.Team;
import org.example.TeamController;
import org.example.business.education.BusinessEducationTeam;
import org.example.business.education.controller.EducationController;
import org.example.business.education.model.EducationListImpl;
import org.example.business.education.view.EducationView;
import org.example.contract.ContractListImpl;
import org.example.contract.ContractManagementTeam;
import org.example.insurance.InsuranceApplyListImpl;
import org.example.insurance.InsuranceChargeCustomerApplyList;
import org.example.insurance.InsuranceChargeCustomerApplyListImpl;
import org.example.insurance.InsuranceCompanyList;
import org.example.planTeam.design.InsurancePlanTeam;
import org.example.planTeam.design.controller.InsurancePlanController;
import org.example.planTeam.design.model.designPlan.DesignPlanList;
import org.example.planTeam.design.model.designPlan.DesignPlanListImpl;
import org.example.planTeam.design.model.insurance.InsuranceList;
import org.example.planTeam.design.model.insurance.InsuranceListImpl;
import org.example.planTeam.design.model.proposal.ProposalList;
import org.example.planTeam.design.model.proposal.ProposalListImpl;
import org.example.planTeam.design.view.InsurancePlanView;
import org.example.planTeam.inspection.InsuranceInspectionTeam;
import org.example.planTeam.inspection.InsuranceInspectionView;
import org.example.rewardSupportTeam.RewardSupportTeam;
import org.example.rewardSupportTeam.controller.RewardSupportController;
import org.example.rewardSupportTeam.model.AccidentList;
import org.example.rewardSupportTeam.model.AccidentListImpl;
import org.example.rewardSupportTeam.model.litigationInfoList;
import org.example.rewardSupportTeam.model.litigationInfoListImpl;
import org.example.rewardSupportTeam.view.RewardSupportView;
import org.example.underwriteTeam.UnderwriteTeam;
import org.example.underwriteTeam.controller.UnderwriteController;
import org.example.underwriteTeam.model.UnderwritePolicyListImpl;
import org.example.underwriteTeam.view.UnderwriteView;

public class DepartmentConfig {

    public static EducationController educationController() {
        return new EducationController(educationView(), businessEducationTeam());
    }

    public static UnderwriteController underwriteController() {
        return new UnderwriteController(underwriteTeam(), underwriteView(),
                contractManagementTeam());
    }

    private static UnderwriteView underwriteView() {
        return new UnderwriteView();
    }

    private static UnderwriteTeam underwriteTeam() {
        return new UnderwriteTeam(new InsuranceCompanyList(), new InsuranceApplyListImpl(),
                new UnderwritePolicyListImpl());
    }

    private static ContractManagementTeam contractManagementTeam() {
        return new ContractManagementTeam(new ContractListImpl(), new InsuranceApplyListImpl());
    }

    private static EducationView educationView() {
        return new EducationView();
    }

    private static BusinessEducationTeam businessEducationTeam() {
        return new BusinessEducationTeam(new EducationListImpl());
    }

    public static TeamController designInspectionController() {
        return new InsurancePlanController(designTeamView(), insuranceInspectionTeamView(),
                designInspectionTeam(),
                insuranceInspectionTeam());
    }

    private static InsuranceInspectionView insuranceInspectionTeamView() {
        return new InsuranceInspectionView();
    }

    private static Team insuranceInspectionTeam() {
        return new InsuranceInspectionTeam();
    }

    private static InsurancePlanView designTeamView() {
        return new InsurancePlanView();
    }

    private static InsurancePlanTeam designInspectionTeam() {
        return new InsurancePlanTeam(designPlanList(), proposalList(), insuranceList(),
                authrizationInsuranceList());
    }

    private static DesignPlanList designPlanList() {
        return new DesignPlanListImpl();
    }

    private static ProposalList proposalList() {
        return new ProposalListImpl();
    }

    private static InsuranceList insuranceList() {
        return new InsuranceListImpl();
    }

    private static InsuranceList authrizationInsuranceList() {
        return new InsuranceListImpl();
    }

    // reward
    public static RewardSupportController rewardSupportController() {
        return new RewardSupportController(rewardSupportView(), rewardSupportTeam(), new InsuranceChargeCustomerApplyListImpl());
    }

    private static RewardSupportView rewardSupportView() {
        return new RewardSupportView();
    }

    private static RewardSupportTeam rewardSupportTeam() {
        return new RewardSupportTeam(accidentList(), litigationInfoList(), insuranceChargeCustomerApplyList());
    }

    private static AccidentList accidentList() {
        return new AccidentListImpl();
    }

    private static litigationInfoList litigationInfoList() {
        return new litigationInfoListImpl();
    }

    private static InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList() {
        return new InsuranceChargeCustomerApplyListImpl();
    }
}
