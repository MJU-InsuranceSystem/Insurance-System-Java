package org.example.controller;

import java.util.Objects;
import java.util.Optional;
import org.example.InsuranceProgram;
import org.example.Program;
import org.example.common.MainSystemConfig;
import org.example.config.LoginConfig;
import org.example.login.LoginService;
import org.example.user.User;
import org.example.user.User.Role;
import org.example.view.SystemView;

public class FrontController {

    private static boolean PROGRAM_TRIGGER = false;
    private final LoginConfig loginConfig;
    private final SystemView systemView;
    private final LoginService loginService;
    private MainSystemConfig mainSystemConfig;

    private InsuranceProgram insuranceProgram;

    private CustomerSystem customerSystem;

    public FrontController() {
        mainSystemConfig = new MainSystemConfig();
        Program program = mainSystemConfig.program();
        this.loginConfig = new LoginConfig();
        systemView = this.loginConfig.loginView();
        loginService = new LoginService(program, systemView);
        customerSystem = new CustomerSystem();
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
                        break;
                    default:
                        break;
                }
            } else {
                // user가 null인 경우 처리
            }
        }
    }
}

