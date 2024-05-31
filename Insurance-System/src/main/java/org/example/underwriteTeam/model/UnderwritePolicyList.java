package org.example.underwriteTeam.model;

/**
 * @author yoon
 * @version 1.0
 *
 */
public interface UnderwritePolicyList {

	void add(UnderwritePolicy underwritePolicy);

	void delete(UnderwritePolicy underwritePolicy);

	UnderwritePolicy read(int policyId);

	void update(UnderwritePolicy underwritePolicy);
}