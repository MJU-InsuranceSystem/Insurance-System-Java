package org.example.team.customerManagement;

import org.example.user.customer.Customer;
import org.example.user.customer.CustomerList;

import java.util.List;

/**
 * @author USER
 * @version 1.0
 */
public class CustomerManageTeam {

	private final CustomerList customerList = CustomerList.getInstance();

	public void manage(){

	}

	public void process(){

	}

	public void register(){

	}

	public void remove(){

	}

	public List<Customer> retrieveCustomerInfo() {
		return customerList.getCustomerList();
	}
}