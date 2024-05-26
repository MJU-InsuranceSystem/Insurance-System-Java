package org.example;

import java.util.Map;
import org.example.common.MainSystemConfig;
import org.example.view.SystemView;

public class Main {
  public static final int LOGIN_NUMBER = 1;
  public static final int SIGNUP_NUMBER = 2;

    public static void main(String[] args) {
      MainSystemConfig mainSystemConfig = new MainSystemConfig();
      Program program = mainSystemConfig.program();
      SystemView systemView = mainSystemConfig.systemView();
      systemView.introduce();
      int selectNumber = systemView.selectAuthOption();
      Map<String,String> authInfo = systemView.guideAuth(selectNumber);

      switch (selectNumber) {
        case LOGIN_NUMBER -> {
          String userId = program.login(authInfo);
          systemView.successLogin();
          program.start(userId);
        }
        case SIGNUP_NUMBER -> {
          program.signUp(authInfo);
          systemView.successSignUp();
          Map<String,String> loginInfo = systemView.loginGuide();
          String userId = program.login(loginInfo);
          systemView.successLogin();
          program.start(userId);
        }
      }
    }
}