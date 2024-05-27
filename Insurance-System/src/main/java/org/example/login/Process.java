package org.example.login;

import org.example.user.User;
import org.example.view.SystemView;

public interface Process {

    User execute(SystemView systemView);
}
