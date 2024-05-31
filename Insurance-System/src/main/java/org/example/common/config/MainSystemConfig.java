package org.example.common.config;

import org.example.auth.AuthController;
import org.example.common.controller.CustomerSystem;
import org.example.common.controller.FrontController;
import org.example.common.controller.WorkerSystem;
import org.example.common.view.InsuranceSystemView;
import org.example.common.view.SystemView;
import org.example.insurance.InsuranceApplyList;
import org.example.user.CustomerProcessManager;
import org.example.user.CustomerView;

public class MainSystemConfig {

  public FrontController frontController() {
    return new FrontController(systemView(), authController(), customerSystem(), workerSystem());
  }

  private static SystemView systemView() {
    return new InsuranceSystemView();
  }

  private AuthController authController() {
    return new AuthController(systemView());
  }

  private CustomerSystem customerSystem() {
    return new CustomerSystem(systemView(), customerView(), customerProcessManager());
  }

  private CustomerView customerView() {
    return new CustomerView();
  }

  private CustomerProcessManager customerProcessManager() {
    return new CustomerProcessManager(new InsuranceApplyList());
  }

  private WorkerSystem workerSystem() {
    return new WorkerSystem(systemView());
  }

}
