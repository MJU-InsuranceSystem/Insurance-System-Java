package org.example.main;

import org.example.common.MainSystemConfig;
import org.example.controller.FrontController;

public class Main {

    public static void main(String[] args) {
        MainSystemConfig mainSystemConfig = new MainSystemConfig();
        FrontController frontController = mainSystemConfig.frontController();
        frontController.run();
    }
}