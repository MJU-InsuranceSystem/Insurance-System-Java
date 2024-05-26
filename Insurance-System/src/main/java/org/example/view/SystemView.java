package org.example.view;

import java.util.Map;

public interface SystemView {

  void introduce();

  int selectAuthOption();

  Map<String, String> getLoginInfo();

  Map<String, String> getSignUpInfo();

  void successLogin();

  void successSignUp();

  void exitSystem();
}
