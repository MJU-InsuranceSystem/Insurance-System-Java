package org.example.user;

import java.util.Map;
import org.example.common.AuthGuideMessage;

public class Worker extends User{

  public Worker() {

  }

  public Worker(String name, String age, String sex, String phoneNumber, String id, String password) {
    this.name = name;
    this.age = age;
    this.sex = sex;
    this.phoneNumber = phoneNumber;
    this.id = id;
    this.password = password;
  }

  public static Worker create(Map<String, String> authInfo) {
    String name = authInfo.get(AuthGuideMessage.AUTH_NAME_KEY);
    String age = authInfo.get(AuthGuideMessage.AUTH_NAME_KEY);
    String sex = authInfo.get(AuthGuideMessage.AUTH_NAME_KEY);
    String phoneNumber = authInfo.get(AuthGuideMessage.AUTH_NAME_KEY);
    String id = authInfo.get(AuthGuideMessage.AUTH_NAME_KEY);
    String password = authInfo.get(AuthGuideMessage.AUTH_NAME_KEY);

    return new Worker(name, age, sex, phoneNumber, id, password);
  }
}
