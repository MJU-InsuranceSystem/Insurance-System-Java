package org.example.user.auth;

import org.example.user.User;
import org.example.common.view.SystemView;

public interface Process {

    User execute(SystemView systemView);
}
