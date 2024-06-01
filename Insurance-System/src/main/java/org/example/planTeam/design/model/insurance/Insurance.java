package org.example.planTeam.design.model.insurance;

import org.example.planTeam.design.model.SaleTarget;
import org.example.planTeam.design.model.reward.Reward;

public class Insurance {

    private String insuranceName;
    private String responsiblePerson;
    private Reward reward;
    private String reightObligation;

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public String getReightObligation() {
        return reightObligation;
    }

    public void setReightObligation(String reightObligation) {
        this.reightObligation = reightObligation;
    }
}
