package org.example.view;

import java.util.Map;

public interface SystemView {

  void introduce();

  int selectAuthOption();

  Map<String, String> guideAuth(int selectNumber);

  Map<String, String> loginGuide();

  Map<String, String> signUpGuide();

  void successLogin();

  void successSignUp();
}
