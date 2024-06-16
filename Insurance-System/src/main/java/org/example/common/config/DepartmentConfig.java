package org.example.common.config;

import org.example.insurance.InsuranceList;
import org.example.insurance.InsuranceListImpl;
import org.example.insurance.apply.InsuranceApplyListImpl;
import org.example.insurance.apply.InsuranceChargeCustomerApplyList;
import org.example.insurance.apply.InsuranceChargeCustomerApplyListImpl;
import org.example.insurance.company.InsuranceCompanyList;
import org.example.team.Team;
import org.example.team.TeamController;
import org.example.team.contract.ContractListImpl;
import org.example.team.contract.ContractManagementController;
import org.example.team.contract.ContractManagementTeam;
import org.example.team.contract.ContractManagementView;
import org.example.team.customerManagement.CustomerManageTeam;
import org.example.team.customerManagement.controller.CustomerManagementController;
import org.example.team.customerManagement.view.CustomerManagementView;
import org.example.team.education.BusinessEducationTeam;
import org.example.team.education.controller.EducationController;
import org.example.team.education.model.EducationListImpl;
import org.example.team.education.view.EducationView;
import org.example.team.plan.design.InsurancePlanTeam;
import org.example.team.plan.design.controller.InsurancePlanController;
import org.example.team.plan.design.model.designPlan.DesignPlanList;
import org.example.team.plan.design.model.designPlan.DesignPlanListImpl;
import org.example.team.plan.design.model.proposal.ProposalList;
import org.example.team.plan.design.model.proposal.ProposalListImpl;
import org.example.team.plan.design.view.InsurancePlanView;
import org.example.team.plan.inspection.InsuranceInspectionTeam;
import org.example.team.plan.inspection.InsuranceInspectionView;
import org.example.team.rewardSupport.RewardSupportTeam;
import org.example.team.rewardSupport.controller.RewardSupportController;
import org.example.team.rewardSupport.model.AccidentList;
import org.example.team.rewardSupport.model.AccidentListImpl;
import org.example.team.rewardSupport.model.InsurancePremiumPaymentCustomerList;
import org.example.team.rewardSupport.model.InsurancePremiumPaymentCustomerListImpl;
import org.example.team.rewardSupport.model.litigationInfoList;
import org.example.team.rewardSupport.model.litigationInfoListImpl;
import org.example.team.rewardSupport.view.RewardSupportView;
import org.example.team.underwrite.UnderwriteTeam;
import org.example.team.underwrite.controller.UnderwriteController;
import org.example.team.underwrite.model.UnderwritePolicyListImpl;
import org.example.team.underwrite.view.UnderwriteView;
import org.example.team.workerManagement.WorkerManagementTeam;
import org.example.team.workerManagement.controller.WorkerManagementController;
import org.example.team.workerManagement.view.WorkerManagementView;

public class DepartmentConfig {

    public static EducationController educationController() {
        return new EducationController(educationView(), businessEducationTeam());
    }

    public static UnderwriteController underwriteController() {
        return new UnderwriteController(underwriteTeam(), underwriteView(),
                contractManagementTeam());
    }

    public static CustomerManagementController customerManagementController() {
        return new CustomerManagementController(customerManageTeam(), customerManagementView());
    }

    public static CustomerManageTeam customerManageTeam() {
        return new CustomerManageTeam();
    }

    public static CustomerManagementView customerManagementView() {
        return new CustomerManagementView();
    }

    public static WorkerManagementController workerManagementController() {
        return new WorkerManagementController(workerManagementTeam(), workerManagementView());
    }

    public static WorkerManagementTeam workerManagementTeam() {
        return new WorkerManagementTeam();
    }

    public static WorkerManagementView workerManagementView() {
        return new WorkerManagementView();
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
        return new RewardSupportTeam(accidentList(), litigationInfoList(), insuranceChargeCustomerApplyList(), insurancePremiumPaymentCustomerList());
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

    private static InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList() {
        return new InsurancePremiumPaymentCustomerListImpl();
    }

    public static ContractManagementController contractManagementController() {
        return new ContractManagementController(contractManagementView(), contractManagementTeam());
    }

    public static ContractManagementView contractManagementView() {
        return new ContractManagementView();
    }
}
