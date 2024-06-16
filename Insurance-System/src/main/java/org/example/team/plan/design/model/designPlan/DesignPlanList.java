package org.example.team.plan.design.model.designPlan;


import java.util.List;

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