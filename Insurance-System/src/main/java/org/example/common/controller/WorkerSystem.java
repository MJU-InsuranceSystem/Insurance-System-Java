package org.example.common.controller;

import org.example.Department;
import org.example.common.view.SystemView;

public class WorkerSystem {

    private SystemView systemView;

    public WorkerSystem(SystemView systemView) {
        this.systemView = systemView;
    }

    public void process() {
        while (true) {
            int selectTeamNumber = systemView.selectTeam();
            if (selectTeamNumber == 0) {
                break;
            }
            Department.findTeamByNumber(selectTeamNumber).getTeamController().process();
        }
    }
}
