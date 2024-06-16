package org.example.insurance.apply;

import org.example.insurance.Insurance;

/**
 * @author USER
 * @version 1.0
 */
public class InsuranceApplication {

    private int insuranceApplicationID;
    private String subscriberName;
    private String personalInfo;
    private String familyHistory;
    private String requestInsurance;
    private Insurance insurance;
    public int getInsuranceApplicationID() {
        return insuranceApplicationID;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public String getRequestInsurance() {
        return requestInsurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }
    public void setInsuranceApplicationID(int insuranceApplicationID) {
        this.insuranceApplicationID = insuranceApplicationID;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public void setRequestInsurance(String requestInsurance) {
        this.requestInsurance = requestInsurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "신청된 보험 정보" + '\n'+
            "신청 보험 ID : " + insuranceApplicationID + '\n'+
            "가입 신청자 이름 : " + subscriberName + '\n' +
            "개인 신상 정보 : " + personalInfo + '\n' +
            "가족력 : " + familyHistory + '\n' +
            "금융 상태 : " + requestInsurance + '\n' +
            "보험 종류 : " + insurance.getInsuranceType().getDescription() + '\n' +
            "======================================";
    }
}