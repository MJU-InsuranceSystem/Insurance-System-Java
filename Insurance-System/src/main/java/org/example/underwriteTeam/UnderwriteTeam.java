package org.example.underwriteTeam;

import java.util.Objects;
import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.domain.insurance.Insurance;
import org.example.insurance.InsuranceApplyList;
import org.example.insurance.InsuranceCompanyList;
import org.example.insurance.InsuranceList;
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
    private final InsuranceList insuranceApplyList;
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
        ResponseDto responseDto = new ResponseDto();
        Insurance insurance = insuranceApplyList.findFirst();
        if (Objects.equals(result, "N") && insurance != null) {
            insuranceApplyList.remove(insurance);
        }
        responseDto.add(UnderwriteView.UNDERWRITING_RESULT, result);
        if (insurance != null) {
            responseDto.add(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME, insurance.getSubscriberName());
            responseDto.add(UnderwriteView.FINISH_INSURANCE_ID, String.valueOf(insurance.getInsuranceID()));
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
        responseDto.add(Status.key(), Status.SUCCESS.getStatus());
        return responseDto;
    }

    @Override
    public ResponseDto remove(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto retrieve(RequestDto request) {
        int usecaseNumber = Integer.parseInt(request.get(UnderwriteView.USECASE_NUMBER));
        UnderwriteUsecase usecase = UnderwriteUsecase.findByNumber(usecaseNumber);
      if (usecase == UnderwriteUsecase.PERFORM_UNDERWRITING) {
        return findFirstInsurance();
      }
      throw new IllegalArgumentException("해당하는 유스케이스는 없습니다.");
    }

    private ResponseDto findFirstInsurance() {
        ResponseDto responseDto = new ResponseDto();
        Insurance insurance = insuranceApplyList.findFirst();
        if (insurance != null) {
            responseDto.add(UnderwriteView.FIRST_INSURANCE_APPLY, insurance.toString());
        }
        return responseDto;
    }
}