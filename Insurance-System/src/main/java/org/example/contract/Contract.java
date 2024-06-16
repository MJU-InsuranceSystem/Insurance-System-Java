package org.example.contract;

import org.example.domain.insurance.InsuranceApplication;

public class Contract {

	private String customerName;
	private InsuranceApplication insuranceApplication;
	private String managerName;

	public String getCustomerName() {
		return customerName;
	}

	public InsuranceApplication getInsurance() {
		return insuranceApplication;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setInsurance(InsuranceApplication insuranceApplication) {
		this.insuranceApplication = insuranceApplication;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		return "customerName = " + customerName + '\n' +
						"insurance ID = " + insuranceApplication.getInsuranceApplicationID() + '\n' +
						"insurance Type = " + insuranceApplication.getInsuranceType() + '\n' +
						"managerName = " + managerName ;
	}
}