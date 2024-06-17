package org.example.team.underwrite.controller;

import java.util.Objects;
import org.example.common.exception.EmptyInputException;
import org.example.common.exception.IsNotExistException;
import org.example.common.exception.NotCorrectFormat;
import org.example.team.TeamController;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
import org.example.team.contract.ContractManagementTeam;
import org.example.team.underwrite.UnderwriteTeam;
import org.example.team.underwrite.usecase.UnderwriteUsecase;
import org.example.team.underwrite.view.UnderwriteView;

public class UnderwriteController implements TeamController {

  private final UnderwriteTeam underwriteTeam;
  private final UnderwriteView underwriteView;
  private final ContractManagementTeam contractManagementTeam;
  private final String TEAM_NAME = "U/W 팀";
  public UnderwriteController(UnderwriteTeam underwriteTeam, UnderwriteView underwriteView,
      ContractManagementTeam contractManagementTeam) {
    this.underwriteTeam = underwriteTeam;
    this.underwriteView = underwriteView;
    this.contractManagementTeam = contractManagementTeam;
  }

  @Override
  public void process() {
    try {
      underwriteView.intro(TEAM_NAME);
      int selectNumber = underwriteView.selectUsecase(UnderwriteUsecase.class);
      UnderwriteUsecase usecase = UnderwriteUsecase.findByNumber(selectNumber);
      executeUsecase(usecase);
    } catch (IsNotExistException | NotCorrectFormat | EmptyInputException e) {
      underwriteView.showErrorMessage(e.getMessage());
    }
  }

  private void executeUsecase(UnderwriteUsecase usecase) {
    switch (usecase) {
      case ESTABLISH_UNDERWRITING_POLICY -> {
        RequestVO requestVO = underwriteView.createPolicy();
        ResponseVO responseVO = underwriteTeam.register(requestVO);
        underwriteView.showCreatePolicyResult(responseVO);
      }
      case PERFORM_UNDERWRITING -> {
        String insuranceInfo = findAllInsuranceInfo(usecase.getOrder());
        if (insuranceInfo == null) {
          throw new IsNotExistException("인수 심사할 대상이 존재하지 않습니다.");
        }
        int applicationId = underwriteView.selectApplicationId(insuranceInfo);
        RequestVO requestVO = new RequestVO();
        requestVO.add(UnderwriteView.SELECT_APPLICATION_ID, String.valueOf(applicationId));
        ResponseVO selectInsuranceInfo = underwriteTeam.retrieve(requestVO);
        RequestVO underwritingResult = underwriteView.performUnderwriting(selectInsuranceInfo);
        underwritingResult.add(UnderwriteView.SELECT_APPLICATION_ID, String.valueOf(applicationId));

        ResponseVO responseVO = underwriteTeam.process(underwritingResult);
        if (Objects.equals(responseVO.get(UnderwriteView.UNDERWRITING_RESULT), "Y")) {
          ResponseVO contractResult = registerContract(responseVO);
          underwriteView.showContractResult(contractResult);
        }
        underwriteView.showPerformUnderwritingResult(responseVO);
      }
      case REQUIRE_CO_UNDERWRITING -> {
        RequestVO requestVO = underwriteView.requireCoUnderwriting();
        ResponseVO responseVO = underwriteTeam.retrieve(requestVO);
        underwriteView.showRequireCoUnderwritingResult(responseVO);
      }
      default -> throw new IsNotExistException("해당하는 usecase가 없습니다.");
    }
  }

  private ResponseVO registerContract(ResponseVO responseVO) {
    String insuranceId = responseVO.get(UnderwriteView.FINISH_INSURANCE_ID);
    String customerName = responseVO.get(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME);
    RequestVO requestVO = new RequestVO();
    requestVO.add(UnderwriteView.FINISH_INSURANCE_ID, insuranceId);
    requestVO.add(UnderwriteView.FINISH_INSURANCE_CUSTOMER_NAME, customerName);
    return contractManagementTeam.register(requestVO);
  }

  private String findAllInsuranceInfo(int order) {
    RequestVO requestVO = new RequestVO();
    requestVO.add(UnderwriteView.USECASE_NUMBER, String.valueOf(order));
    ResponseVO responseVO = underwriteTeam.retrieve(requestVO);
    return responseVO.get(UnderwriteView.ALL_INSURANCE_APPLY);
  }
}
