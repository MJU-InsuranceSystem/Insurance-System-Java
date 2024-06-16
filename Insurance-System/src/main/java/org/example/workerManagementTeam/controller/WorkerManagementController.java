package org.example.workerManagementTeam.controller;


import org.example.TeamController;
import org.example.customerManageTeam.CustomerManageTeam;
import org.example.customerManageTeam.usecase.CustomerManagementUsecase;
import org.example.customerManageTeam.view.CustomerManagementView;
import org.example.workerManagementTeam.WorkerManagementTeam;
import org.example.workerManagementTeam.usecase.WorkerManagementUsecase;
import org.example.workerManagementTeam.view.WorkerManagementView;

public class WorkerManagementController implements TeamController {

    private final WorkerManagementTeam workerManagementTeam;
    private final WorkerManagementView workerManagementView;

    public WorkerManagementController(WorkerManagementTeam workerManagementTeam, WorkerManagementView workerManagementView) {
        this.workerManagementTeam = workerManagementTeam;
        this.workerManagementView = workerManagementView;
    }

    @Override
    public void process() {
        workerManagementView.intro("직원 관리 팀");
        int selectNumber = workerManagementView.selectUsecase(WorkerManagementUsecase.class);
        WorkerManagementUsecase usecase = WorkerManagementUsecase.findByNumber(selectNumber);
        executeUsecase(usecase);
    }

    private void executeUsecase(WorkerManagementUsecase usecase) {
        switch (usecase) {
            case ALL_WORKER_RETRIEVE -> {
                workerManagementView.showAllCustomerInfo(workerManagementTeam.retrieveWorkerInfo());
            }
            default -> throw new IllegalArgumentException("해당하는 usecase가 없습니다.");
        }
    }
}
