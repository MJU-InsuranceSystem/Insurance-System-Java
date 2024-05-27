package org.example.login;

import java.util.Arrays;
import org.example.user.CustomerManager;
import org.example.user.WorkerManager;

public enum AuthProcessType {
  LOGIN(1, new LoginProcess(CustomerManager.getInstance(), WorkerManager.getInstance())),
  SIGN_UP(2, new SignUpProcess(CustomerManager.getInstance(), WorkerManager.getInstance()));

  private final int processNumber;
  private final Process process;

  AuthProcessType(int processNumber, Process process) {
    this.processNumber = processNumber;
    this.process = process;
  }

  public int getProcessNumber() {
    return this.processNumber;
  }

  public Process getProcess() {
    return this.process;
  }

  public static AuthProcessType findProcessType(int processNumber) {
    return Arrays.stream(AuthProcessType.values())
        .filter(process -> process.getProcessNumber() == processNumber)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("해당 프로세스 번호는 존재하지 않습니다."));
  }
}
