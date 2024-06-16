package org.example.user;

import static org.example.rewardSupportTeam.view.RewardSupportView.ACCIDENT_CONTENT;
import static org.example.rewardSupportTeam.view.RewardSupportView.ACCIDENT_NAME;
import static org.example.rewardSupportTeam.view.RewardSupportView.CLAIMINSURANCE_ACCOUNT;
import static org.example.rewardSupportTeam.view.RewardSupportView.CLAIMINSURANCE_ADDRESS;
import static org.example.rewardSupportTeam.view.RewardSupportView.CLAIMINSURANCE_PHONENUMBER;
import static org.example.rewardSupportTeam.view.RewardSupportView.CLAIMINSURANCE_RESIDENTNUMBER;
import static org.example.rewardSupportTeam.view.RewardSupportView.CLAIMINSURANCE_SUPPORTINGFILE;
import static org.example.user.CustomerView.CHARGE_ANSWER;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.common.AuthUtil;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.contract.Contract;
import org.example.domain.insurance.InsuranceApplication;
import org.example.insurance.InsuranceApplyList;
import org.example.insurance.InsuranceChargeCustomerApplyList;
import org.example.planTeam.Status;
import org.example.planTeam.design.model.insurance.Insurance;
import org.example.rewardSupportTeam.model.Accident;
import org.example.rewardSupportTeam.model.AccidentList;
import org.example.rewardSupportTeam.model.ClaimInsurance;
import org.example.rewardSupportTeam.model.InsurancePremiumPaymentCustomerList;

public class CustomerProcessManager {

    private final InsuranceApplyList insuranceApplyList;
    private final InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList;
    private final InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList;
    private final AccidentList accidentList;

    public CustomerProcessManager(InsuranceApplyList insuranceApplyList, InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList, AccidentList accidentList, InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList) {
        this.insuranceApplyList = insuranceApplyList;
        this.insuranceChargeCustomerApplyList = insuranceChargeCustomerApplyList;
        this.accidentList = accidentList;
        this.insurancePremiumPaymentCustomerList = insurancePremiumPaymentCustomerList;
    }

    public List<Contract> retrieveContract() {
        Customer loginUser = (Customer) AuthUtil.user;
        return loginUser.getContractList();
    }

    public void applyInsurance(RequestDto requestDto, Insurance insurance) {
        InsuranceApplication insuranceApplication = new InsuranceApplication();
        int insuranceApplicationId = Integer.parseInt(requestDto.get(CustomerView.INSURANCE_APPLICATION_ID));
        String subscriberName = requestDto.get(CustomerView.SUBSCRIBER_NAME);
        String personalInfo = requestDto.get(CustomerView.PERSONAL_INFO);
        String familyHistory = requestDto.get(CustomerView.FAMILY_HISTORY);
        String requestInsurance = requestDto.get(CustomerView.REQUEST_INSURANCE);

        insuranceApplication.setInsuranceApplicationID(insuranceApplicationId);
        insuranceApplication.setSubscriberName(subscriberName);
        insuranceApplication.setPersonalInfo(personalInfo);
        insuranceApplication.setFamilyHistory(familyHistory);
        insuranceApplication.setRequestInsurance(requestInsurance);
        insuranceApplication.setInsurance(insurance);
        insuranceApplyList.add(insuranceApplication);
    }

    public void payInsurancePremium(RequestDto requestDto) {
        Customer customer = (Customer) AuthUtil.user;
        String premiumAnswer = requestDto.get(CustomerView.PREMIUM_ANSWER);
        if(premiumAnswer.equals("Y") || premiumAnswer.equals("y")) {
               insurancePremiumPaymentCustomerList.add(customer);
        }
    }

    public ResponseDto requireInsuranceBenefit(RequestDto request) {
        ResponseDto responseDto = new ResponseDto();

        if (request.get(CHARGE_ANSWER).equals("Y") || request.get(CHARGE_ANSWER).equals("y")) {
            Customer loginUser = (Customer) AuthUtil.user;
            insuranceChargeCustomerApplyList.add(loginUser);

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

            for (Map.Entry<String, String> entry : request.getTotalInfo().entrySet()) {
                if (entry.getValue() == null) {
                    responseDto.add(Status.getKey(), Status.INPUT_EMPTY.getStatus());
                    return responseDto;
                }
            }
            boolean check = accidentList.add(accident);

            if (!check) {
                responseDto.add(Status.getKey(), Status.FAIL.getStatus());
                return responseDto;
            }
            responseDto.add(Status.getKey(), Status.SUCCESS.getStatus());
            return responseDto;
        }
        responseDto.add(Status.getKey(), Status.FAIL.getStatus());
        return responseDto;
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

    public ResponseDto getAccountOfInsurance() {
        Customer customer = (Customer) AuthUtil.user;
        ResponseDto responseDto = new ResponseDto();
        if(insurancePremiumPaymentCustomerList.contains(customer)) {
            responseDto.add(CustomerView.CHECK_PAID, "Y");
            return responseDto;
        }
        List<Contract> contracts = customer.getContractList();

        String insurances = contracts.stream()
                .map(contract -> contract.getInsuranceApplication().getInsurance().getInsuranceType().getDescription())
                .collect(Collectors.joining(", "));

        int totalAccount = contracts.stream()
                .mapToInt(contract -> contract.getInsuranceApplication().getInsurance().getReward().getMonthPaymentFee())
                .sum();

        responseDto.add(CustomerView.CHECK_PAID, "N");
        responseDto.add(CustomerView.SUBSCRIBE_INSURANCE, insurances);
        responseDto.add(CustomerView.TOTAL_ACCOUNT, String.valueOf(totalAccount));
        return responseDto;
    }
}