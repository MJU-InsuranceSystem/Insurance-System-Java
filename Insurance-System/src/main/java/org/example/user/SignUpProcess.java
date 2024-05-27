package org.example.user;

import java.util.Map;
import org.example.common.AuthGuideMessage;
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
        try {
            Map<String, String> signUpInfo = systemView.getSignUpInfo();
            User user = signUp(signUpInfo);
            systemView.successSignUp();
            return user;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
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
