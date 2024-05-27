package org.example;

import java.util.Map;
import org.example.user.User;

public interface Program {

    User login(Map<String, String> authInfo);

    User signUp(Map<String, String> authInfo);

    void start(String userId);
}
