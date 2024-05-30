package org.example.rewardSupportTeam;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.Status;
import org.example.rewardSupportTeam.model.Accident;
import org.example.rewardSupportTeam.model.AccidentList;
import org.example.rewardSupportTeam.model.ClaimInsurance;
import org.example.rewardSupportTeam.model.litigationInfoList;

import static org.example.rewardSupportTeam.view.RewardSupportView.*;

/**
 * @author USER
 * @version 1.0
 */
public class RewardSupportTeam extends Team {

    public AccidentList accidentList;
    public litigationInfoList litigationInfoList;


    public RewardSupportTeam(AccidentList accidentList, litigationInfoList litigationInfoList) {
        this.accidentList = accidentList;
        this.litigationInfoList = litigationInfoList;
    }

    public void finalize() throws Throwable {

    }


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
        Accident accident = new Accident();
        accident.setContent(request.get(ACCIDENT_CONTENT));
        accident.setCustomerName(request.get(ACCIDENT_NAME));

        ClaimInsurance claimInsurance = new ClaimInsurance();
        claimInsurance.setAccount(request.get(CLAIMINSURANCE_ACCOUNT));
        claimInsurance.setAddress(request.get(CLAIMINSURANCE_ADDRESS));
        claimInsurance.setPhoneNumber(request.get(CLAIMINSURANCE_PHONENUMBER));
        claimInsurance.setResidentNumber(request.get(CLAIMINSURANCE_RESIDENTNUMBER));
        claimInsurance.setSupportingFile(request.get(CLAIMINSURANCE_SUPPORTINGFILE));

        accident.setClaimInsurance(claimInsurance);
        accidentList.add(accident);

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