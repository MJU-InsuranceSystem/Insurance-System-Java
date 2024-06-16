package org.example.insurance.apply;

import org.example.user.customer.Customer;

public interface InsuranceChargeCustomerApplyList {
    void add(Customer customer);

    void remove(Customer customer);

    void remove(int index);

    Customer findById(int insuranceId);

    Customer findFirst();

    void update(Customer insurance);

    boolean isEmpty();
}
