package org.example.user;

import org.example.Program;
import org.example.view.SystemView;

public interface Process {
  void execute(SystemView systemView, Program program);
}
