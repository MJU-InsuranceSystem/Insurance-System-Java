package org.example.user;

import java.util.Map;
import org.example.Program;
import org.example.view.SystemView;

public class SignUpProcess implements Process {

    private static final SignUpProcess SIGN_UP_PROCESS = new SignUpProcess();

    private SignUpProcess() {

    }

    @Override
    public User execute(SystemView systemView, Program program) {
        try {
            Map<String, String> signUpInfo = systemView.getSignUpInfo();
            User user = program.signUp(signUpInfo);
            systemView.successSignUp();
            return user;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Process getInstance() {
        return SIGN_UP_PROCESS;
    }
}
