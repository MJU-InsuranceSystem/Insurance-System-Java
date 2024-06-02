package org.example.domain.insurance;

import org.example.insurance.InsuranceType;
/**
 * @author USER
 * @version 1.0
 */
public class InsuranceApplication {

    private int insuranceApplicationID;
    private String subscriberName;
    private int monthPaymentFee;
    private InsuranceType insuranceType;
    private String details;
    private String accountNumber;

    public String getDetails() {
        return details;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getInsuranceApplicationID() {
        return insuranceApplicationID;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public int getMonthPaymentFee() {
        return monthPaymentFee;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceApplicationID(int insuranceApplicationID) {
        this.insuranceApplicationID = insuranceApplicationID;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public void setMonthPaymentFee(int monthPaymentFee) {
        this.monthPaymentFee = monthPaymentFee;
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
        return "insuranceID=" + insuranceApplicationID + "\n" +
            "insuranceType=" + insuranceType + "\n" +
            "subscriberName='" + subscriberName + "\n" +
            "accountNumber='" + accountNumber + "\n" +
            "monthPaymentFee=" + monthPaymentFee + "\n" +
            "details='" + details + "\n";
    }
}