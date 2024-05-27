package org.example.config;

import org.example.view.InsuranceSystemView;
import org.example.view.SystemView;

public class LoginConfig {
    private static SystemView loginView;
    public SystemView loginView(){
        return new InsuranceSystemView();
    }
}
