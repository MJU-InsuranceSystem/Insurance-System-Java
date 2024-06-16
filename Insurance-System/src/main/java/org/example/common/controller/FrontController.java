package org.example.common.controller;

import org.example.user.customer.CustomerSystem;
import org.example.user.worker.WorkerSystem;
import org.example.user.auth.AuthController;
import org.example.user.User;
import org.example.common.view.SystemView;

public class FrontController {

    private final SystemView systemView;
    private final AuthController authController;
    private final CustomerSystem customerSystem;
    private final WorkerSystem workerSystem;

    private static boolean PROGRAM_TRIGGER = false;

    public FrontController(SystemView systemView, AuthController authController,
        CustomerSystem customerSystem, WorkerSystem workerSystem) {
        this.systemView = systemView;
        this.authController = authController;
        this.customerSystem = customerSystem;
        this.workerSystem = workerSystem;
    }

    public void run() {
        systemView.introduce();
        while (!PROGRAM_TRIGGER) {
            try {
                User user = authController.process();
                if (user == null) {
                    break;
                }
                if (!user.isLogin()) {
                    continue;
                }
                switch (user.getUserType()) {
                    case CUSTOMER -> customerSystem.process();
                    case WORKER -> workerSystem.process();
                    default -> throw new IllegalArgumentException("올바른 유저 유형을 찾을 수 없습니다.");
                }
            } catch (Exception e) {
                systemView.showError(e.getMessage());
            }
        }
    }
}

