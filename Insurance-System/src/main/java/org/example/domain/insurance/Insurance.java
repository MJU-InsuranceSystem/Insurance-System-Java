package org.example.domain.insurance;

import org.example.InsuranceListImpl;

/**
 * @author USER
 * @version 1.0
 */
public class Insurance {

	private int insuranceID;
	private String insuranceName;
	private int MonthPaymentFee;
	private String RestrictionRegulation;
	private org.example.Reward Reward;
	public InsuranceListImpl m_InsuranceListImpl;

	public Insurance(){

	}

	public void finalize() throws Throwable {

	}

}