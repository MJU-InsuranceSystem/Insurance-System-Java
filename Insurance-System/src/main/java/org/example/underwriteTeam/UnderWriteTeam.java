package org.example.underwriteTeam;

import org.example.InsuranceCompany;
import org.example.InsuranceCompanyList;
import org.example.Team;
import org.example.UnderwritePolicy;
import org.example.UnderwritePolicyListImpl;

/**
 * @author USER
 * @version 1.0
 *
 */

public class UnderWriteTeam extends Team {

	public InsuranceCompany m_InsuranceCompany;
	public InsuranceCompanyList m_InsuranceCompanyList;
	public UnderwritePolicy m_UnderwritePolicy;
	public UnderwritePolicyListImpl m_UnderwritePolicyListImpl;

	public UnderWriteTeam(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public void manage() {

	}

	@Override
	public void process(int processNum, int domainId) {

	}

	@Override
	public void register() {

	}

	@Override
	public void remove() {

	}

	@Override
	public Object retrieve() {
		return null;
	}
}