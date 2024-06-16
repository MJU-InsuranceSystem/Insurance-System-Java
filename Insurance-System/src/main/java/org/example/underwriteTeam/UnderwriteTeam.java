package org.example.underwriteTeam;

import java.util.List;
import java.util.Objects;
import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.domain.insurance.InsuranceApplication;
import org.example.insurance.InsuranceApplyList;
import org.example.insurance.InsuranceCompanyList;
import org.example.planTeam.Status;
import org.example.underwriteTeam.model.UnderwritePolicy;
import org.example.underwriteTeam.model.UnderwritePolicyListImpl;
import org.example.underwriteTeam.usecase.UnderwriteUsecase;
import org.example.underwriteTeam.view.UnderwriteView;

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
    public ResponseDto manage(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto process(RequestDto request) {
        String result = request.get(UnderwriteView.UNDERWRITING_RESULT);
        int applicationId = Integer.parseInt(request.get(UnderwriteView.SELECT_APPLICATION_ID));
        ResponseDto responseDto = new ResponseDto();
        InsuranceApplication insuranceApplication = insuranceApplyList.findById(applicationId);
        if (Objects.equals(result, "N") && insuranceApplication != null) {
            insuranceApplyList.remove(insuranceApplication);
        }
        responseDto.add(UnderwriteView.UNDERWRITING_RESULT, result);
        if (insuranceApplication != null) {
            responseDto.add(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME,
                insuranceApplication.getSubscriberName());
            responseDto.add(UnderwriteView.FINISH_INSURANCE_ID,
                String.valueOf(insuranceApplication.getInsuranceApplicationID()));
        }
        return responseDto;
    }

    @Override
    public ResponseDto register(RequestDto request) {
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

        ResponseDto responseDto = new ResponseDto();
        responseDto.add(Status.getKey(), Status.SUCCESS.getStatus());
        return responseDto;
    }

    @Override
    public ResponseDto remove(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto retrieve(RequestDto request) {
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

    private ResponseDto findById(String applicationId) {
        ResponseDto responseDto = new ResponseDto();
        InsuranceApplication insuranceApplication = insuranceApplyList.findById(Integer.parseInt(applicationId));
        responseDto.add(UnderwriteView.ONE_SELECT_INSURANCE, insuranceApplication.toString());
        return responseDto;
    }

    private ResponseDto findAllInsurance() {
        ResponseDto responseDto = new ResponseDto();
        List<InsuranceApplication> insuranceApplications = insuranceApplyList.findAll();
        if (!insuranceApplications.isEmpty()) {
            StringBuilder insuranceInfoBuilder = new StringBuilder();
            for(InsuranceApplication insuranceApplication : insuranceApplications){
                insuranceInfoBuilder.append("보험 ID : " + insuranceApplication.getInsuranceApplicationID()).append('\n');
            }
            responseDto.add(UnderwriteView.ALL_INSURANCE_APPLY, insuranceInfoBuilder.toString());
        }
        return responseDto;
    }
}