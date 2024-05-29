package org.example.login;

import java.util.Map;
import org.example.common.AuthGuideMessage;
import org.example.user.Customer;
import org.example.user.CustomerManager;
import org.example.user.User;
import org.example.user.UserType;
import org.example.user.Worker;
import org.example.user.WorkerManager;
import org.example.view.SystemView;

public class SignUpProcess implements Process {

    private final CustomerManager customerManager;
    private final WorkerManager workerManager;

    public SignUpProcess(CustomerManager customerManager, WorkerManager workerManager) {
        this.customerManager = customerManager;
        this.workerManager = workerManager;
    }

    @Override
    public User execute(SystemView systemView) {
            Map<String, String> signUpInfo = systemView.getSignUpInfo();
            User user = signUp(signUpInfo);
            systemView.successSignUp();
            return user;
    }

    private User signUp(Map<String, String> signUpInfo) {
        UserType userType = UserType.find(signUpInfo.get(AuthGuideMessage.AUTH_CUSTOMER_WORKER_KEY));
        switch (userType) {
            case CUSTOMER -> {
                Customer customer = Customer.create(signUpInfo);
                customerManager.add(customer);
                return customer;
            }
            case WORKER -> {
                Worker worker = Worker.create(signUpInfo);
                workerManager.add(worker);
                return worker;
            }
            default -> {
                throw new IllegalArgumentException("지원하지 않는 유형입니다");
            }
        }
    }
}
