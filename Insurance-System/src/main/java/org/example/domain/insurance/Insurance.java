package org.example.domain.insurance;

import org.example.insurance.InsuranceType;
import org.example.rewardSupportTeam.Reward;
/**
 * @author USER
 * @version 1.0
 */
public class Insurance {

	private int insuranceID;
	private String subscriberName;
	private int monthPaymentFee;
	private String RestrictionRegulation;
	private Reward Reward;
	private InsuranceType insuranceType;
	private String details;
	private String accountNumber;

	public String getDetails() {
		return details;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public int getInsuranceID() {
		return insuranceID;
	}

	public String getSubscriberName() {
		return subscriberName;
	}

	public int getMonthPaymentFee() {
		return monthPaymentFee;
	}

	public String getRestrictionRegulation() {
		return RestrictionRegulation;
	}

	public org.example.rewardSupportTeam.Reward getReward() {
		return Reward;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public void setMonthPaymentFee(int monthPaymentFee) {
		this.monthPaymentFee = monthPaymentFee;
	}

	public void setRestrictionRegulation(String restrictionRegulation) {
		RestrictionRegulation = restrictionRegulation;
	}

	public void setReward(org.example.rewardSupportTeam.Reward reward) {
		Reward = reward;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}