package org.example.contract;

import static org.example.user.CustomerManager.CUSTOMER_MANAGER;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.domain.insurance.InsuranceApplication;
import org.example.insurance.InsuranceApplyList;
import org.example.underwriteTeam.view.UnderwriteView;
import org.example.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class ContractManagementTeam extends Team {

    private final ContractList contractList;
    private final InsuranceApplyList insuranceApplyList;
    private static int order = 0;


    public ContractManagementTeam(ContractList contractList, InsuranceApplyList insuranceApplyList) {
        this.contractList = contractList;
        this.insuranceApplyList = insuranceApplyList;
    }

    @Override
    public ResponseDto manage(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto process(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto register(RequestDto request) {
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

        ResponseDto responseDto = new ResponseDto();
        responseDto.add(UnderwriteView.CONTRACT_INFO, contract.toString());
        return responseDto;
    }

    @Override
    public ResponseDto remove(RequestDto request) {
        return null;
    }

    @Override
    public ResponseDto retrieve(RequestDto request) {
        return null;
    }

    public ContractList retrieveContracts() {
        return contractList;
    }

    public void deleteContract(RequestDto requestDto) {
        int contractId = Integer.parseInt(requestDto.get(ContractManagementView.CONTRACT_ID));
        contractList.removeById(contractId);
    }
}