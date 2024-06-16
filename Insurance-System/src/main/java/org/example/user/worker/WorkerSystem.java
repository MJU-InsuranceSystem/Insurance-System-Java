package org.example.user.worker;

import org.example.team.Department;
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
