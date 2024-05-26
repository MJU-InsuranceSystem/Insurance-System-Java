package org.example.user;

import java.util.Arrays;
import java.util.Optional;

public enum AuthProcessType {
  LOGIN(1, LoginProcess.getInstance()),
  SIGN_UP(2, SignUpProcess.getInstance());

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

  public static Optional<AuthProcessType> findProcessType(int processNumber) {
    return Arrays.stream(AuthProcessType.values())
        .filter(process -> process.getProcessNumber() == processNumber)
        .findFirst();
  }
}
