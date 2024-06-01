package org.example.domain.insurance;

import org.example.InsuranceListImpl;
import org.example.planTeam.design.model.reward.Reward;

/**
 * @author USER
 * @version 1.0
 */
public class Insurance {

    private int insuranceID;
    private String insuranceName;
    private int MonthPaymentFee;
    private String RestrictionRegulation;
    private Reward Reward;
    public InsuranceListImpl m_InsuranceListImpl;

    public Insurance() {

    }

    public void finalize() throws Throwable {

    }

}