package org.example.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerList {

    public static final CustomerList CUSTOMER_MANAGER = new CustomerList();
    private final List<Customer> customers = new ArrayList<>();

    private CustomerList() {
        Customer customer = new Customer();
        customer.id = String.valueOf(2);
        customer.password = String.valueOf(2);
        customer.name = "test";
        customer.userType = UserType.CUSTOMER;
        customers.add(customer);
    }

    public static CustomerList getInstance() {
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

    public List<Customer> getCustomerList() {
        return customers;
    }
}
