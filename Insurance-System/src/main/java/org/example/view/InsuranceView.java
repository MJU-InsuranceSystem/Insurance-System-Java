package org.example.view;

import java.util.Scanner;
import org.example.InsurancePlanTeam;
import org.example.Proposal;

public class InsuranceView {
private InputManager inputManager;
private OutputManager outputManager;
private InsurancePlanTeam insurancePlanTeam;
private Scanner sc;
    public InsuranceView(){
        inputManager = new InputManager();
        outputManager = new OutputManager();
        sc = new Scanner(System.in);
        insurancePlanTeam = new InsurancePlanTeam();
    }
    public void run() {
        // 상품을 기획한다.
        System.out.println("상품을 기획한다.");
        System.out.println("상품 설계안에 필요한 내용을 입력하세요.");
       Proposal proposal =  insurancePlanTeam.makeProrosal(inputManager, outputManager);

    }
}
