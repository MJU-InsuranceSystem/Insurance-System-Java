package org.example.rewardSupportTeam;

import org.example.Team;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
import org.example.insurance.InsuranceChargeCustomerApplyList;
import org.example.planTeam.Status;
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
    public ResponseVO manage(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO process(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();

        if (request.get(JUDGE_ANSWER).equals("Y") || request.get(JUDGE_ANSWER).equals("y")) {
            // 면부책을 판단한다
            Accident accident = accidentList.read(0);
            if (accident == null) {
                judgmentResult = false;
                responseVO.add(Status.getKey(), Status.EMPTY.getStatus());
                return responseVO;
            }
            judgmentResult = true;
            responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
        } else if (request.get(JUDGE_ANSWER).equals("N") || request.get(JUDGE_ANSWER).equals("n")) {
            responseVO.add(Status.getKey(), Status.FAIL.getStatus());
        } else {
            responseVO.add(Status.getKey(), Status.INPUT_INVALID.getStatus());
        }
        return responseVO;
    }

    @Override
    public ResponseVO register(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();
        return responseVO;
    }

    @Override
    public ResponseVO remove(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO retrieve(RequestVO request) {
        ResponseVO responseVO = new ResponseVO();

        if (request.isEmpty()) {
            for (Accident accident : accidentList.getAllAccidents()) {
                responseVO.add(ENTITY_LIST, accident.toString());
            }
            return responseVO;
        }

        if (judgmentResult) {
            judgmentResult = false;
            Accident accident = accidentList.read(0);
            responseVO.add(ACCIDENT_NAME, accident.getCustomerName());
            responseVO.add(CLAIMINSURANCE_ACCOUNT, accident.getClaimInsurance().getAccount());
            responseVO.add(Status.getKey(), Status.SUCCESS.getStatus());
            return responseVO;
        }
        responseVO.add(Status.getKey(), Status.FAIL.getStatus());
        return responseVO;
    }

    public ResponseVO getNotPaidCustomer() {
        List<Customer> paidCustomers = insurancePremiumPaymentCustomerList.getAll();
        List<Customer> allCustomers = CustomerList.getInstance().getCustomerList();
        List<Customer> unpaidCustomers = allCustomers.stream()
                .filter(customer -> !paidCustomers.contains(customer))
                .toList();
        String notPaidCustomers = unpaidCustomers.stream()
                .map(Customer::getName)
                .collect(Collectors.joining("\n"));

        ResponseVO responseVO = new ResponseVO();
        if (!unpaidCustomers.isEmpty()) {
            responseVO.add(NOT_PAID_CUSTOMER, notPaidCustomers);
        } else {
            responseVO.add(NOT_PAID_CUSTOMER, "모든 고객이 납부하였습니다.");
        }
        return responseVO;
    }
}