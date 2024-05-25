package org.example.main;

import org.example.view.InsuranceView;

public class Main {
    private InsuranceView insuranceView;
    public static void main(String[] args) {
      Main main = new Main();
      main.run();
    }

    private void run() {
        insuranceView = new InsuranceView();
        insuranceView.run();
    }
}