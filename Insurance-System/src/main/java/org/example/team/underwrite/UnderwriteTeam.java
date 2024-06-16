package org.example.team.underwrite;

import java.util.List;
import java.util.Objects;
import org.example.team.Team;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
import org.example.insurance.apply.InsuranceApplication;
import org.example.insurance.apply.InsuranceApplyList;
import org.example.insurance.company.InsuranceCompanyList;
import org.example.team.plan.Status;
import org.example.team.underwrite.model.UnderwritePolicy;
import org.example.team.underwrite.model.UnderwritePolicyListImpl;
import org.example.team.underwrite.usecase.UnderwriteUsecase;
import org.example.team.underwrite.view.UnderwriteView;

/**
 * @author USER
 * @version 1.0
 */

public class UnderwriteTeam extends Team {

    private final InsuranceCompanyList insuranceCompanyList;
    private final InsuranceApplyList insuranceApplyList;
    private final UnderwritePolicyListImpl underwritePolicyListImpl;

    public UnderwriteTeam(InsuranceCompanyList insuranceCompanyList,
        InsuranceApplyList insuranceApplyList, UnderwritePolicyListImpl underwritePolicyListImpl) {
        this.insuranceCompanyList = insuranceCompanyList;
        this.insuranceApplyList = insuranceApplyList;
        this.underwritePolicyListImpl = underwritePolicyListImpl;
    }

    @Override
    public ResponseVO manage(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO process(RequestVO request) {
        String result = request.get(UnderwriteView.UNDERWRITING_RESULT);
        int applicationId = Integer.parseInt(request.get(UnderwriteView.SELECT_APPLICATION_ID));
        ResponseVO responseVO = new ResponseVO();
        InsuranceApplication insuranceApplication = insuranceApplyList.findById(applicationId);
        if (Objects.equals(result, "N") && insuranceApplication != null) {
            insuranceApplyList.remove(insuranceApplication);
        }
        responseVO.add(UnderwriteView.UNDERWRITING_RESULT, result);
        if (insuranceApplication != null) {
            responseVO.add(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME,
                insuranceApplication.getSubscriberName());
            responseVO.add(UnderwriteView.FINISH_INSURANCE_ID,
                String.valueOf(insuranceApplication.getInsuranceApplicationID()));
        }
        return responseVO;
    }

    @Override
    public ResponseVO register(RequestVO request) {
        UnderwritePolicy underwritePolicy = new UnderwritePolicy();
        int policyId = Integer.parseInt(request.get(UnderwriteView.POLICY_NUMBER));
        String policyName = request.get(UnderwriteView.POLICY_NAME);
        String risk = request.get(UnderwriteView.POLICY_RISK);
        String premium = request.get(UnderwriteView.POLICY_PREMIUM);
        String subscription = request.get(UnderwriteView.POLICY_SUBSCRIPTION);
        underwritePolicy.setPolicyId(policyId);
        underwritePolicy.setPolicyName(policyName);
        underwritePolicy.setPolicyName(policyName);
        underwritePolicy.setRiskInfo(risk);
        underwritePolicy.setPremiumInfo(premium);
        underwritePolicy.setSubscriptionInfo(subscription);
        underwritePolicyListImpl.add(underwritePolicy);

        ResponseVO responseVO = new ResponseVO();
        responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
        return responseVO;
    }

    @Override
    public ResponseVO remove(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO retrieve(RequestVO request) {
        String applicationId = request.get(UnderwriteView.SELECT_APPLICATION_ID);
        if (applicationId != null) {
            return findById(applicationId);
        }

        int usecaseNumber = Integer.parseInt(request.get(UnderwriteView.USECASE_NUMBER));
        UnderwriteUsecase usecase = UnderwriteUsecase.findByNumber(usecaseNumber);
        if (usecase == UnderwriteUsecase.PERFORM_UNDERWRITING) {
            return findAllInsurance();
        }
        throw new IllegalArgumentException("해당하는 유스케이스는 없습니다.");
    }

    private ResponseVO findById(String applicationId) {
        ResponseVO responseVO = new ResponseVO();
        InsuranceApplication insuranceApplication = insuranceApplyList.findById(Integer.parseInt(applicationId));
        responseVO.add(UnderwriteView.ONE_SELECT_INSURANCE, insuranceApplication.toString());
        return responseVO;
    }

    private ResponseVO findAllInsurance() {
        ResponseVO responseVO = new ResponseVO();
        List<InsuranceApplication> insuranceApplications = insuranceApplyList.findAll();
        if (!insuranceApplications.isEmpty()) {
            StringBuilder insuranceInfoBuilder = new StringBuilder();
            for(InsuranceApplication insuranceApplication : insuranceApplications){
                insuranceInfoBuilder.append("보험 ID : " + insuranceApplication.getInsuranceApplicationID()).append('\n');
            }
            responseVO.add(UnderwriteView.ALL_INSURANCE_APPLY, insuranceInfoBuilder.toString());
        }
        return responseVO;
    }
}