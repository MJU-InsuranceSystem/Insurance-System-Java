package org.example.designPlanTeam;

import org.example.Team;

/**
 * @author USER
 * @version 1.0
 */
public class DesignInspectionTeam extends Team {

    private Class DesignPlan;

    public DesignInspectionTeam() {

    }

    public void finalize() throws Throwable {

    }

    @Override
    public void manage() {
        System.out.println("이제 처리할 꺼 처리한다.");
    }

    @Override
    public void process(int processNum, int domainId) {

    }

    @Override
    public void register() {

    }

    @Override
    public void remove() {

    }

    @Override
    public Object retrieve() {
        return null;
    }

    public void inspectDesign(Class DesignPlan) {

    }

}