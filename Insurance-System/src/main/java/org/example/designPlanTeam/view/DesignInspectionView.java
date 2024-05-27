package org.example.designPlanTeam.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.example.TeamView;
import org.example.designPlanTeam.DesignInspectionTeam;
import org.example.designPlanTeam.controller.DesignPlanController;

public class DesignInspectionView implements TeamView {

    public enum Function {
        manage, process, register, remove, retrieve
    }

    private Scanner sc;
    // 얘는 공통으로 입력받는 객체 만들어서 뿌려야겠다.

    private DesignPlanController designPlanController;

    public DesignInspectionView() {
        this.designPlanController = new DesignPlanController();
        sc = new Scanner(System.in);
    }

    @Override
    public void process() {
        while (true) {
            System.out.println("보험 설계팀임. 할 거 선택 하세요");

            for (Function function : Function.values()) {
                System.out.println(function.ordinal() + "번 " + function.name());
            }
            service(sc.next());
        }
    }


    public void service(String number) {
        Map<String, Object> model = new HashMap<>();
        switch (number) {
            case "1":
                System.out.println("상품 기획하기 업무를 선택하셨습니다.");
                model.put("앙", sc.next());
                System.out.println("상품 기획하기 업무를 선택하셨습니다.");
                model.put("왓떠,,", sc.next());
                designPlanController.manage(model);
                // 뭐 또 입력하고 그런거 반복..하다가 이제 등록할 때 서비스 호출
                break;
        }
    }

}
