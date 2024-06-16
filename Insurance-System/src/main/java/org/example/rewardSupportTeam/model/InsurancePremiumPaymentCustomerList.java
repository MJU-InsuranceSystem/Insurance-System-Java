package org.example.rewardSupportTeam.model;

import org.example.complaint.usecase.ComplaintUseCase;
import org.example.user.Customer;

import java.util.List;

public interface InsurancePremiumPaymentCustomerList {
    public void add(Customer customer);

    public void delete(Customer customer);

    List<Customer> getAll();

    boolean contains(Customer customer);
}
