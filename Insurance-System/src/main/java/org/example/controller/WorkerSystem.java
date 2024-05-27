package org.example.controller;

import org.example.Department;
import org.example.view.SystemView;

public class WorkerSystem {

    private SystemView systemView;

    public WorkerSystem(SystemView systemView) {
        this.systemView = systemView;
    }

    public void process() {
        while (true) {
            int selectTeamNumber = systemView.selectTeam();
            Department.findTeamByNumber(selectTeamNumber).getTeamController().process();
        }
    }
}
