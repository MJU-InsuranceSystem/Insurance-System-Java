package org.example.planTeam.design.model.insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author USER
 * @version 1.0
 */
public class InsuranceListImpl implements InsuranceList {

    private static final List<Insurance> insurances = new ArrayList<>();


    @Override
    public void add(Insurance insurance) {
        insurances.add(insurance);
    }

    @Override
    public void remove(Insurance insurance) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public Insurance findById(int insuranceId) {
        return insurances.stream()
            .filter(insurance -> insurance.getInsuranceId() == String.valueOf(insuranceId))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Insurance not found with ID: " + insuranceId));
    }

    @Override
    public Insurance findFirst() {
        return null;
    }

    @Override
    public void update(Insurance insurance) {

    }

    @Override
    public List<Insurance> getList() {

        return insurances;
    }
}