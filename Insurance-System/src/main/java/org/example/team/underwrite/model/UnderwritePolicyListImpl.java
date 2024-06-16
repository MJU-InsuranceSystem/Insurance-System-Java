package org.example.team.underwrite.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yoon
 * @version 1.0
 *
 */
public class UnderwritePolicyListImpl implements UnderwritePolicyList {

	private static final List<UnderwritePolicy> underwritePolicyList = new ArrayList<>();

	@Override
	public void add(UnderwritePolicy underwritePolicy) {
		if (underwritePolicy != null) {
			underwritePolicyList.add(underwritePolicy);
		}
	}

	@Override
	public void delete(UnderwritePolicy underwritePolicy) {

	}

	@Override
	public UnderwritePolicy read(int policyId) {
		return null;
	}

	@Override
	public void update(UnderwritePolicy underwritePolicy) {

	}
}