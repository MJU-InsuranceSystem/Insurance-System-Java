package org.example;

import java.util.Arrays;
import org.example.designPlanTeam.view.DesignInspectionView;

public enum Department {
    DESIGN_PLAN_TEAM(1, new DesignInspectionView(), "상품 기획팀"),
    UNDER_WRITE_TEAM(2, null, "U/W팀");
    private final int order;
    private final TeamView teamView;
    private final String name;

    Department(int order, TeamView teamView, String name) {
        this.order = order;
        this.teamView = teamView;
        this.name = name;
    }

    public static Department findTeamByNumber(int selectTeamNumber) {
        return Arrays.stream(Department.values())
            .filter(department -> department.getOrder() == selectTeamNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 팀 번호를 찾을 수 없습니다."));
    }

    public int getOrder() {
        return order;
    }

    public TeamView getTeamController() {
        return teamView;
    }

    public String getName() {
        return name;
    }
}
