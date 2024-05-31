package org.example.rewardSupportTeam;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

/**
 * @author USER
 * @version 1.0
 */
public class RewardSupportTeam extends Team {

    public Accident accident;
    public litigationInfo litigationInfo;
    public AccidentListImpl accidentListImpl;
    public litigationInfoListImpl litigationInfoListImpl;

    public RewardSupportTeam(Accident accident, litigationInfo litigationInfo, AccidentListImpl accidentListImpl, litigationInfoListImpl litigationInfoListImpl) {
        this.accident = accident;
        this.litigationInfo = litigationInfo;
        this.accidentListImpl = accidentListImpl;
        this.litigationInfoListImpl = litigationInfoListImpl;
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


//    @Override
//    public void process(int processNum, int domainId) {
//        switch (processNum) {
//            case 1:
//
//                Accident nowAccident = accidentListImpl.read(domainId);
//
//                break;
//            case 2:
//
//                break;
//            default:
//                break;
//        }
//    }
}