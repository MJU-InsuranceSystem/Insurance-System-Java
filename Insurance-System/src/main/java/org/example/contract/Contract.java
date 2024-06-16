package org.example.contract;

import org.example.domain.insurance.InsuranceApplication;

public class Contract {

	private int contractId;
	private String customerName;
	private InsuranceApplication insuranceApplication;
	private String managerName;

	public String getCustomerName() {
		return customerName;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public InsuranceApplication getInsuranceApplication() {
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
		return  "contract ID = " + contractId +"\n" +
				"customer Name = " + customerName + '\n' +
				"insurance ID = " + insuranceApplication.getInsuranceApplicationID() + '\n' +
				"insurance Type = " + insuranceApplication.getInsurance().getInsuranceType() + '\n' +
				"managerName = " + managerName ;
	}
}