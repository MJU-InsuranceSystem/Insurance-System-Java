package org.example.common;

import org.example.InsuranceProgram;
import org.example.Program;
import org.example.user.CustomerManager;
import org.example.user.WorkerManager;
import org.example.view.InsuranceSystemView;
import org.example.view.SystemView;

public class MainSystemConfig {

  public SystemView systemView() {
    return new InsuranceSystemView();
  }

  public Program program() {
    return new InsuranceProgram(customerManager(), workerManager());
  }

  public CustomerManager customerManager() {
    return CustomerManager.getInstance();
  }

  public WorkerManager workerManager() {
    return WorkerManager.getInstance();
  }
}
