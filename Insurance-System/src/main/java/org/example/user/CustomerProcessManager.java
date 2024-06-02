package org.example.user;

import org.example.common.AuthUtil;
import org.example.common.dto.RequestDto;
import org.example.contract.ContractList;
import org.example.domain.insurance.InsuranceApplication;
import org.example.insurance.InsuranceApplyList;
import org.example.insurance.InsuranceType;

public class CustomerProcessManager {

    private final InsuranceApplyList insuranceApplyList;

    public CustomerProcessManager(InsuranceApplyList insuranceApplyList) {
        this.insuranceApplyList = insuranceApplyList;
    }

    public ContractList retrieveContract() {
        Customer loginUser = (Customer) AuthUtil.user;
        return loginUser.getContractList();
    }

    public void applyInsurance(RequestDto requestDto) {
        InsuranceApplication insuranceApplication = new InsuranceApplication();
        int insuranceId = Integer.parseInt(requestDto.get(CustomerView.INSURANCE_ID));
        String subscriberName = requestDto.get(CustomerView.SUBSCRIBER_NAME);
        String details = requestDto.get(CustomerView.DETAIL);
        String accountNumber = requestDto.get(CustomerView.ACCOUNT_NUMBER);
        int monthPayment = Integer.parseInt(requestDto.get(CustomerView.MONTH_PAYMENT));
        int insuranceNumber = Integer.parseInt(requestDto.get(CustomerView.INSURANCE_NUMBER));
        InsuranceType insuranceType = InsuranceType.findByNumber(insuranceNumber);
        insuranceApplication.setInsuranceApplicationID(insuranceId);
        insuranceApplication.setSubscriberName(subscriberName);
        insuranceApplication.setDetails(details);
        insuranceApplication.setAccountNumber(accountNumber);
        insuranceApplication.setMonthPaymentFee(monthPayment);
        insuranceApplication.setInsuranceType(insuranceType);
        insuranceApplyList.add(insuranceApplication);
    }

    public void payInsurancePremium(RequestDto requestDto) {
    }

    public void requireInsuranceBenefit(RequestDto requestDto) {
    }

    public void applyFireInsurance(RequestDto requestDto) {
    }

    public void applyLifeInsurance(RequestDto requestDto) {
    }

    public void applyTravelInsurance(RequestDto requestDto) {
    }

    public void applyCarInsurance(RequestDto requestDto) {
    }

    public void applyCancerInsurance(RequestDto requestDto) {
    }
}