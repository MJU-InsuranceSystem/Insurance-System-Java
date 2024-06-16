package org.example.rewardSupportTeam;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.insurance.InsuranceChargeCustomerApplyList;
import org.example.planTeam.Status;
import org.example.planTeam.design.model.insurance.Insurance;
import org.example.rewardSupportTeam.model.*;
import org.example.user.Customer;
import org.example.user.CustomerList;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.rewardSupportTeam.view.RewardSupportView.*;

/**
 * @author USER
 * @version 1.0
 */
public class RewardSupportTeam extends Team {

    private final AccidentList accidentList;
    private final litigationInfoList litigationInfoList;

    private final InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList;
    private final InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList;

    private static boolean judgmentResult = false;

    public RewardSupportTeam(AccidentList accidentList, litigationInfoList litigationInfoList, InsuranceChargeCustomerApplyList insuranceChargeCustomerApplyList, InsurancePremiumPaymentCustomerList insurancePremiumPaymentCustomerList) {
        this.accidentList = accidentList;
        this.litigationInfoList = litigationInfoList;
        this.insuranceChargeCustomerApplyList = insuranceChargeCustomerApplyList;
        this.insurancePremiumPaymentCustomerList = insurancePremiumPaymentCustomerList;
    }

    public void finalize() throws Throwable {

    }

    @Override
    public ResponseDto manage(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto process(RequestDto request) {
        ResponseDto responseDto = new ResponseDto();

        if (request.get(JUDGE_ANSWER).equals("Y") || request.get(JUDGE_ANSWER).equals("y")) {
            // 면부책을 판단한다
            Accident accident = accidentList.read(0);
            if (accident == null) {
                judgmentResult = false;
                responseDto.add(Status.getKey(), Status.EMPTY.getStatus());
                return responseDto;
            }
            judgmentResult = true;
            responseDto.add(Status.getKey(), Status.SUCCESS.getStatus());
        } else if (request.get(JUDGE_ANSWER).equals("N") || request.get(JUDGE_ANSWER).equals("n")) {
            responseDto.add(Status.getKey(), Status.FAIL.getStatus());
        } else {
            responseDto.add(Status.getKey(), Status.INPUT_INVALID.getStatus());
        }
        return responseDto;
    }

    @Override
    public ResponseDto register(RequestDto request) {
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }

    @Override
    public ResponseDto remove(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto retrieve(RequestDto request) {
        ResponseDto responseDto = new ResponseDto();

        if (request.isEmpty()) {
            for (Accident accident : accidentList.getAllAccidents()) {
                responseDto.add(ENTITY_LIST, accident.toString());
            }
            return responseDto;
        }

        if (judgmentResult) {
            responseDto.add(Status.getKey(), Status.SUCCESS.getStatus());
            return responseDto;
        }
        responseDto.add(Status.getKey(), Status.FAIL.getStatus());
        return responseDto;
    }

    public ResponseDto getNotPaidCustomer() {
        List<Customer> paidCustomers = insurancePremiumPaymentCustomerList.getAll();
        List<Customer> allCustomers = CustomerList.getInstance().getCustomerList();
        List<Customer> unpaidCustomers = allCustomers.stream()
                .filter(customer -> !paidCustomers.contains(customer))
                .toList();
        String notPaidCustomers = unpaidCustomers.stream()
                .map(Customer::getName)
                .collect(Collectors.joining("\n"));

        ResponseDto responseDto = new ResponseDto();
        if (!unpaidCustomers.isEmpty()) {
            responseDto.add(NOT_PAID_CUSTOMER, notPaidCustomers);
        } else {
            responseDto.add(NOT_PAID_CUSTOMER, "모든 고객이 납부하였습니다.");
        }
        return responseDto;
    }
}