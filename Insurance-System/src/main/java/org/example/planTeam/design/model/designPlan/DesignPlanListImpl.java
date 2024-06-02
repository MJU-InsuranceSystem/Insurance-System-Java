package org.example.planTeam.design.model.designPlan;


import java.util.ArrayList;
import java.util.List;
import org.example.planTeam.design.model.insurance.Insurance;

/**
 * @author yoon
 * @version 1.0
 */
public class DesignPlanListImpl implements DesignPlanList {

    private final List<DesignPlan> designPlanList;
    public DesignPlan m_DesignPlan;

    public DesignPlanListImpl() {
        designPlanList = new ArrayList<>();
    }

    public void finalize() throws Throwable {

    }

    public void add(DesignPlan designPlan) {
        designPlanList.add(designPlan);
    }

    public void delete() {

    }

    public Object read() {
        return null;
    }

    public void update() {

    }

    @Override
    public List<DesignPlan> getList() {
        return designPlanList;
    }

}