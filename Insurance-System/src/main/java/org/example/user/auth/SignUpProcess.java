package org.example.user.auth;

import java.util.Map;
import org.example.user.customer.Customer;
import org.example.user.customer.CustomerList;
import org.example.user.User;
import org.example.user.UserType;
import org.example.user.worker.Worker;
import org.example.user.worker.WorkerList;
import org.example.common.view.SystemView;

public class SignUpProcess implements Process {

    private final CustomerList customerList;
    private final WorkerList workerList;

    public SignUpProcess(CustomerList customerList, WorkerList workerList) {
        this.customerList = customerList;
        this.workerList = workerList;
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
                customerList.add(customer);
                return customer;
            }
            case WORKER -> {
                Worker worker = Worker.create(signUpInfo);
                workerList.add(worker);
                return worker;
            }
            default -> {
                throw new IllegalArgumentException("지원하지 않는 유형입니다");
            }
        }
    }
}
