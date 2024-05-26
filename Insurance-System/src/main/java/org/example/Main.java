package org.example;

import org.example.common.MainSystemConfig;
import org.example.user.AuthProcessType;
import org.example.view.SystemView;

public class Main {

  private static boolean PROGRAM_TRIGGER = false;

  public static void main(String[] args) {
    MainSystemConfig mainSystemConfig = new MainSystemConfig();
    Program program = mainSystemConfig.program();
    SystemView systemView = mainSystemConfig.systemView();
    systemView.introduce();
    while(!PROGRAM_TRIGGER){
      int selectNumber = systemView.selectAuthOption();
      AuthProcessType authProcessType = AuthProcessType.findProcessType(selectNumber).orElse(null);
      if(selectNumber == 3 && authProcessType == null) {
        PROGRAM_TRIGGER = true;
        continue;
      }
      authProcessType.getProcess().execute(systemView, program);
    }
  }
}