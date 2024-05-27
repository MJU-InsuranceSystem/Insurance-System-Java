package org.example;

import java.util.HashMap;
import java.util.Map;
import org.example.common.AuthGuideMessage;
import org.example.config.TeamConfig;
import org.example.user.Customer;
import org.example.user.CustomerManager;
import org.example.user.User;
import org.example.user.UserType;
import org.example.user.Worker;
import org.example.user.WorkerManager;

public class InsuranceProgram implements Program {

    private final CustomerManager customerManager;
    private final WorkerManager workerManager;
    private final HashMap<Integer, Team> teamServiceMap = new HashMap<>();

    private final TeamConfig teamConfig;

    public InsuranceProgram(CustomerManager customerManager, WorkerManager workerManager) {
        teamConfig = new TeamConfig();
        this.customerManager = customerManager;
        this.workerManager = workerManager;
//    for(TeamOrder team : TeamOrder.values()){
//      teamServiceMap.put(team.getOrder(), teamConfig.getTeam(team.getOrder()));
//    }

    }

    @Override
    public User login(Map<String, String> authInfo) {
        String id = authInfo.get(AuthGuideMessage.AUTH_ID_KEY);
        String password = authInfo.get(AuthGuideMessage.AUTH_PASSWORD_KEY);
        return isExistUser(id, password);
    }

    @Override
    public User signUp(Map<String, String> authInfo) {
        UserType userType = UserType.find(authInfo.get(AuthGuideMessage.AUTH_CUSTOMER_WORKER_KEY));
        switch (userType) {
            case CUSTOMER -> {
                Customer customer = Customer.create(authInfo);
                customerManager.add(customer);
                return customer;
            }
            case WORKER -> {
                Worker worker = Worker.create(authInfo);
                workerManager.add(worker);
                return worker;
            }
        }
        return null;
    }

    @Override
    public void start(String userId) {

    }

    private User isExistUser(String id, String password) {
        if (workerManager.isExistByIdAndPassword(id, password)) {
            return workerManager.findByIdAndPassword(id, password).get();
        } else if (customerManager.isExistByIdAndPassword(id, password)) {
            return customerManager.findByIdAndPassword(id, password).get();
        }
        throw new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다");

    }
}
