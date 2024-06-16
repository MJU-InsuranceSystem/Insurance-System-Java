package org.example.team.underwrite.model;

/**
 * @author yoon
 * @version 1.0
 *
 */
public class UnderwritePolicy {
	private int policyId;
	private String policyName;
	private String riskInfo;
	private String premiumInfo;
	private String subscriptionInfo;

	public int getPolicyId() {
		return policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public String getRiskInfo() {
		return riskInfo;
	}

	public String getPremiumInfo() {
		return premiumInfo;
	}

	public String getSubscriptionInfo() {
		return subscriptionInfo;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public void setPremiumInfo(String premiumInfo) {
		this.premiumInfo = premiumInfo;
	}

	public void setSubscriptionInfo(String subscriptionInfo) {
		this.subscriptionInfo = subscriptionInfo;
	}
}