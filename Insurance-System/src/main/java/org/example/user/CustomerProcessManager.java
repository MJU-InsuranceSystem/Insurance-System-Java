package org.example.user;

import org.example.common.AuthUtil;
import org.example.common.dto.RequestDto;
import org.example.contract.ContractList;
import org.example.domain.insurance.Insurance;
import org.example.insurance.InsuranceApplyList;
import org.example.insurance.InsuranceType;
import org.example.planTeam.design.model.insurance.InsuranceList;

public class CustomerProcessManager {

    private final InsuranceList insuranceApplyList;

    public CustomerProcessManager(InsuranceApplyList insuranceApplyList) {
        this.insuranceApplyList = insuranceApplyList;
    }

    public ContractList retrieveContract() {
        Customer loginUser = (Customer) AuthUtil.user;
        return loginUser.getContractList();
    }

    public void applyInsurance(RequestDto requestDto) {
        Insurance insurance = new Insurance();
        int insuranceId = Integer.parseInt(requestDto.get(CustomerView.INSURANCE_ID));
        String subscriberName = requestDto.get(CustomerView.SUBSCRIBER_NAME);
        String details = requestDto.get(CustomerView.DETAIL);
        String accountNumber = requestDto.get(CustomerView.ACCOUNT_NUMBER);
        int monthPayment = Integer.parseInt(requestDto.get(CustomerView.MONTH_PAYMENT));
        int insuranceNumber = Integer.parseInt(requestDto.get(CustomerView.INSURANCE_NUMBER));
        InsuranceType insuranceType = InsuranceType.findByNumber(insuranceNumber);
        insurance.setInsuranceID(insuranceId);
        insurance.setSubscriberName(subscriberName);
        insurance.setDetails(details);
        insurance.setAccountNumber(accountNumber);
        insurance.setMonthPaymentFee(monthPayment);
        insurance.setInsuranceType(insuranceType);
        insuranceApplyList.add(insurance);
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