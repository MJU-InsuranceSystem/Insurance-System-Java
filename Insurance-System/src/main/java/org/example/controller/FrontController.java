package org.example.controller;

import org.example.Program;
import org.example.common.MainSystemConfig;
import org.example.login.LoginService;
import org.example.user.User;
import org.example.view.SystemView;

public class FrontController {

    private static boolean PROGRAM_TRIGGER = false;
    private final LoginService loginService;
    private MainSystemConfig mainSystemConfig;
    private final CustomerSystem customerSystem;
    private final WorkerSystem workerSystem;

    public FrontController() {
        mainSystemConfig = new MainSystemConfig();
        Program program = mainSystemConfig.program();
        loginService = new LoginService(program, mainSystemConfig.systemView());
        customerSystem = new CustomerSystem();
        workerSystem = new WorkerSystem();
    }

    public void run() {

        SystemView systemView = mainSystemConfig.systemView();
        systemView.introduce();
        while (!PROGRAM_TRIGGER) {
            User user = loginService.process();
            if (user != null) {
                switch (user.getRole()) {
                    case customer:
                        customerSystem.process();
                        break;
                    case worker:
                        workerSystem.process();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}

