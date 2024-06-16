package org.example.common.controller;

import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.common.view.SystemView;
import org.example.contract.ContractList;
import org.example.contract.ContractManagementTeam;
import org.example.insurance.InsuranceType;
import org.example.user.CustomerProcess;
import org.example.user.CustomerProcessManager;
import org.example.user.CustomerView;

public class CustomerSystem {

    private final SystemView systemView;
    private final CustomerView customerView;
    private final CustomerProcessManager customerProcessManager;

    public CustomerSystem(SystemView systemView, CustomerView customerView, CustomerProcessManager customerProcessManager) {
        this.systemView = systemView;
        this.customerView = customerView;
        this.customerProcessManager = customerProcessManager;
    }

    public void process() {
        while (true) {
            try {
                int processNumber = systemView.selectCustomerProcess();
                if (processNumber == 0) {
                    break;
                }
                CustomerProcess process = CustomerProcess.findByNumber(processNumber);
                startProcess(process);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void startProcess(CustomerProcess process) {
        switch (process) {
            case APPLY_INSURANCE_JOIN -> {
//                applyInsuranceJoin();
                RequestDto requestDto = customerView.requireInsuranceInfo();
                customerProcessManager.applyInsurance(requestDto);
                customerView.successTask();
            }
            case PAY_INSURANCE_PREMIUM -> {
                ResponseDto responseDto = customerProcessManager.getAccountOfInsurance();
                if (customerView.showAccountOfInsurance(responseDto)) {
                    RequestDto requestDto = customerView.payInsurancePremiumInfo();
                    customerProcessManager.payInsurancePremium(requestDto);
                    customerView.successTask();
                }
            }
            case REQUIRE_INSURANCE_BENEFIT -> {
                RequestDto requestDto = customerView.requireInsuranceBenefitInfo();
                ResponseDto responseDto = customerProcessManager.requireInsuranceBenefit(requestDto);
                customerView.completeSubmitAccident(responseDto);
            }
            case RETRIEVE_CONTRACT -> {
                customerView.retrieveContract(customerProcessManager.retrieveContract());
                customerView.successTask();
            }
            default -> throw new IllegalArgumentException("선택하신 업무가 존재하지 않습니다");
        }
    }

    private void applyInsuranceJoin() {
        int insuranceNumber = customerView.selectInsuranceNumber();
        InsuranceType insuranceType = InsuranceType.findByNumber(insuranceNumber);
        switch (insuranceType) {
            case FIRE -> {
                RequestDto requestDto = customerView.requireFireInfo();
                customerProcessManager.applyFireInsurance(requestDto);
            }
            case LIFE -> {
                RequestDto requestDto = customerView.requireLifeInfo();
                customerProcessManager.applyLifeInsurance(requestDto);
            }
            case TRAVEL -> {
                RequestDto requestDto = customerView.requireTravelInfo();
                customerProcessManager.applyTravelInsurance(requestDto);
            }
            case CAR -> {
                RequestDto requestDto = customerView.requireCarInfo();
                customerProcessManager.applyCarInsurance(requestDto);
            }
            case CANCER -> {
                RequestDto requestDto = customerView.requireCancerInfo();
                customerProcessManager.applyCancerInsurance(requestDto);
            }
            default -> throw new IllegalArgumentException("해당 번호의 보험은 존재하지 않습니다.");
        }
    }
}
