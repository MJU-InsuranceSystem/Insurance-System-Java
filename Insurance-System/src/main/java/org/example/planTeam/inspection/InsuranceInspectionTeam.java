package org.example.planTeam.inspection;

import static org.example.planTeam.design.model.insurance.InsuranceConstant.INSURANCE_NAME;
import static org.example.planTeam.design.model.proposal.ProposalConstant.INSURANCE_KIND;
import static org.example.user.CustomerView.INSURANCE_ID;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.Status;
import org.example.planTeam.design.model.insurance.Insurance;

public class InsuranceInspectionTeam extends Team {

    @Override
    public ResponseDto manage(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto process(RequestDto request) {
        ResponseDto responseDto = new ResponseDto();

        if (request.get("인가응답").equalsIgnoreCase("Y")) {
            Insurance insurance = new Insurance();

            String[] element = request.get("값").split(" ");
            insurance.setInsuranceId(element[0]);
            insurance.setInsuranceName(element[1]);
            insurance.setInsuranceType(element[2]);
            insurance.setResponsiblePerson(element[3]);
            insurance.setReightObligation(element[4]);
            insurance.getReward().setMaxReward(Integer.parseInt(element[5]));
            insurance.getReward().setInsuranceRate(Integer.parseInt(element[6]));
            insurance.getReward().setMonthPaymentFee(Integer.parseInt(element[7]));
            insurance.getReward().setRestrictionRegulation((element[8]));
            insurance.setDate(request.get("날짜"));
            insurance.setAuthorizedPerson(request.get("책임자이름"));
            insurance.setReason(request.get("reason"));
            return responseDto;
        }
        request.getTotalInfo();
        responseDto.add(Status.key(), Status.SUCCESS.getStatus());
        return responseDto;
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
