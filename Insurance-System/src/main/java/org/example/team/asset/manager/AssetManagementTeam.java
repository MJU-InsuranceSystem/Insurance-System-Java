package org.example.team.asset.manager;

import org.example.team.asset.InvestScenario;
import org.example.team.asset.InvestScenarioListImpl;
import org.example.team.asset.LoanHistoryListImpl;
import org.example.team.Team;
import org.example.common.dto.RequestVO;
import org.example.common.dto.ResponseVO;

public class AssetManagementTeam extends Team {

	public InvestScenario m_InvestScenario;
	public InvestScenarioListImpl m_InvestScenarioListImpl;
	public LoanHistoryListImpl m_LoanHistoryListImpl;

	public AssetManagementTeam(){

	}

	@Override
	public ResponseVO manage(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO process(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO register(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO remove(RequestVO request) {
		return null;
	}

	@Override
	public ResponseVO retrieve(RequestVO request) {
		return null;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void createStatistic(){

	}

	public Object readLoanHistory(){
		return null;
	}

	public void readStatisticHistory(){

	}

	public void saveSimulationResult(){

	}

}