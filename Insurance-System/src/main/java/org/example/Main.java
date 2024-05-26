package org.example;

import java.util.Map;
import org.example.common.MainSystemConfig;
import org.example.view.SystemView;

public class Main {

  private static final int LOGIN_NUMBER = 1;
  private static final int SIGNUP_NUMBER = 2;
  private static final int EXIT = 3;


  public static void main(String[] args) {
    MainSystemConfig mainSystemConfig = new MainSystemConfig();
    Program program = mainSystemConfig.program();
    SystemView systemView = mainSystemConfig.systemView();
    systemView.introduce();
    int selectNumber = systemView.selectAuthOption();

    switch (selectNumber) {
      case LOGIN_NUMBER -> {
        try {
          Map<String, String> loginInfo = systemView.getLoginInfo();
          String userId = program.login(loginInfo);
          systemView.successLogin();
          program.start(userId);
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
      }
      case SIGNUP_NUMBER -> {
        try {
          Map<String, String> signUpInfo = systemView.getSignUpInfo();
          program.signUp(signUpInfo);
          systemView.successSignUp();
          Map<String, String> loginInfo = systemView.getLoginInfo();
          String userId = program.login(loginInfo);
          systemView.successLogin();
          program.start(userId);
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
      }
      case EXIT -> {
        systemView.exitSystem();
      }
    }
  }
}