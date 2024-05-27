package org.example.user;

import org.example.Program;
import org.example.view.SystemView;

public interface Process {

    User execute(SystemView systemView, Program program);
}
