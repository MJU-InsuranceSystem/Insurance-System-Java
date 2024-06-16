package org.example.team.contract;

import static org.example.user.customer.CustomerList.CUSTOMER_MANAGER;

import org.example.team.Team;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
import org.example.insurance.apply.InsuranceApplication;
import org.example.insurance.apply.InsuranceApplyList;
import org.example.team.underwrite.view.UnderwriteView;
import org.example.user.customer.Customer;

public class ContractManagementTeam extends Team {

    private final ContractList contractList;
    private final InsuranceApplyList insuranceApplyList;
    private static int order = 0;


    public ContractManagementTeam(ContractList contractList, InsuranceApplyList insuranceApplyList) {
        this.contractList = contractList;
        this.insuranceApplyList = insuranceApplyList;
    }

    @Override
    public ResponseVO manage(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO process(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO register(RequestVO request) {
        Customer applyCustomer = CUSTOMER_MANAGER.findByName(
                request.get(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME))
            .orElseThrow(NullPointerException::new);
        int insuranceId = Integer.parseInt(request.get(UnderwriteView.FINISH_INSURANCE_ID));
        InsuranceApplication insuranceApplication = insuranceApplyList.findById(insuranceId);
        String customerName = request.get(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME);

        Contract contract = new Contract();
        contract.setContractId(order++);
        contract.setInsurance(insuranceApplication);
        contract.setManagerName("모델들이 하는 모델링");
        contract.setCustomerName(customerName);
        applyCustomer.getContractList().add(contract);
        contractList.add(contract);
        insuranceApplyList.remove(insuranceApplication);

        ResponseVO responseVO = new ResponseVO();
        responseVO.add(UnderwriteView.CONTRACT_INFO, contract.toString());
        return responseVO;
    }

    @Override
    public ResponseVO remove(RequestVO request) {
        return null;
    }

    @Override
    public ResponseVO retrieve(RequestVO request) {
        return null;
    }

    public ContractList retrieveContracts() {
        return contractList;
    }

    public void deleteContract(RequestVO requestVO) {
        int contractId = Integer.parseInt(requestVO.get(ContractManagementView.CONTRACT_ID));
        contractList.removeById(contractId);
    }
}