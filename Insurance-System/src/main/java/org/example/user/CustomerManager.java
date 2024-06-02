package org.example.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerManager {

    public static final CustomerManager CUSTOMER_MANAGER = new CustomerManager();
    private final List<Customer> customers = new ArrayList<>();

    private CustomerManager() {

    }

    public static CustomerManager getInstance() {
        return CUSTOMER_MANAGER;
    }

    public void add(Customer customer) {
        customers.add((customer));
    }

    public boolean isExistByIdAndPassword(String id, String password) {
        return customers.stream()
            .anyMatch(
                customer -> customer.getId().equals(id) && customer.getPassword().equals(password));
    }

    public Optional<Customer> findByIdAndPassword(String id, String password) {
        return customers.stream()
            .filter(
                customer -> customer.getId().equals(id) && customer.getPassword().equals(password))
            .findFirst();
    }

    public Optional<Customer> findByName(String name) {
        return customers.stream()
                .filter(
                        customer -> customer.getName().equals(name)
                ).findFirst();
    }
}
