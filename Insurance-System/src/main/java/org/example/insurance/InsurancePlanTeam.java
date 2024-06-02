package org.example.insurance;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.model.designPlan.DesignPlan;
import org.example.planTeam.design.model.designPlan.DesignPlanListImpl;
import org.example.planTeam.design.model.proposal.Proposal;
import org.example.planTeam.design.model.proposal.ProposalListImpl;

/**
 * @author USER
 * @version 1.0
 */
public class InsurancePlanTeam extends Team {

    public Proposal proposal;
    public ProposalListImpl m_ProposalListImpl;
    public DesignPlan designPlan;
    public DesignPlanListImpl m_DesignPlanListImpl;

    public InsurancePlanTeam() {

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

    public void requestInspection() {

    }

    public void suspendInsurance() {

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