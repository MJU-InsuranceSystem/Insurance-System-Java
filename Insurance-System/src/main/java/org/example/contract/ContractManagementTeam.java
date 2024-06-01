package org.example.contract;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.domain.insurance.Insurance;
import org.example.insurance.InsuranceList;
import org.example.underwriteTeam.view.UnderwriteView;

public class ContractManagementTeam extends Team {

  private final ContractList contractList;
  private final InsuranceList insuranceApplyList;

  public ContractManagementTeam(ContractList contractList, InsuranceList insuranceApplyList) {
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
    int insuranceId = Integer.parseInt(request.get(UnderwriteView.FINISH_INSURANCE_ID));
    Insurance insurance = insuranceApplyList.findById(insuranceId);
    String customerName = request.get(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME);
    Contract contract = new Contract();
    contract.setInsurance(insurance);
    contract.setManagerName("모델들이 하는 모델링");
    contract.setCustomerName(customerName);
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
}
