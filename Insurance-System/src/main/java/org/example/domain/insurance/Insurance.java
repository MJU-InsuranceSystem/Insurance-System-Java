package org.example.domain.insurance;

import org.example.insurance.InsuranceType;
import org.example.rewardSupportTeam.Reward;
/**
 * @author USER
 * @version 1.0
 */
public class Insurance {

    private int insuranceID;
    private String subscriberName;
    private int monthPaymentFee;
    private String restrictionRegulation;
    private Reward reward;
    private InsuranceType insuranceType;
    private String details;
    private String accountNumber;

    public String getDetails() {
        return details;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public int getMonthPaymentFee() {
        return monthPaymentFee;
    }

    public String getRestrictionRegulation() {
        return restrictionRegulation;
    }

    public org.example.rewardSupportTeam.Reward getReward() {
        return reward;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public void setMonthPaymentFee(int monthPaymentFee) {
        this.monthPaymentFee = monthPaymentFee;
    }

    public void setRestrictionRegulation(String restrictionRegulation) {
        this.restrictionRegulation = restrictionRegulation;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "insuranceID=" + insuranceID + "\n" +
            "insuranceType=" + insuranceType + "\n" +
            "subscriberName='" + subscriberName + "\n" +
            "accountNumber='" + accountNumber + "\n" +
            "monthPaymentFee=" + monthPaymentFee + "\n" +
            "details='" + details + "\n" +
            "restrictionRegulation='" + restrictionRegulation + "\n" +
            "reward=" + reward + "\n";
    }
}