package org.example.team.rewardSupport;

import static org.example.team.rewardSupport.view.RewardSupportView.ACCIDENT_NAME;
import static org.example.team.rewardSupport.view.RewardSupportView.CLAIMINSURANCE_ACCOUNT;
import static org.example.team.rewardSupport.view.RewardSupportView.ENTITY_LIST;
import static org.example.team.rewardSupport.view.RewardSupportView.JUDGE_ANSWER;
import static org.example.team.rewardSupport.view.RewardSupportView.NOT_PAID_CUSTOMER;
import static org.example.team.rewardSupport.view.RewardSupportView.PAY_ANSWER;

import java.util.List;
import java.util.stream.Collectors;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
import org.example.insurance.apply.InsuranceChargeCustomerApplyList;
import org.example.team.Team;
import org.example.team.plan.Status;
import org.example.team.rewardSupport.model.Accident;
import org.example.team.rewardSupport.model.AccidentList;
import org.example.team.rewardSupport.model.InsurancePremiumPaymentCustomerList;
import org.example.team.rewardSupport.model.litigationInfoList;
import org.example.user.customer.Customer;
import org.example.user.customer.CustomerList;

/**
 * @author USER
 * @version 1.0
 */
public class RewardSupportTeam extends Team {

    private final AccidentList accidentList;
    private final org.example.team.rewardSupport.model.litigationInfoList litigationInfoList;

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

        if (judgmentResult) {
            String showJudge = "면부책 판단에 통과하였습니다.";
            responseVO.add(PAY_ANSWER, showJudge);
        } else {
            String showJudge = "면부책 판단에 탈락하였습니다.";
            responseVO.add(PAY_ANSWER, showJudge);
        }
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