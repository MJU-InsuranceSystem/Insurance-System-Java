package org.example.user;

import java.util.Map;
import org.example.Program;
import org.example.view.SystemView;

public class LoginProcess implements Process {

    private static final LoginProcess LOGIN_PROCESS = new LoginProcess();

    private LoginProcess() {

    }

    @Override
    public User execute(SystemView systemView, Program program) {
        try {
            Map<String, String> loginInfo = systemView.getLoginInfo();
            User user = program.login(loginInfo);
            systemView.successLogin();
            return user;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Process getInstance() {
        return LOGIN_PROCESS;
    }
}
