package org.example;

import java.util.Map;

public interface Program {

  String login(Map<String, String> authInfo);

  void signUp(Map<String, String> authInfo);

  void start(String userId);
}
