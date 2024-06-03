package org.example.insurance;

import org.example.domain.insurance.InsuranceApplication;
import org.example.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class InsuranceChargeCustomerApplyListImpl implements InsuranceChargeCustomerApplyList {

    private static final List<Customer> INSURANCE_CHARGE_APPLICATIONS = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        INSURANCE_CHARGE_APPLICATIONS.add(customer);
    }

    @Override
    public void remove(Customer customer) {
        if (customer != null) {
            INSURANCE_CHARGE_APPLICATIONS.remove(customer);
        }
    }

    @Override
    public void remove(int index) {
        if (INSURANCE_CHARGE_APPLICATIONS.get(index) != null) {
            INSURANCE_CHARGE_APPLICATIONS.remove(index);
        }
    }

    @Override
    public Customer findById(int insuranceId) {
        return null;
    }

    @Override
    public Customer findFirst() {
        return INSURANCE_CHARGE_APPLICATIONS.get(0);
    }

    @Override
    public void update(Customer customer) {

    }
}
