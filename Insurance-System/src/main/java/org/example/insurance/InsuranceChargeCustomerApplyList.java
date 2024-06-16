package org.example.insurance;

import org.example.domain.insurance.InsuranceApplication;
import org.example.user.Customer;

public interface InsuranceChargeCustomerApplyList {
    void add(Customer customer);

    void remove(Customer customer);

    void remove(int index);

    Customer findById(int insuranceId);

    Customer findFirst();

    void update(Customer insurance);

    boolean isEmpty();
}
