package org.example.insurance.reward;

/**
 * @author yoon
 * @version 1.0
 */
public class Reward {

    private int rewardId;
    private int MaxReward;
    private int MonthPaymentFee;
    private int insuranceRate;
    private String RestrictionRegulation;

    public Reward() {

    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public int getMaxReward() {
        return MaxReward;
    }

    public void setMaxReward(int maxReward) {
        MaxReward = maxReward;
    }

    public int getMonthPaymentFee() {
        return MonthPaymentFee;
    }

    public void setMonthPaymentFee(int monthPaymentFee) {
        MonthPaymentFee = monthPaymentFee;
    }

    public String getRestrictionRegulation() {
        return RestrictionRegulation;
    }

    public void setRestrictionRegulation(String restrictionRegulation) {
        RestrictionRegulation = restrictionRegulation;
    }

    public int getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(int insuranceRate) {
        this.insuranceRate = insuranceRate;
    }
}