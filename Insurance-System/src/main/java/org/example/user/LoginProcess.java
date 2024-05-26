package org.example.user;

import java.util.Map;
import org.example.Program;
import org.example.view.SystemView;

public class LoginProcess implements Process{

  private static final LoginProcess LOGIN_PROCESS = new LoginProcess();

  private LoginProcess() {

  }

  @Override
  public void execute(SystemView systemView, Program program) {
    try {
      Map<String, String> loginInfo = systemView.getLoginInfo();
      String userId = program.login(loginInfo);
      systemView.successLogin();
      program.start(userId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Process getInstance() {
    return LOGIN_PROCESS;
  }
}
