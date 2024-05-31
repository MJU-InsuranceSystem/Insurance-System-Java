package org.example.underwriteTeam.model;

/**
 * @author yoon
 * @version 1.0
 *
 */
public class UnderwritePolicy {
	private int policyId;
	private String policyName;
	private String content;

	public UnderwritePolicy(int policyId, String policyName, String content) {
		this.policyId = policyId;
		this.policyName = policyName;
		this.content = content;
	}

	public static UnderwritePolicy create(int policyId, String policyName, String content) {
		return new UnderwritePolicy(policyId, policyName, content);
	}
}