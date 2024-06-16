package org.example.common.controller;

import java.util.List;
import java.util.Objects;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.common.view.SystemView;
import org.example.insurance.InsuranceType;
import org.example.planTeam.design.model.insurance.Insurance;
import org.example.planTeam.design.model.insurance.InsuranceList;
import org.example.user.CustomerProcess;
import org.example.user.CustomerProcessManager;
import org.example.user.CustomerView;

public class CustomerSystem {

    private final SystemView systemView;
    private final CustomerView customerView;
    private final CustomerProcessManager customerProcessManager;
    private final InsuranceList insuranceList;

    public CustomerSystem(SystemView systemView, CustomerView customerView, CustomerProcessManager customerProcessManager, InsuranceList insuranceList) {
        this.systemView = systemView;
        this.customerView = customerView;
        this.customerProcessManager = customerProcessManager;
        this.insuranceList = insuranceList;
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
                int selectInsurance = customerView.selectInsuranceNumber();
                InsuranceType insuranceType = InsuranceType.findByNumber(selectInsurance);
                List<Insurance> insurances = insuranceList.findAll();
                List<Insurance> selectInsurances = classifyInsurance(insurances, insuranceType);
                if(!selectInsurances.isEmpty()){
                    RequestDto requestDto = customerView.requireInsuranceInfo(selectInsurances);
                    Insurance insurance = insuranceList.findById(Integer.parseInt(requestDto.get(CustomerView.INSURANCE_NUMBER)));
                    customerProcessManager.applyInsurance(requestDto, insurance);
                    customerView.successTask();
                    return;
                }
                customerView.emptyInsuranceInfo();
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
            }
            default -> throw new IllegalArgumentException("선택하신 업무가 존재하지 않습니다");
        }
    }

    private List<Insurance> classifyInsurance(List<Insurance> insurances, InsuranceType insuranceType) {
        return insurances.stream()
            .filter(insurance -> Objects.equals(insurance.getInsuranceType(), insuranceType))
            .toList();
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
