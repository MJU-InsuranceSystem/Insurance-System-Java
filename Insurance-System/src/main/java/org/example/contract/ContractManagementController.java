package org.example.contract;

import org.example.TeamController;
import org.example.underwriteTeam.usecase.UnderwriteUsecase;

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

            }
            case CHECK_INSURANCE_ACCOUNT -> {

            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }
}
