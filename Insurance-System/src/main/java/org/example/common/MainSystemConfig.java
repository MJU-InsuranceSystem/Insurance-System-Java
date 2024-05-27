package org.example.common;

import org.example.controller.CustomerSystem;
import org.example.controller.FrontController;
import org.example.controller.WorkerSystem;
import org.example.login.AuthController;
import org.example.view.InsuranceSystemView;
import org.example.view.SystemView;

public class MainSystemConfig {

  public FrontController frontController() {
    return new FrontController(systemView(), authController(), customerSystem(), workerSystem());
  }

  private SystemView systemView() {
    return new InsuranceSystemView();
  }

  private AuthController authController() {
    return new AuthController(systemView());
  }

  private CustomerSystem customerSystem() {
    return new CustomerSystem(systemView());
  }

  private WorkerSystem workerSystem() {
    return new WorkerSystem(systemView());
  }

}
