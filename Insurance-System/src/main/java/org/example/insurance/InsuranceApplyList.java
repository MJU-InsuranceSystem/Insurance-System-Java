package org.example.insurance;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.insurance.Insurance;
import org.example.planTeam.design.model.insurance.InsuranceList;

public class InsuranceApplyList implements InsuranceList {

    private static final List<Insurance> INSURANCES = new ArrayList<>();


    @Override
    public void add(org.example.planTeam.design.model.insurance.Insurance insurance) {

    }

    @Override
    public void remove(org.example.planTeam.design.model.insurance.Insurance insurance) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public org.example.planTeam.design.model.insurance.Insurance findById(int insuranceId) {
        return null;
    }

    @Override
    public org.example.planTeam.design.model.insurance.Insurance findFirst() {
        return null;
    }


    @Override
    public void update(org.example.planTeam.design.model.insurance.Insurance insurance) {

    }

    @Override
    public List<org.example.planTeam.design.model.insurance.Insurance> getList() {
        return null;
    }
    

}
