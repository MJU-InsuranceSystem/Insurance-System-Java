package org.example.contract;

import org.example.domain.insurance.Insurance;

public class Contract {

	private String customerName;
	private Insurance insurance;
	private String managerName;

	public String getCustomerName() {
		return customerName;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		return
				"customerName = " + customerName + '\n' +
				"insurance ID = " + insurance.getInsuranceID() + '\n' +
				"managerName = " + managerName ;
	}
}