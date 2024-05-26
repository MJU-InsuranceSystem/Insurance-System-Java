package org.example;

import java.util.Map;
import org.example.common.AuthGuideMessage;
import org.example.user.Customer;
import org.example.user.CustomerManager;
import org.example.user.UserType;
import org.example.user.Worker;
import org.example.user.WorkerManager;

public class InsuranceProgram implements Program {

  private final CustomerManager customerManager;
  private final WorkerManager workerManager;

  public InsuranceProgram(CustomerManager customerManager, WorkerManager workerManager) {
    this.customerManager = customerManager;
    this.workerManager = workerManager;
  }

  @Override
  public String login(Map<String, String> authInfo) {
    String id = authInfo.get(AuthGuideMessage.AUTH_ID_KEY);
    String password = authInfo.get(AuthGuideMessage.AUTH_PASSWORD_KEY);
    if (isExistUser(id, password)) {
      return authInfo.get(AuthGuideMessage.AUTH_ID_KEY);
    }
    throw new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다");
  }

  @Override
  public void signUp(Map<String, String> authInfo) {
    UserType userType = UserType.find(authInfo.get(AuthGuideMessage.AUTH_CUSTOMER_WORKER_KEY));
    switch (userType) {
      case CUSTOMER -> {
        Customer customer = Customer.create(authInfo);
        customerManager.add(customer);
      }
      case WORKER -> {
        Worker worker = Worker.create(authInfo);
        workerManager.add(worker);
      }
    }
  }

  @Override
  public void start(String userId) {

  }

  private boolean isExistUser(String id, String password) {
    return workerManager.isExistByIdAndPassword(id, password)
        || customerManager.isExistByIdAndPassword(id, password);
  }
}
