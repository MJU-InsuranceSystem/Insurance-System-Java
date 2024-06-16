package org.example.team.rewardSupport.model;

import org.example.user.customer.Customer;

import java.util.List;

public interface InsurancePremiumPaymentCustomerList {
    public void add(Customer customer);

    public void delete(Customer customer);

    List<Customer> getAll();

    boolean contains(Customer customer);
}
