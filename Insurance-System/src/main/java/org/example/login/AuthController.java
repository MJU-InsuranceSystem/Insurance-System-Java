package org.example.login;

import org.example.user.AuthProcessType;
import org.example.user.Process;
import org.example.user.User;
import org.example.view.SystemView;

public class AuthController {

    private SystemView systemView;
    public AuthController(SystemView systemView) {
        this.systemView = systemView;
    }

    public User process() {
        int selectNumber = systemView.selectAuthOption();
        checkExitNumber(selectNumber);
        Process process = AuthProcessType.findProcessType(selectNumber).getProcess();
        return process.execute(systemView);
    }

    private void checkExitNumber(int selectNumber) {
        if(selectNumber == 3) {
            systemView.exitSystem();
        }
    }
}
