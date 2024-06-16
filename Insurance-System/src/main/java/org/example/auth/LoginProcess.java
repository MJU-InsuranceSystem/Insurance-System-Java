package org.example.auth;

import java.util.Map;

import org.example.common.AuthUtil;
import org.example.user.CustomerList;
import org.example.user.User;
import org.example.user.WorkerList;
import org.example.common.view.SystemView;

public class LoginProcess implements Process {

    private final CustomerList customerList;
    private final WorkerList workerList;

    public LoginProcess(CustomerList customerList, WorkerList workerList) {
        this.customerList = customerList;
        this.workerList = workerList;
    }

    @Override
    public User execute(SystemView systemView) {
            Map<String, String> loginInfo = systemView.getLoginInfo();
            User user = login(loginInfo);
            AuthUtil.user = user;
            user.login();
            systemView.successLogin();
            return user;
    }

    private User login(Map<String, String> loginInfo) {
        String id = loginInfo.get(AuthGuideMessage.AUTH_ID_KEY);
        String password = loginInfo.get(AuthGuideMessage.AUTH_PASSWORD_KEY);
        return findUser(id, password);
    }

    private User findUser(String id, String password) {
        if (workerList.isExistByIdAndPassword(id, password)) {
            return workerList.findByIdAndPassword(id, password).get();
        }
        if (customerList.isExistByIdAndPassword(id, password)) {
            return customerList.findByIdAndPassword(id, password).get();
        }
        throw new IllegalArgumentException("아이디 또는 비밀번호가 틀렸습니다");
    }
}
