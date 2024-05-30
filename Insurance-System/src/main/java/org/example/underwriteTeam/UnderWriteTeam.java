package org.example.underwriteTeam;

import org.example.InsuranceCompany;
import org.example.InsuranceCompanyList;
import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

/**
 * @author USER
 * @version 1.0
 */

public class UnderWriteTeam extends Team {

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
        return null;
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