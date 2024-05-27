package org.example;

public enum TeamSet {
    designPlanTeam(1),underWriteTeam(2);
    private final int order;
    TeamSet(int order){
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
