package org.example.underwriteTeam;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.insurance.InsuranceCompanyList;
import org.example.planTeam.Status;
import org.example.underwriteTeam.model.UnderwritePolicy;
import org.example.underwriteTeam.model.UnderwritePolicyListImpl;
import org.example.underwriteTeam.view.UnderwriteView;

/**
 * @author USER
 * @version 1.0
 */

public class UnderwriteTeam extends Team {

    public InsuranceCompanyList insuranceCompanyList;
    public UnderwritePolicyListImpl underwritePolicyListImpl;

    @Override
    public ResponseDto manage(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto process(RequestDto request) {
        return null;
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
        return null;
    }
}