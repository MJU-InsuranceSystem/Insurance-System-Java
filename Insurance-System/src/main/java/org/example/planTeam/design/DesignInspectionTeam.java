package org.example.planTeam.design;

import org.example.Team;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.planTeam.design.model.DesignPlanList;
import org.example.planTeam.design.model.DesignPlanListImpl;
import org.example.planTeam.design.model.Proposal;
import org.example.planTeam.design.model.ProposalList;
import org.example.planTeam.design.model.ProposalListImpl;

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
    public ResponseDto process(RequestDto request) {
        return null;
    }
    

    public ResponseDto process2(RequestDto request) {
        System.out.println("process2");
        return null;
    }

    @Override
    public void register() {

    }

    @Override
    public void remove() {

    }

    @Override
    public ResponseDto retrieve() {
        return null;
    }


}