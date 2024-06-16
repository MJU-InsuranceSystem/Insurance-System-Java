package org.example.common.config;

import org.example.user.auth.AuthController;
import org.example.user.customer.CustomerSystem;
import org.example.common.controller.FrontController;
import org.example.user.worker.WorkerSystem;
import org.example.common.view.InsuranceSystemView;
import org.example.common.view.SystemView;
import org.example.insurance.apply.InsuranceApplyListImpl;
import org.example.insurance.apply.InsuranceChargeCustomerApplyListImpl;
import org.example.team.rewardSupport.model.AccidentListImpl;
import org.example.insurance.InsuranceListImpl;
import org.example.team.rewardSupport.model.InsurancePremiumPaymentCustomerListImpl;
import org.example.user.customer.CustomerProcessManager;
import org.example.user.customer.CustomerView;

public class MainSystemConfig {

    public FrontController frontController() {
        return new FrontController(systemView(), authController(), customerSystem(), workerSystem());
    }

    private static SystemView systemView() {
        return new InsuranceSystemView();
    }

    private AuthController authController() {
        return new AuthController(systemView());
    }


    private CustomerSystem customerSystem() {
    return new CustomerSystem(systemView(), customerView(), customerProcessManager(), new InsuranceListImpl());
    }

    private CustomerView customerView() {
        return new CustomerView();
    }

    private CustomerProcessManager customerProcessManager() {
        return new CustomerProcessManager(new InsuranceApplyListImpl(), new InsuranceChargeCustomerApplyListImpl(), new AccidentListImpl(), new InsurancePremiumPaymentCustomerListImpl() {
        });
    }

    private WorkerSystem workerSystem() {
        return new WorkerSystem(systemView());
    }

}
