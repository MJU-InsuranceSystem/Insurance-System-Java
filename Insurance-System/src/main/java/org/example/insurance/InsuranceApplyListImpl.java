package org.example.insurance;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.example.domain.insurance.InsuranceApplication;

public class InsuranceApplyListImpl implements InsuranceApplyList{

    private static final List<InsuranceApplication> INSURANCE_APPLICATIONS = new ArrayList<>();


    @Override
    public void add(InsuranceApplication insurance) {
        INSURANCE_APPLICATIONS.add(insurance);
    }

    @Override
    public void remove(InsuranceApplication insurance) {
        if (insurance != null) {
            INSURANCE_APPLICATIONS.remove(insurance);
        }
    }

    @Override
    public void remove(int index) {
        if (INSURANCE_APPLICATIONS.get(index) != null) {
            INSURANCE_APPLICATIONS.remove(index);
        }
    }
    @Override
    public InsuranceApplication findById(int insuranceId) {
        return INSURANCE_APPLICATIONS.stream()
            .filter(insuranceApplication -> insuranceApplication.getInsuranceApplicationID() == insuranceId)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Insurance not found with ID: " + insuranceId));
    }

    @Override
    public InsuranceApplication findFirst() {
        return INSURANCE_APPLICATIONS.get(0);
    }


    @Override
    public void update(InsuranceApplication insurance) {

    }
}
