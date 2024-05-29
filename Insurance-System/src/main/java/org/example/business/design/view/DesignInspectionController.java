package org.example.business.design.view;

import java.util.Arrays;
import java.util.Scanner;
import org.example.TeamController;
import org.example.business.design.DesignInspectionTeam;
import org.example.business.design.controller.dto.Request;
import org.example.business.design.controller.dto.RequestFactory;
import org.example.business.design.controller.dto.Response;

public class DesignInspectionController implements TeamController {

    public enum Function {
        planProposal(1), process(2), register(3), remove(4), retrieve(5), exit(6);
        private int order;

        Function(int order) {
            this.order = order;
        }

        public int getOrder() {
            return this.order;
        }

        public static Function findFunctionByNumber(int selectTeamNumber) {
            return Arrays.stream(Function.values())
                .filter(department -> department.getOrder() == selectTeamNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 팀 번호를 찾을 수 없습니다."));
        }
    }

    private boolean status;

    private final RequestFactory requestFactory;

    private final DesignTeamView designTeamView;

    private Scanner sc;
    // 얘는 공통으로 입력받는 객체 만들어서 뿌려야겠다.

    private final DesignInspectionTeam designTeam;

    public DesignInspectionController() {
        designTeam = new DesignInspectionTeam();
        sc = new Scanner(System.in);
        requestFactory = RequestFactory.getInstance();
        designTeamView = new DesignTeamView(sc);
    }

    @Override
    public void process() {
        status = true;
        while (status) {
            intro();
            int selectInt = sc.nextInt();
            status = service(Function.findFunctionByNumber(selectInt));
        }
    }

    private static void intro() {
        System.out.println("보험 설계팀임. 할 거 선택 하세요");
        for (Function function : Function.values()) {
            System.out.println(function.ordinal() + "번 " + function.name());
        }
    }


    public boolean service(Function function) {
        try {
            Request request = requestFactory.getRequest(function);
            request = designTeamView.process(function, request);
            Response response = designTeam.process(function, request);
            return designTeamView.process(function, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}
