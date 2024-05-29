package org.example.asset.manager;

import org.example.asset.InvestScenario;
import org.example.asset.InvestScenarioListImpl;
import org.example.asset.LoanHistoryListImpl;
import org.example.Team;

public class AssetManagementTeam extends Team {

	public InvestScenario m_InvestScenario;
	public InvestScenarioListImpl m_InvestScenarioListImpl;
	public LoanHistoryListImpl m_LoanHistoryListImpl;

	public AssetManagementTeam(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void createStatistic(){

	}

	public void manage(){

	}

	@Override
	public void process(int processNum, int domainId) {

	}

	public void process(){

	}

	public Object readLoanHistory(){
		return null;
	}

	public void readStatisticHistory(){

	}

	public void register(){

	}

	public void remove(){

	}

	public Object retrieve(){

		return null;
	}

	public void saveSimulationResult(){

	}

}