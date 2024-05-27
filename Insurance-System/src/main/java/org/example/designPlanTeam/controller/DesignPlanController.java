package org.example.designPlanTeam.controller;


import java.util.Map;
import org.example.controller.TeamController;
import org.example.designPlanTeam.DesignInspectionTeam;
import org.example.designPlanTeam.view.DesignInspectionView;

public class DesignPlanController implements TeamController {

    private final DesignInspectionTeam designInspectionTeam;

    public DesignPlanController() {
        this.designInspectionTeam = new DesignInspectionTeam();
    }


    @Override
    public void manage(Map<String, Object> model) {
        // 원래 모델 넣을껀데 너무 많이 고쳐야햄.
        designInspectionTeam.manage();
    }
}
