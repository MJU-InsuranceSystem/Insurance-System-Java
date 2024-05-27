package org.example;

import org.example.controller.TeamController;
import org.example.designPlanTeam.controller.DesignPlanController;
import org.example.designPlanTeam.view.DesignInspectionView;

public enum Department {
    designPlanTeam(1, new DesignInspectionView(), "상품 기획팀"), underWriteTeam(2, null,
        "U/W팀");
    private final int order;
    private final TeamView team;
    private final String name;

    Department(int order, TeamView team, String name) {
        this.order = order;
        this.team = team;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public TeamView getTeamController() {
        return team;
    }

    public String getName() {
        return name;
    }
}
