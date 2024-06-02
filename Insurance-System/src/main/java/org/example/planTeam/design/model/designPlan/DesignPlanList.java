package org.example.planTeam.design.model.designPlan;


import java.util.List;
import org.example.planTeam.design.model.insurance.Insurance;

/**
 * @author yoon
 * @version 1.0
 */
public interface DesignPlanList {

    void add(DesignPlan designPlan);

    void delete();

    Object read();

    void update();

    List<DesignPlan> getList();
}