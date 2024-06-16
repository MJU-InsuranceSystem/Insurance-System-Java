package org.example.team.contract;

import org.example.team.TeamController;
import org.example.common.dto.RequestVO;

public class ContractManagementController implements TeamController {

    private final ContractManagementView contractManagementView;
    private final ContractManagementTeam contractManagementTeam;

    public ContractManagementController(ContractManagementView contractManagementView, ContractManagementTeam contractManagementTeam) {
        this.contractManagementView = contractManagementView;
        this.contractManagementTeam = contractManagementTeam;
    }

    @Override
    public void process() {
        contractManagementView.intro("계약관리 팀");
        int selectNumber = contractManagementView.selectUsecase(ContractManagementUsecase.class);
        ContractManagementUsecase usecase = ContractManagementUsecase.findByNumber(selectNumber);
        executeUsecase(usecase);
    }

    private void executeUsecase(ContractManagementUsecase usecase) {
        switch (usecase) {
            case ALL_CONTRACT_RETRIEVE -> {
                contractManagementView.retrieveContracts(contractManagementTeam.retrieveContracts());
            }
            case CONTRACT_DELETE -> {
                RequestVO requestVO = contractManagementView.requireDeleteContractNumber();
                contractManagementTeam.deleteContract(requestVO);
                contractManagementView.successTask();
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }
}
