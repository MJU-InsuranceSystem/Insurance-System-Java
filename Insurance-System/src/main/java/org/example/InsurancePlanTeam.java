package org.example;

/**
 * @author USER
 * @version 1.0
 */
public class InsurancePlanTeam extends Team {

	public Proposal proposal;
	public ProposalListImpl m_ProposalListImpl;
	public DesignPlan designPlan;
	public DesignPlanListImpl m_DesignPlanListImpl;

	public InsurancePlanTeam(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void manage(){

	}

	@Override
	public void process(int processNum, int domainId) {

	}

	public void process(){

	}

	public void register(){
	}

	public void remove(){

	}

	public void requestInspection(){

	}

	public Object retrieve(){
		return null;
	}

	public void suspendInsurance(){

	}

//	public Proposal makeProrosal(InputManager inputManager, OutputManager outputManager) {
//		System.out.println("기획안 이름을 입력하세요.");
//		proposal.setTitle(outputManager.writeString());
//		System.out.println("조사한 시장에 대한 정보를 입력하세요.");
//		proposal.setMarketResearch(outputManager.writeString());
//		System.out.println("상품에 대한 개요를 입력해주세요.");
//		proposal.setProductOverview(outputManager.writeString());
//		System.out.println("판매 전략을 입력해주세요.");
//		proposal.setSaleStrategy();
//		System.out.println("예상되는 판매 대상을 입력해주세요.");
//		proposal.setSaleTarget();
//		proposal.setReward(makeReward());
//		return proposal;
//	}
}