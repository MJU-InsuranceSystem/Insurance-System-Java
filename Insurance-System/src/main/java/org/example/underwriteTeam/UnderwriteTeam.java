package org.example.underwriteTeam;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.insurance.InsuranceCompany;
import org.example.insurance.InsuranceCompanyList;
import org.example.underwriteTeam.model.UnderwritePolicy;
import org.example.underwriteTeam.model.UnderwritePolicyListImpl;

/**
 * @author USER
 * @version 1.0
 */

public class UnderwriteTeam extends Team {

    public InsuranceCompany m_InsuranceCompany;
    public InsuranceCompanyList m_InsuranceCompanyList;
    public UnderwritePolicy m_UnderwritePolicy;
    public UnderwritePolicyListImpl m_UnderwritePolicyListImpl;

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
//        int policyId = Integer.parseInt(request.get(UnderwriteView.POLICY_NUMBER));
//        String policyName = request.get(UnderwriteView.POLICY_NAME);
//        String content = request.get(UnderwriteView.POLICY_CONTENTS);
//        UnderwritePolicy underwritePolicy = UnderwritePolicy.create(policyId, policyName, content);
//
        ResponseDto responseDto = new ResponseDto();
//        responseDto.add(Status.key(), Status.SUCCESS.getStatus());
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