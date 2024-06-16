package org.example.underwriteTeam.controller;

import java.util.Objects;
import org.example.TeamController;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;
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
        RequestVO requestVO = underwriteView.createPolicy();
        ResponseVO responseVO = underwriteTeam.register(requestVO);
        underwriteView.showCreatePolicyResult(responseVO);
      }
      case PERFORM_UNDERWRITING -> {
        String insuranceInfo = findAllInsuranceInfo(usecase.getOrder());
        if (insuranceInfo == null) {
          underwriteView.inNotExistInsuranceApply();
          return;
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
      default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
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
