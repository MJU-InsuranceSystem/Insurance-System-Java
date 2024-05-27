package org.example.login;

import org.example.Program;
import org.example.user.AuthProcessType;
import org.example.user.User;
import org.example.view.SystemView;

public class LoginService {

    private SystemView systemView;
    private Program program;

    public LoginService(Program program, SystemView systemView) {
        this.program = program;
        this.systemView = systemView;
    }

    public User process() {
        int selectNumber = systemView.selectAuthOption();
        AuthProcessType authProcessType = AuthProcessType.findProcessType(selectNumber)
            .orElse(null);
        return authProcessType.getProcess().execute(systemView, program);
    }
}
