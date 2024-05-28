package org.example.rewardSupportTeam;

import org.example.Team;
import org.example.business.design.controller.dto.Request;
import org.example.business.design.controller.dto.Response;
import org.example.business.design.view.DesignInspectionController;

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
    public void manage() {

    }

    @Override
    public Response process(DesignInspectionController.Function function, Request request) {
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

    @Override
    public void register() {

    }

    @Override
    public void remove() {

    }

    @Override
    public Object retrieve() {
        return null;
    }
}