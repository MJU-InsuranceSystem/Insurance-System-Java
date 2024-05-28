package org.example.business.design;

import org.example.Team;
import org.example.business.design.controller.dto.Request;
import org.example.business.design.controller.dto.Response;
import org.example.business.design.view.DesignInspectionController.Function;

/**
 * @author USER
 * @version 1.0
 */
public class DesignInspectionTeam extends Team {

    private final ProposalList proposalList;
    private final DesignPlanList designPlanList;

    public DesignInspectionTeam() {
        proposalList = new ProposalListImpl();
        designPlanList = new DesignPlanListImpl();
    }

    public void finalize() throws Throwable {

    }

    @Override
    public void manage() {
        System.out.println("이제 처리할 꺼 처리한다.");
    }

    @Override
    public Response process(Function function, Request request) {
        return switch (function) {
            case planProposal -> registerPlanProposal(request);
            default -> registerPlanProposal(request);
        };
    }

    private Response registerPlanProposal(Request request) {
        Proposal proposal = new Proposal(request);
        return null;
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