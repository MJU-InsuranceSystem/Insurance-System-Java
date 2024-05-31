package org.example.underwriteTeam.controller;

import java.util.Objects;
import org.example.TeamController;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.contract.ContractManagementTeam;
import org.example.underwriteTeam.UnderwriteTeam;
import org.example.underwriteTeam.usecase.UnderwriteUsecase;
import org.example.underwriteTeam.view.UnderwriteView;

public class UnderwriteController implements TeamController {

  private final UnderwriteTeam underwriteTeam;
  private final UnderwriteView underwriteView;
  private final ContractManagementTeam contractManagementTeam;

  public UnderwriteController(UnderwriteTeam underwriteTeam, UnderwriteView underwriteView,
      ContractManagementTeam contractManagementTeam) {
    this.underwriteTeam = underwriteTeam;
    this.underwriteView = underwriteView;
    this.contractManagementTeam = contractManagementTeam;
  }

  @Override
  public void process() {
    underwriteView.intro("U/W 팀");
    int selectNumber = underwriteView.selectUsecase(UnderwriteUsecase.class);
    UnderwriteUsecase usecase = UnderwriteUsecase.findByNumber(selectNumber);
    executeUsecase(usecase);
  }

  private void executeUsecase(UnderwriteUsecase usecase) {
    switch (usecase) {
      case ESTABLISH_UNDERWRITING_POLICY -> {
        RequestDto requestDto = underwriteView.createPolicy();
        ResponseDto responseDto = underwriteTeam.register(requestDto);
        underwriteView.showCreatePolicyResult(responseDto);
      }
      case PERFORM_UNDERWRITING -> {
        String insuranceInfo = findFirstInsuranceInfo(usecase.getOrder());
        RequestDto requestDto = underwriteView.performUnderwriting(insuranceInfo);
        ResponseDto responseDto = underwriteTeam.process(requestDto);
        if (Objects.equals(responseDto.get(UnderwriteView.UNDERWRITING_RESULT), "Y")) {
          ResponseDto contractResult = registerContract(responseDto);
          underwriteView.showContractResult(contractResult);
        }
        underwriteView.showPerformUnderwritingResult(responseDto);
      }
      case REQUIRE_CO_UNDERWRITING -> {
        RequestDto requestDto = underwriteView.requireCoUnderwriting();
        ResponseDto responseDto = underwriteTeam.retrieve(requestDto);
        underwriteView.showRequireCoUnderwritingResult(responseDto);
      }
      default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
    }
  }

  private ResponseDto registerContract(ResponseDto responseDto) {
    String insuranceId = responseDto.get(UnderwriteView.FINISH_INSURANCE_ID);
    String customerName = responseDto.get(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME);
    RequestDto requestDto = new RequestDto();
    requestDto.add(UnderwriteView.FINISH_INSURANCE_ID, insuranceId);
    requestDto.add(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME, customerName);
    return contractManagementTeam.register(requestDto);
  }

  private String findFirstInsuranceInfo(int order) {
    RequestDto requestDto = new RequestDto();
    requestDto.add(UnderwriteView.USECASE_NUMBER, String.valueOf(order));
    ResponseDto responseDto = underwriteTeam.retrieve(requestDto);
    return responseDto.get(UnderwriteView.FIRST_INSURANCE_APPLY);
  }
}
