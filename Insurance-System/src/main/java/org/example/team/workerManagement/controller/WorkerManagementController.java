package org.example.team.workerManagement.controller;


import org.example.team.TeamController;
import org.example.team.workerManagement.WorkerManagementTeam;
import org.example.team.workerManagement.usecase.WorkerManagementUsecase;
import org.example.team.workerManagement.view.WorkerManagementView;

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
