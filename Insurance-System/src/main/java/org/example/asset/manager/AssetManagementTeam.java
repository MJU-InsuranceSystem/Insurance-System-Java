package org.example.asset.manager;

import org.example.asset.InvestScenario;
import org.example.asset.InvestScenarioListImpl;
import org.example.asset.LoanHistoryListImpl;
import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

public class AssetManagementTeam extends Team {

	public InvestScenario m_InvestScenario;
	public InvestScenarioListImpl m_InvestScenarioListImpl;
	public LoanHistoryListImpl m_LoanHistoryListImpl;

	public AssetManagementTeam(){

	}

	@Override
	public ResponseDto manage(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto process(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto register(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto remove(RequestDto request) {
		return null;
	}

	@Override
	public ResponseDto retrieve(RequestDto request) {
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